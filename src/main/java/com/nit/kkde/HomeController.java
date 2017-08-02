package com.nit.kkde;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.kkde.dao.QuestionDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/")
	public String getNextQuestion(HttpServletRequest request, Model model){
		try{
		int level;
		Object levelObject=request.getSession().getAttribute("level");
		if(levelObject==null){
			level=1;
			request.getSession().setAttribute("level", 1);
			request.getSession().setAttribute("score", 0);
		}
		else{
			level=(Integer) levelObject;
			level++;
			request.getSession().setAttribute("level", level);

		}
		
		QuestionDAO questionDao=new QuestionDAO();
		Map<String, String> question=questionDao.getQuestion(level);
		if(null==question.get("question")){
			model.addAttribute("message", "congratulations , you have passed all the levels and your score is  ="+request.getSession().getAttribute("score"));
			request.getSession().removeAttribute("level");
			request.getSession().removeAttribute("score");
			return "message";
		}
		model.addAttribute("question", question.get("question"));
		model.addAttribute("option1", question.get("option1"));
		model.addAttribute("option2", question.get("option2"));
		model.addAttribute("option3", question.get("option3"));
		model.addAttribute("option4", question.get("option4"));
		model.addAttribute("id", question.get("id"));
		request.getSession().setAttribute("answer", question.get("answer"));
		return "question";
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("message", "some error occured "+ e.getMessage());
			request.getSession().removeAttribute("level");
			request.getSession().removeAttribute("score");
			return "message";
		}
		
	}
	@RequestMapping(value="/check_answer_and_get_result")
	public String checkanswerandgetQuestion(HttpServletRequest request, Model model){
		
		String answer=(String) request.getSession().getAttribute("answer");
		String useranswer=request.getParameter("user_answer");
		if(answer!=null && answer.equalsIgnoreCase(useranswer)){
			int score=(Integer) request.getSession().getAttribute("score");
			score=score+10;
			request.getSession().setAttribute("score", score);
			return getNextQuestion(request, model);
		}
		else{
			model.addAttribute("message","Incorrect answer !!!, correct answer was =" +answer + " and your total score = "+request.getSession().getAttribute("score"));
			request.getSession().removeAttribute("level");
			request.getSession().removeAttribute("score");
			return "message";
		}
			
		
		
	}
	
}
