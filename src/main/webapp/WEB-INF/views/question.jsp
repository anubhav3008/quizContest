<h1>
${question}
</h1>
<form action="check_answer_and_get_result" method="POST">
  <input type="radio" name="user_answer" value="${option1}"> ${option1}<br>
  <input type="radio" name="user_answer" value="${option2}"> ${option2}<br>
  <input type="radio" name="user_answer" value="${option3}"> ${option3} <br>
  <input type="radio" name="user_answer" value="${option4}"> ${option4} <br>
  <input type="submit">
</form>