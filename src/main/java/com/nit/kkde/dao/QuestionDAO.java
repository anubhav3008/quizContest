package com.nit.kkde.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class QuestionDAO {

	
	public Map<String, String> getQuestion(int level) throws SQLException{
		Map<String, String> question=new HashMap<String, String>();
		System.out.println("oracle Connect Example.");
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/quiz";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
	
		String query = "SELECT id,question,option1,option2,option3,option4,questionlevel,answer FROM question WHERE questionlevel = "+level;  
		try
		{
			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, userName, password);

			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(query);
		
			while (rs.next())
			{
				question.put("id", rs.getInt("id")+"");
				question.put("question", rs.getString("question"));
				question.put("option1", rs.getString("option1"));
				question.put("option2", rs.getString("option2"));
				question.put("option3", rs.getString("option3"));
				question.put("option4", rs.getString("option4"));
				question.put("level", rs.getString("questionlevel"));
				question.put("answer", rs.getString("answer"));
				break;
		}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(con!=null)
			con.close();
			System.out.println("Disconnected from database");
		}
		return question;
	}

}
