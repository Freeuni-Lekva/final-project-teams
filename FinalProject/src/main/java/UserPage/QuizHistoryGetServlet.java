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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

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
        request.setAttribute("ResultSet",rs);


        List<Integer> Quiz_Ids = new ArrayList<>();
        List<String> Usernames = new ArrayList<>();
        List<Integer> Scores = new ArrayList<>();
        List<String> Times = new ArrayList<>();

        try {
            while (rs.next()) {
     //           System.out.println("nexyt");
                Quiz_Ids.add(rs.getInt("quiz_id"));
                Scores.add(rs.getInt("score"));
                Times.add(rs.getString("quiz_time"));
                Usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        request.setAttribute("Quiz_Ids",Quiz_Ids);
        request.setAttribute("Scores",Scores);
        request.setAttribute("Times",Times);
        request.setAttribute("Usernames",Usernames);


        request.getRequestDispatcher("QuizServletGetHistory.jsp").forward(request, response);
    }

}
