
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

        int Quiz_Id;
        int sort;
        ResultSet MaxS;

        try {
            sort = Integer.parseInt(request.getParameter("sort"));
        } catch (NumberFormatException e) {
            sort = 0;
        }

        Quiz_Id = Integer.parseInt(request.getParameter("quiz_id"));

        //Quiz_Id=12;
        System.out.println(Quiz_Id);

        ResultSet rs = null;

        try {
            switch (sort){
              case 0:
                    rs = HistoryDao.getQuizStats(Quiz_Id);
              break;
              case 1:
                    rs = HistoryDao.getQuizStatsSortByTime(Quiz_Id);
                break;
                case 2:
                    rs = HistoryDao.getQuizStatsSortByScore(Quiz_Id);
                break;
                default:

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        List<Integer> Quiz_Ids = new ArrayList<>();
        List<String> Usernames = new ArrayList<>();
        List<Integer> Scores = new ArrayList<>();
        List<String> Times = new ArrayList<>();

        try {
            while (rs.next()) {
                Quiz_Ids.add(rs.getInt("quiz_id"));
                Scores.add(rs.getInt("score"));
                Times.add(rs.getString("quiz_time"));
                Usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            MaxS = HistoryDao.getMaxQuizScore(Quiz_Id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("Quiz_Ids",Quiz_Ids);
        request.setAttribute("Scores",Scores);
        request.setAttribute("Times",Times);
        request.setAttribute("Usernames",Usernames);

        /*
        try {
            request.setAttribute("MaxS",MaxS.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        try{
        while (MaxS.next()) {
            request.setAttribute("MaxS",MaxS.getString(1));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("CustomQuizStats.jsp").forward(request, response);
    }


}
