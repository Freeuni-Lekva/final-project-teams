
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

@WebServlet(name = "CustomQuizStatsServlet", value = "/CustomQuizStatsServlet")
public class CustomQuizStatsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

        quizUserHistoryDao HistoryDao;
        try {
            HistoryDao = new quizUserHistoryDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Quiz_Id;
        int sort;
        String MaxS;

        try {
            sort = Integer.parseInt(request.getParameter("sort"));
        } catch (NumberFormatException e) {
            sort = 0;
        }

        Quiz_Id = request.getParameter("quiz_name");

        //Quiz_Id=12;
        System.out.println(Quiz_Id);

        ResultSet rs = null;


        try{
            rs = HistoryDao.getQuizStatsSortByTime(Quiz_Id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*
        try {
            switch (sort){
              case 0:
                    rs = HistoryDao.getQuizStats(Integer.parseInt(Quiz_Id));
              break;
              case 1:
                    rs = HistoryDao.getQuizStatsSortByTime(Quiz_Id);
                break;
                case 2:
                    rs = HistoryDao.getQuizStatsSortByScore(Integer.parseInt(Quiz_Id));
                break;
                default:

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */


        List<String> Quiz_Names = new ArrayList<>();
        List<String> Usernames = new ArrayList<>();
        List<String> Scores = new ArrayList<>();
        List<String> Times = new ArrayList<>();
        String MaxQuizScore = null;

        try {
            while (rs.next()) {
                //           System.out.println("nexyt");
                Quiz_Names.add(rs.getString("quiz_name"));
                Scores.add(rs.getString("score"));
                //Times.add(rs.getString("quiz_time"));
                Usernames.add(rs.getString("username"));
                Times.add(rs.getString("quiz_creation_date"));
/*
                Quiz_Ids.add(rs.getInt("quiz_id"));
                Scores.add(rs.getInt("score"));
                Times.add(rs.getString("quiz_time"));
                Usernames.add(rs.getString("username"));*/
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResultSet resultS;
        try {
            resultS = HistoryDao.getMaxQuizScore(Quiz_Id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
        while (resultS.next()) {
            MaxQuizScore = resultS.getString(1);
            System.out.println(MaxQuizScore);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("Quiz_Ids",Quiz_Names);
        request.setAttribute("Scores",Scores);
        request.setAttribute("Times",Times);
        request.setAttribute("Usernames",Usernames);
        request.setAttribute("maxxx",MaxQuizScore);


        /*
        try {
            request.setAttribute("MaxS",MaxS.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        /*
        try{
        while (MaxS.next()) {
            request.setAttribute("MaxS",MaxS.getString(1));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        request.getRequestDispatcher("CustomQuizStats.jsp").forward(request, response);
    }


}
