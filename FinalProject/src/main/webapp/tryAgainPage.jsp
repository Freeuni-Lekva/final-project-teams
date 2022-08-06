<%--
  Created by IntelliJ IDEA.
  User: nutsu
  Date: 8/4/2022
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Try Again</title>
</head>
<body>
<h1>User Name or Password was incorrect, Try Again please</h1>
<form action="/LoginServlet" method="POST" >
    <input type="text" placeholder="Name" name="UserName" id="UserName">
    <input type="text" placeholder="Password" name="Password" id ="Password">
    <input type="submit" value="login"><br>
</form>
<a href="createAccount.jsp">Create New Account</a>
</body>
</html>
