<%--
  Created by IntelliJ IDEA.
  User: nutsu
  Date: 8/10/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Message</title>
</head>
<head><title>Add Friend</title>
</head>
<body>
<form action="/sendMessageServlet" method="POST" >
    <h2>Login</h2>
    <input type="text" placeholder="Username" name="UserNameOfOtherUser" id="UserNameOfOtherUser">
    <input type="text" placeholder="Send Message" name="MessageToUser" id="MessageToUser">
    <input type="submit" value="send message"><br>
    <p><a href="homepage.jsp">Return to HomePage</a><br></p>
</form>
<a href="homepage.jsp">Return to HomePage</a><br>
</body>
</html>
