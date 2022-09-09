/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-08-26 04:47:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Quizzes.*;

public final class createQuestionTryAgain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public String createForm(String label, String questionInputs, String answerInputs){
        return    "<label><b>" + label + ":</b></label><br>" +
                "<form method=\"post\" action=\"createQuestionServlet\">" +
                questionInputs +
                "<br>" +
                answerInputs +
                "<input type=\"hidden\" value=\"" + label + "\" name=\"questionType\">" +
                "<input type=\"submit\" value=\"Add\">" +
                "</form>";
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

      out.write('\r');
      out.write('\n');

    if(request.getSession().getAttribute("QUIZ") == null){
        request.getSession().setAttribute("QUIZ", new Quiz());
    }

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Create Quiz</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Try again to create new Question:</h1><br>\r\n");
      out.write("<p style=\"color:red\">(Please do not leave question or answer field empty, new question will not be added. Also new Quiz can not be created if no question was added.)</p>\r\n");

    out.println(createForm(questionResponseQuestion.NAME, questionResponseQuestion.createQuestionHtmlCode, questionResponseAnswer.createAnswerHtmlCode));
    out.println(createForm(fillBlankQuestion.NAME, fillBlankQuestion.createQuestionHtmlCode, fillBlankAnswer.createAnswerHtmlCode));
    out.println(createForm(multipleChoiceQuestion.NAME, multipleChoiceQuestion.createQuestionHtmlCode, multipleChoiceAnswer.createAnswerHtmlCode));
    out.println(createForm(pictureResponseQuestion.NAME, pictureResponseQuestion.createQuestionHtmlCode, pictureResponseAnswer.createAnswerHtmlCode));

      out.write("\r\n");
      out.write("<a href=\"finishCreatingQuiz.jsp\">Finish Creating Quiz</a>\r\n");
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
