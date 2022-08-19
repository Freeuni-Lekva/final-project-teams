package Quizzes;

import DAOs.QuizzesDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShowQuizzesServlet", value = "/ShowQuizzesServlet")
public class ShowQuizzesServlet extends HttpServlet {
    public static final int QUIZZES_PER_PAGE = 10;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private void changePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        QuizzesDAO db = (QuizzesDAO) request.getServletContext().getAttribute("QUIZ_DB");
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        if(request.getParameter("prev") != null && currPage > 1){
            request.setAttribute("page", (currPage - 1));
            request.getRequestDispatcher("showQuizzes.jsp?page=" + (currPage - 1)).forward(request, response);
        } else if(request.getParameter("next") != null && db.getQuizzesCount() >= (currPage) * QUIZZES_PER_PAGE){
            request.setAttribute("page", (currPage + 1));
            request.getRequestDispatcher("showQuizzes.jsp?page=" + (currPage + 1)).forward(request, response);
        } else if(request.getParameter("jumpTo") != null && isNumeric(request.getParameter("jump")) && Integer.parseInt(request.getParameter("jump")) >= 0 && db.getQuizzesCount() >= QUIZZES_PER_PAGE * (Integer.parseInt(request.getParameter("jump")) - 1)){
            request.setAttribute("page", request.getParameter("jump"));
            request.getRequestDispatcher("showQuizzes.jsp?page=" + Integer.parseInt(request.getParameter("jump"))).forward(request, response);
        } else{
            request.getRequestDispatcher("showQuizzes.jsp?page=" + currPage).forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("prev") != null || request.getParameter("jumpTo") != null || request.getParameter("next") != null){
            try {
                changePage(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
