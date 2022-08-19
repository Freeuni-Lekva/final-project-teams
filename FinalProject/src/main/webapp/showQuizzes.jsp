<%@ page import="DAOs.QuizzesDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %><%--
  Created by IntelliJ IDEA.
  User: shmagi
  Date: 12.08.22
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
%>
<%
    int QUIZZES_PER_PAGE = 10;
%>
<%
    int Page = 1;
    if(request.getParameter("page") != null){
        Page = Integer.parseInt((String)request.getParameter("page"));
    }
    request.getServletContext().setAttribute("page", Page);
%>
<html>
<head>
    <title>Quizzes</title>
</head>
    <body>
        <form action="ShowQuizzesServlet" method="post" style="text-align: center">
            <label for="sortingWay">Sort by:</label>
            <select name="sort" id="sortingWay">
                <option value="Creation time">Creation time</option>
                <option value="Popularity">Popularity</option>
            </select>
            <br><br>
            <label for="search">Name:</label>
            <input type="text" id="search" name="search" value=""><br>
            <input type="submit" value="Search">
        </form>
        <%
            QuizzesDAO db = (QuizzesDAO) application.getAttribute("QUIZ_DB");
            ResultSet rs = db.allRows();
            rs.absolute((Page - 1) * 10);
            out.println("<table style=\"width:100%\" border=\"2\">");
            out.println("<tr>\n" +
                        "    <th>Name</th>" +
                        "    <th>Description</th>" +
                        "    <th>Users completed</th>" +
                        "    <th>Creation time</th>" +
                        "</tr>");
            for(int i = 0; i < QUIZZES_PER_PAGE; i++){
                if(!rs.next()){
                    break;
                }
                String id = rs.getString(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                int num_participants = rs.getInt(5);
                String creationTime = rs.getString(6);

                out.println("<tr>" +
                            "    <td style=\"text-align: center; vertical-align: middle;\">" +
                            "        <a href=\"quiz.jsp?id=" + id + "\">" +
                            "          <div style=\"height:100%;width:100%\">" +
                                          name +
                            "          </div>" +
                            "        </a>" +
                            "    </td>" +
                            "    <td style=\"text-align: center; vertical-align: middle;\">" + description + "</td>" +
                            "    <td style=\"text-align: center; vertical-align: middle;\">" + num_participants + "</td>" +
                            "    <td style=\"text-align: center; vertical-align: middle;\">" + creationTime + "</td>" +
                            " </tr>");
            }
            out.println("</table>");
        %>

        <form action="ShowQuizzesServlet" method="post" style="text-align: center">
            <label>Page: </label>
            <input type="submit" name="jumpTo" value="jumpTo" style="display: none" />
            <input type="hidden" name="currPage" value=<%=Page%>>
            <input type="submit" id="prev" name="prev" value="prev">
            <input type="text" id="jump" name="jump" value="<%out.println(Page);%>"  style="text-align: center">
            <input type="submit" id="next" name="next" value="next">
        </form>
    </body>
</html>
