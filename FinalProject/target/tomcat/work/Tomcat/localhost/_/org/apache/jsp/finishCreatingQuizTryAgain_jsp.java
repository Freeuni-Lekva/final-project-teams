/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-08-22 09:07:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class finishCreatingQuizTryAgain_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Finish Creating Quiz</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <p style=\"color:red\">(Please do not leave any field empty, new quiz will not be created.)</p>\n");
      out.write("    <form method=\"post\" action=\"createQuestionServlet\">\n");
      out.write("        <label for=\"quizName\">Enter Quiz Name:</label><br>\n");
      out.write("        <input type=\"text\" id=\"quizName\" name=\"quizName\"><br>\n");
      out.write("        <label for=\"quizDescription\">Enter Quiz Description:</label><br>\n");
      out.write("        <input type=\"text\" id=\"quizDescription\" name=\"quizDescription\"><br>\n");
      out.write("        <input type=\"radio\" id=\"onePage\" name=\"quizShowStyle\" value=\"singlePage\">\n");
      out.write("        <label for=\"onePage\">Single Page</label><br>\n");
      out.write("        <input type=\"radio\" id=\"multiplePage\" name=\"quizShowStyle\" value=\"multiplePage\">\n");
      out.write("        <label for=\"multiplePage\">Multiple Page</label><br>\n");
      out.write("        <input type=\"hidden\" value=\"finishedDescriptions\" name=\"questionType\">\n");
      out.write("        <input type=\"submit\" value=\"Finish\">\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
