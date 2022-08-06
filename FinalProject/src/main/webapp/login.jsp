<%--
  Created by IntelliJ IDEA.
  User: shmagi
  Date: 29.07.22
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/LoginServlet" method="POST" >
        <input type="text" placeholder="Name" name="UserName" id="UserName">
        <input type="text" placeholder="Password" name="Password" id ="Password">
        <input type="submit" value="login"><br>
    </form>
  <a href="createAccount.jsp">Create New Account</a>
</body>
</html>
