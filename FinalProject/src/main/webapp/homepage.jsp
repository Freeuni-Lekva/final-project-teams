<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: shmagi
  Date: 29.07.22
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public String createList(List<String> lst) {
        StringBuffer buf = new StringBuffer();
        buf.append("<ol start = \"1\">\n");
        for (String str: lst) {
            buf.append("<li>").append(str).append("</li>\n");
        }
        buf.append("</ol>");

        return buf.toString();
    }
%>

<html>
<head>
    <title>Home Page</title>
    <link rel = "icon" href = "https://www.ukrgate.com/eng/wp-content/uploads/2021/02/The-Ukrainian-Book-Institute-Purchases-380.9-Thousand-Books-for-Public-Libraries1.jpeg"/>
</head>
<body>
    <form action="/SearchUserServlet" method="GET" >
        <input type="text" placeholder="User Name" name="UserName" id="UserName">
        <input type="submit" value="Search"><br>
    </form>

    <h1><b>Home Page</b></h1>
    <p>Popular Quizzes</p>
        <h2>
            <%
            %>
        </h2>
    <p>Recent Quizzes Activity</p>
    <h2>
        <%
        %>
    </h2>
    <p>Recently Created Quizzes</p>
    <h2>
        <%
        %>
    </h2>
</body>
</html>
