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
    <link rel="stylesheet" href="homeStyle.css"/>
</head>
<body>
    <div id="usernameSearch">
        <form action="/SearchUserServlet" method="GET" >
            <input type="text" placeholder="User Name" name="UserName" id="UserName">
            <input type="submit" value="Search"><br>
        </form>
    </div>

    <h1><b>Home Page</b></h1>

    <div id="profileDropdown">
        <small>Logged in as:</small>
        <br>
        <button onclick="dropdownProfile()" id="dropdownButton"><%=request.getSession().getAttribute("UserName")%> </button>
        <div id="dropdownContent" class="dropdownContent">
            <a href="addFriend.jsp">Add Friend</a>
            <br>
            <a href="sendMessage.jsp">Send Message</a>
            <br>
            <a href="challengeForQuiz.jsp">Challenge User</a>
            <br>
            <a href="mails.jsp">Mails</a>
            <br>
            <a href="friendList.jsp">Friends</a>
            <br>
            <a href="showQuizzes.jsp">Quizzes</a>
        </div>
    </div>

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

    <script src="homepageFunctions.js"></script>
</body>
</html>
