<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<html>
<head>
    <title>HisToryOfQuiz</title>
</head>
<body>


<h4>${maxxx}</h4>

<% ArrayList<String> Q_IDS = (ArrayList) request.getAttribute("Quiz_Ids"); %>
<% ArrayList<String> USERS = (ArrayList) request.getAttribute("Usernames"); %>
<% ArrayList<String> SCORES = (ArrayList) request.getAttribute("Scores"); %>
<% ArrayList<String> Times = (ArrayList) request.getAttribute("Times"); %>

     <div align="center">

        <table border="1" cellpadding="5">

            <caption><h2>History Of All Quizzes</h2></caption>

            <tr>
                <th>Quiz_Id</th>
                <th>Username</th>
                <th>Score</th>
                <th>Time</th>
            </tr>

                <%
                 	Iterator<String> iterator_QI = Q_IDS.iterator();
                	Iterator<String> iterator_U = USERS.iterator();
                    Iterator<String> iterator_S = SCORES.iterator();
                    Iterator<String> iterator_T = Times.iterator();

                 	while(iterator_QI.hasNext())
                 	{
             		String S1 = iterator_QI.next();
               		String S2 = iterator_U.next();
            		String S3 = iterator_S.next();
               		String S4 = iterator_T.next();
                 	%>
                	<tr>
         	            	<td><%= S1 %> </td>
         	            	<td><%= S2 %> </td>
                         	<td><%= S3 %> </td>
                         	<td><%= S4 %> </td>
                   	</tr>
                    <%
                 	}
                    %>

        </table>
    </div>

        <form action="/CustomQuizStatsServlet" method="GET" >

            <label for="quiz_name">Custom Quiz Id</label>
            <input type="text" name="quiz_name" value="${quiz_name}" /><br/>

            <label for="ORDER_BY">SORT BY</label>
            <input type="radio"  value="0" name="sort" checked> DEFOULT
            <input type="radio"  value="1" name="sort"> TIME
            <input type="radio"  value="2" name="sort"> SCORE
            <button type="submit">Quiz Stats</button>
        </form>

        ${MaxS}
</body>
</html>