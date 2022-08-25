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

        Username = request.getParameter("name");
        System.out.println(Username);

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

        try {
            while (rs.next()) {
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