/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-08-24 12:43:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public String createList(List<String> lst) {
        StringBuffer buf = new StringBuffer();
        buf.append("<ol start = \"1\">\n");
        for (String str: lst) {
            buf.append("<li>").append(str).append("</li>\n");
        }
        buf.append("</ol>");

        return buf.toString();
    }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Home Page</title>\r\n");
      out.write("    <link rel = \"icon\" href = \"https://www.ukrgate.com/eng/wp-content/uploads/2021/02/The-Ukrainian-Book-Institute-Purchases-380.9-Thousand-Books-for-Public-Libraries1.jpeg\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <form action=\"/SearchUserServlet\" method=\"GET\" >\r\n");
      out.write("        <input type=\"text\" placeholder=\"User Name\" name=\"UserName\" id=\"UserName\">\r\n");
      out.write("        <input type=\"submit\" value=\"Search\"><br>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <h1><b>Home Page</b></h1>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"addFriend.jsp\">Add Friend</a>\r\n");
      out.write("    <a href=\"sendMessage.jsp\">Send Message</a>\r\n");
      out.write("    <a href=\"challengeForQuiz.jsp\">Challenge User</a>\r\n");
      out.write("    <p> <a href=\"mails.jsp\">Mails</a> </p>\r\n");
      out.write("    <p>   <a href=\"friendList.jsp\">Friends</a> </p>\r\n");
      out.write("    <p>   <a href=\"showQuizzes.jsp\">Quizzes</a> </p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <p>Popular Quizzes</p>\r\n");
      out.write("        <h2>\r\n");
      out.write("            ");

            
      out.write("\r\n");
      out.write("        </h2>\r\n");
      out.write("    <p>Recent Quizzes Activity</p>\r\n");
      out.write("    <h2>\r\n");
      out.write("        ");

        
      out.write("\r\n");
      out.write("    </h2>\r\n");
      out.write("    <p>Recently Created Quizzes</p>\r\n");
      out.write("    <h2>\r\n");
      out.write("        ");

        
      out.write("\r\n");
      out.write("    </h2>\r\n");
      out.write("</body>\r\n");
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
