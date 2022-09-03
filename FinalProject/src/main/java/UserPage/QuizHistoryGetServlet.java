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

@WebServlet(name = "QuizServletGetHistory", value = "/QuizServletGetHistory")
public class QuizHistoryGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

        /*
        try {
            int PageZ = Integer.parseInt(request.getParameter("currPageNum"));
            System.out.println(" GET AT ----- ZZZZZZZZZZZ " +  PageZ);

        } catch (NumberFormatException e) {
            int PageZ = 1;
        }*/

        String QuizPerPage= request.getParameter("NumOfQuiz");

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

        System.out.println(QP + "  SET AS THIS IS PageNum");

        quizUserHistoryDao HistoryDao;
        try {
            HistoryDao = new quizUserHistoryDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //int Quiz_Id;
        //int Quiz_Id = request.getIntHeader("Quiz_Id");
        //Quiz_Id=12;

        ResultSet rs;

        try {
            rs = HistoryDao.getStats();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        request.setAttribute("ResultSet",rs);


        List<String> Quiz_Names = new ArrayList<>();
        List<String> Usernames = new ArrayList<>();
        List<String> Scores = new ArrayList<>();
        List<String> Times = new ArrayList<>();




        Integer Page = 0;
        try {
            Page = Integer.parseInt(request.getParameter("currPage"));
            System.out.println(" GET AT -----  " +  Page);

        } catch (NumberFormatException e) {
            Page = 1;
        }
        //request.setAttribute("Page",Page);

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

        try {
            rs.absolute((Page-1)*QP);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        int count=QP;
        try {
            while (rs.next() && count>0) {
                count--;
                //           System.out.println("nexyt");
                Quiz_Names.add(rs.getString("quiz_name"));
                Scores.add(rs.getString("score"));
                //Times.add(rs.getString("quiz_time"));
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


        request.getRequestDispatcher("QuizServletGetHistory.jsp").forward(request, response);
    }

}