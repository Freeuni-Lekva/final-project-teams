h<%@ page import="Quizzes.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DAOs.quizzesDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: shmagi
  Date: 30.07.22
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
%>
<%
    Quiz quiz = (Quiz) application.getAttribute("QUIZ");
    quizzesDAO quizDB = (quizzesDAO) application.getAttribute("QUIZ_DB");
//    quiz = quizDB.getQuiz(11);
//    Quiz quiz = new Quiz();
//    quiz.addProblem(new Problem(new questionResponseQuestion("what is 1 + 1?"),  new questionResponseAnswer("2")));
//    quiz.addProblem(new Problem(new questionResponseQuestion("which year was computer created?"),  new questionResponseAnswer("1945")));
//    quiz.addProblem(new Problem(new fillBlankQuestion("which year", "computer created?"),  new fillBlankAnswer("1945")));
//
//    multipleChoiceAnswer mca1 = new multipleChoiceAnswer();
//    mca1.addAnswer("12");
//    mca1.addAnswer("55");
//    mca1.addAnswer("3124");
//    mca1.addAnswer("45");
//    quiz.addProblem(new Problem(new multipleChoiceQuestion("which year was computer created?"),  mca1));
//
//    quiz.addProblem(new Problem(new pictureResponseQuestion("images/BaltimoreOriole.png"),  new pictureResponseAnswer("Baltimore Oriole")));

//    fillBlankAnswer ans = new fillBlankAnswer("sdd");

    if(quiz.getQuizType().equals(quiz.MULTIPLE_PAGE) && request.getSession().getAttribute("LAST_ID") == null){
        request.getSession().setAttribute("USER_MARK", "0");
        request.getSession().setAttribute("LAST_ID", "0");
    }
%>


<html>
    <head>
        <title>Quiz</title>
    </head>
    <body>
        <form name="quiz" method="post" action="markQuizServlet">
            <ol>
                <%
                    ArrayList<Problem> list = quiz.getQuiz();
                    if(quiz.getQuizType().equals(quiz.SINGLE_PAGE)){
                        for(int i = 0; i < list.size(); i++){
                            out.println("<li>");
                            out.println(list.get(i).getQuestion().questionHtmlCode());
                            out.println(list.get(i).getAnswer().answerPromptHtmlCode(i));
                            out.println("</li>");
                        }
                    } else if(quiz.getQuizType().equals(quiz.MULTIPLE_PAGE)){
                        int lastId = Integer.parseInt((String)request.getSession().getAttribute("LAST_ID"));
                        out.println(list.get(lastId).getQuestion().questionHtmlCode());
                        out.println(list.get(lastId).getAnswer().answerPromptHtmlCode(lastId));
                    }

                %>
            </ol>
            <input type="submit" value="Next">
        </form>

    </body>
</html>
