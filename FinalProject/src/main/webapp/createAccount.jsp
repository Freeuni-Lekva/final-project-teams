<%--
  Created by IntelliJ IDEA.
  User: shmagi
  Date: 29.07.22
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<body>
    <form action="CreateAccountServlet" method="post">
        <input type="text" placeholder="Name" name="UserName" id="UserName">
        <input type="text" placeholder="Password" name="Password" id ="Password">
        <input type="submit" value="register"><br>
    </form>
</body>
</html>
