/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-08-24 12:54:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAOs.QuizzesDAO;

public final class noUserForChallenge_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    QuizzesDAO quizDB = (QuizzesDAO) application.getAttribute("QUIZ_DB");
    int quizId = Integer.parseInt(request.getParameter("QUIZ_ID"));

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>No Such User</title>\r\n");
      out.write("    <link rel = \"icon\" href = \"https://www.ukrgate.com/eng/wp-content/uploads/2021/02/The-Ukrainian-Book-Institute-Purchases-380.9-Thousand-Books-for-Public-Libraries1.jpeg\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<label style=\"color:red\">There Was No Such User</label>\r\n");
      out.write("<form method=\"post\" action=\"/challengeForQuizServlet\">\r\n");
      out.write("    <label><b>Quiz Name: ");
out.println(quizDB.getQuizName(quizId));
      out.write("</b></label><br>\r\n");
      out.write("    <label for=\"CHALLENGED_QUIZ_ID\">Challenge Friend: </label>\r\n");
      out.write("    <input type=\"text\" placeholder=\"Enter UserName\" name=\"UserNameOfFriend\" value=\"\">\r\n");
      out.write("    <input type=\"text\" placeholder=\"Send Message\" name=\"MessageForQuizChallenge\" id=\"MessageForQuizChallenge\">\r\n");
      out.write("    <input type=\"hidden\" id=\"CHALLENGED_QUIZ_ID\" name=\"CHALLENGED_QUIZ_ID\" value=\"");
out.println(quizId);
      out.write("\">\r\n");
      out.write("    <input type=\"submit\" value=\"Next\">\r\n");
      out.write("</form>\r\n");
      out.write("<a href=\"quiz.jsp?id=");
out.println(quizId);
      out.write("\">Start Quiz</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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