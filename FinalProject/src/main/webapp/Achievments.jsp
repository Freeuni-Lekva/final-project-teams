<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<html>
<head>
    <title>Achievements</title>
</head>
<body>

<h4>${QuizCreated} Quizzes Created</h4>
<form action="/QuizServletGetHistory" method="GET" >
   <button type="submit">See Quizzes Created By </button>
</form>

<h4>${QuizTaken} Different Quiz Taken</h4>
<form action="/QuizServletGetHistory" method="GET" >
   <button type="submit">See Best Scores For each Quiz Written By </button>
</form>

     <div align="center">

        <table border="1" cellpadding="5">

            <caption><h2>History Of All Quizzes</h2></caption>

            <tr>
                <th>Quiz_Id</th>
                <th>Username</th>
                <th>Score</th>
                <th>Time</th>
            </tr>


        </table>

</body>
</html>