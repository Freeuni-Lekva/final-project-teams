/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-09-03 13:04:47 UTC
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
import java.util.Iterator;

public final class CustomQuizStats_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>HisToryOfQuiz</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${maxxx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4>\r\n");
      out.write("\r\n");
 ArrayList<String> Q_IDS = (ArrayList) request.getAttribute("Quiz_Ids"); 
      out.write('\r');
      out.write('\n');
 ArrayList<String> USERS = (ArrayList) request.getAttribute("Usernames"); 
      out.write('\r');
      out.write('\n');
 ArrayList<String> SCORES = (ArrayList) request.getAttribute("Scores"); 
      out.write('\r');
      out.write('\n');
 ArrayList<String> Times = (ArrayList) request.getAttribute("Times"); 
      out.write('\r');
      out.write('\n');
 Integer Page =  (Integer) request.getAttribute("page"); 
      out.write('\r');
      out.write('\n');
 String name =  (String)request.getAttribute("curQuizName"); 
      out.write('\r');
      out.write('\n');
 Integer PageNum =  (Integer) request.getAttribute("Num"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     <div align=\"center\">\r\n");
      out.write("\r\n");
      out.write("        <table border=\"1\" cellpadding=\"5\">\r\n");
      out.write("\r\n");
      out.write("            <caption><h2>History Of All Quizzes</h2></caption>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Quiz_Id</th>\r\n");
      out.write("                <th>Username</th>\r\n");
      out.write("                <th>Score</th>\r\n");
      out.write("                <th>Time</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("                ");

                 	Iterator<String> iterator_QI = Q_IDS.iterator();
                	Iterator<String> iterator_U = USERS.iterator();
                    Iterator<String> iterator_S = SCORES.iterator();
                    Iterator<String> iterator_T = Times.iterator();

                 	while(iterator_QI.hasNext())
                 	{
             		String S1 = iterator_QI.next();
               		String S2 = iterator_U.next();
            		String S3 = iterator_S.next();
               		String S4 = iterator_T.next();
                 	
      out.write("\r\n");
      out.write("                \t<tr>\r\n");
      out.write("         \t            \t<td>");
      out.print( S1 );
      out.write(" </td>\r\n");
      out.write("         \t            \t<td>");
      out.print( S2 );
      out.write(" </td>\r\n");
      out.write("                         \t<td>");
      out.print( S3 );
      out.write(" </td>\r\n");
      out.write("                         \t<td>");
      out.print( S4 );
      out.write(" </td>\r\n");
      out.write("                   \t</tr>\r\n");
      out.write("                    ");

                 	}
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <form action=\"CustomQuizStatsServlet\" method=\"get\" style=\"text-align: center\">\r\n");
      out.write("                                    <label>Page: </label>\r\n");
      out.write("                                    <input type=\"submit\" name=\"jumpTo\" value=\"jumpTo\" style=\"display: none\" />\r\n");
      out.write("                                    <input type=\"hidden\" name=\"currPage\" value=");
      out.print(Page);
      out.write(">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"currQuiz\" value=");
      out.print(name);
      out.write(">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"currPageNum\" value=");
      out.print(PageNum);
      out.write(">\r\n");
      out.write("                                    <input type=\"submit\" id=\"prev\" name=\"prev\" value=\"prev\">\r\n");
      out.write("                                    <input type=\"text\" id=\"jump\" name=\"jump\" value=\"");
out.println(Page);
      out.write("\"  style=\"text-align: center\">\r\n");
      out.write("                                    <input type=\"submit\" id=\"next\" name=\"next\" value=\"next\">\r\n");
      out.write("                                </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/CustomQuizStatsServlet\" method=\"GET\" >\r\n");
      out.write("            <label for=\"quiz_name\">Change Number Of Quizzes per Page </label>\r\n");
      out.write("            <input type=\"hidden\" name=\"currQuiz\" value=");
      out.print(name);
      out.write(">\r\n");
      out.write("            <input type=\"text\" name=\"NumOfQuiz\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${NumOfQuiz}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /><br/>\r\n");
      out.write("            <button type=\"submit\">Change</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/CustomQuizStatsServlet\" method=\"GET\" >\r\n");
      out.write("\r\n");
      out.write("            <label for=\"quiz_name\">Search Stats Of Custom Quiz Name </label>\r\n");
      out.write("            <input type=\"text\" name=\"quiz_name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${quiz_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /><br/>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"ORDER_BY\">SORT BY</label>\r\n");
      out.write("            <input type=\"radio\"  value=\"0\" name=\"sort\" checked> Time\r\n");
      out.write("            <input type=\"radio\"  value=\"1\" name=\"sort\"> SCORE\r\n");
      out.write("            <button type=\"submit\">Quiz Stats</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/CustomUserStatsServlet\" method=\"GET\" >\r\n");
      out.write("            <label for=\"name\"    >Search Stats Of Custom Username   </label>\r\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /><br/>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Quiz Stats</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MaxS}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
