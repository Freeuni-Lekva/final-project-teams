/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-08-24 12:26:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAOs.QuizzesDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public final class showQuizzes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

      out.write('\r');
      out.write('\n');

    int QUIZZES_PER_PAGE = 10;
    request.getSession().removeAttribute("QUIZ");

      out.write('\r');
      out.write('\n');

    int Page = 1;
    if(request.getParameter("page") != null){
        Page = Integer.parseInt((String)request.getParameter("page"));
    } else {
        request.getSession().removeAttribute("sort");
        request.getSession().removeAttribute("search");
    }

      out.write('\r');
      out.write('\n');

    QuizzesDAO db = (QuizzesDAO) request.getServletContext().getAttribute("QUIZ_DB");
    ResultSet rs;

    if(request.getSession().getAttribute("sort") != null && request.getSession().getAttribute("sort").equals("Sort by creation date")){
        rs = db.orderByCreationDate((String)request.getSession().getAttribute("search"));
    } else if(request.getSession().getAttribute("sort") != null && request.getSession().getAttribute("sort").equals("Sort by popularity")){
        rs = db.orderByPopularity((String)request.getSession().getAttribute("search"));
    } else {
        rs = db.allRows();
    }

    rs.absolute((Page - 1) * 10);

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Quizzes</title>\r\n");
      out.write("</head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <a href=\"createQuestion.jsp\">Create new quiz</a>\r\n");
      out.write("        <form action=\"ShowQuizzesServlet\" method=\"post\" style=\"text-align: center\">\r\n");
      out.write("            <label for=\"search\">Name:</label>\r\n");
      out.write("            <input type=\"text\" id=\"search\" name=\"search\" value=\"\"><br>\r\n");
      out.write("            <input type=\"submit\" value=\"Search\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <table style=\"width:100%\" border=\"2\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Name</th>\r\n");
      out.write("                <th>Description</th>\r\n");
      out.write("                <th>\r\n");
      out.write("                    <form action=\"ShowQuizzesServlet\" method=\"post\">\r\n");
      out.write("                        <label>Users completed</label>\r\n");
      out.write("                        <input type=\"submit\" name=\"sort\" value=\"Sort by popularity\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </th>\r\n");
      out.write("                <th>\r\n");
      out.write("                    <form action=\"ShowQuizzesServlet\" method=\"post\">\r\n");
      out.write("                        <label>Creation time</label>\r\n");
      out.write("                        <input type=\"submit\" name=\"sort\" value=\"Sort by creation date\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");

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
        
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        <form action=\"ShowQuizzesServlet\" method=\"post\" style=\"text-align: center\">\r\n");
      out.write("            <label>Page: </label>\r\n");
      out.write("            <input type=\"submit\" name=\"jumpTo\" value=\"jumpTo\" style=\"display: none\" />\r\n");
      out.write("            <input type=\"hidden\" name=\"currPage\" value=");
      out.print(Page);
      out.write(">\r\n");
      out.write("            <input type=\"submit\" id=\"prev\" name=\"prev\" value=\"prev\">\r\n");
      out.write("            <input type=\"text\" id=\"jump\" name=\"jump\" value=\"");
out.println(Page);
      out.write("\"  style=\"text-align: center\">\r\n");
      out.write("            <input type=\"submit\" id=\"next\" name=\"next\" value=\"next\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
