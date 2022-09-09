package UserPage;

import DAOs.quizUserHistoryDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomUserStatsServlet", value = "/CustomUserStatsServlet")
public class CustomUserStatsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String Username = null;


        String QuizPerPage= request.getParameter("NumOfQuiz");
        System.out.println(QuizPerPage + "THI IS TVWY");

        int QP = 4;
        if(QuizPerPage != null){
            QP = Integer. parseInt(QuizPerPage);
            System.out.println("NUM BY CHANGE   " + QP);
        }else if (request.getParameter("currPageNum") != null){
            QP = Integer.parseInt(request.getParameter("currPageNum"));
            System.out.println("NUM BY DEF   " + QP);
        }else{
            System.out.println("NUM BY DEFDEF   " + QP);
            QP = 4;
        }


        if(request.getParameter("name") != null){
            Username = request.getParameter("name");
        }
        else {
            Username = request.getParameter("currUser");
        }
        request.setAttribute("User",Username);
        System.out.println(Username);


        Integer Page = 0;
        try {
            Page = Integer.parseInt(request.getParameter("currPage"));
            System.out.println(" GET AT -----  " +  Page);

        } catch (NumberFormatException e) {
            Page = 1;
        }

        if(request.getParameter("prev") != null ) {
            Page--;
        } else if (request.getParameter("next") != null) {
            Page++;
        } else if (request.getParameter("jumpTo") != null) {
            Page = Integer.valueOf(request.getParameter("jump"));
        }
        request.setAttribute("page", Page);
        request.setAttribute("Num",QP);
        System.out.println(" SET AT -----  " +  Page);

        quizUserHistoryDao HistoryDao;
        try {
            HistoryDao = new quizUserHistoryDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResultSet rs = null;

        try {
            rs = HistoryDao.getUserStatsByTime(Username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<String> Quiz_Names = new ArrayList<>();
        List<String> Usernames = new ArrayList<>();
        List<String> Scores = new ArrayList<>();
        List<String> Times = new ArrayList<>();


        System.out.println("BEFORE TRY OF ABSOLUTE");
        try {
            rs.absolute((Page-1)*QP);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        int count=QP;

        try {
            while (rs.next() && count>0) {
                count--;
                Quiz_Names.add(rs.getString("quiz_name"));
                Scores.add(rs.getString("score"));
                Usernames.add(rs.getString("username"));
                Times.add(rs.getString("quiz_creation_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("Quiz_Ids",Quiz_Names);
        request.setAttribute("Scores",Scores);
        request.setAttribute("Times",Times);
        request.setAttribute("Usernames",Usernames);
        request.setAttribute("Username,",Username);

        request.getRequestDispatcher("CustomUserStats.jsp").forward(request, response);
    }
}