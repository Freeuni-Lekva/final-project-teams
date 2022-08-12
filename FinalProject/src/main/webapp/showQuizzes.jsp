<%@ page import="DAOs.QuizzesDAO" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: shmagi
  Date: 12.08.22
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quizzes</title>
</head>
    <body>
        <ul>
            <%
                QuizzesDAO db = (QuizzesDAO) application.getAttribute("QUIZ_DB");
                ResultSet rs = db.allRows();
                out.println("<table style=\"width:100%\" border=\"2\">");
                out.println("<tr>\n" +
                            "    <th>Name</th>" +
                            "    <th>Description</th>" +
                            "    <th>Users completed</th>" +
                            "    <th>Creation time</th>" +
                            "</tr>");
                while(rs.next()){
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
        </ul>
    </body>
</html>
