<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>HisToryOfQuiz</title>
</head>
<body>
<h4>NO ER</h4>

<c:forEach var="var" items="${pagewmes}" varStatus="status", begin=””, end=””, step=””>
<c:out value="${var}"/>
</c:forEach>

    <h4>${Quiz_Ids}</h4>
    <h4>${Usernames}</h4>
    <h4>${Scores}</h4>
    <h4>${Times}</h4>

     <div align="center">

        <table border="1" cellpadding="5">

            <caption><h2>History Of All Quizzes</h2></caption>

            <tr>
                <th>Quiz_Id</th>
                <th>Username</th>
                <th>Score</th>
                <th>Time</th>
            </tr>
            <tr>
                        <td>IDS</td>
                        <td>NAME</td>
                        <td>SC</td>
                        <td>T</td>
            </tr>
        </table>
    </div>

        <form action="/CustomQuizStatsServlet" method="GET" >

            <label for="quiz_id">Custom Quiz Id</label>
            <input type="text" name="quiz_id" value="${quiz_id}" /><br/>

            <label for="ORDER_BY">SORT BY</label>
            <input type="radio"  value="0" name="sort" checked> DEFOULT
            <input type="radio"  value="1" name="sort"> TIME
            <input type="radio"  value="2" name="sort"> SCORE
            <button type="submit">Quiz Stats</button>
        </form>
        ${MaxS}
</body>
</html>