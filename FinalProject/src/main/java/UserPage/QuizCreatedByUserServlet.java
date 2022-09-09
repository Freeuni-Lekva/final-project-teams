
package UserPage;

        import DAOs.QuizzesDAO;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

@WebServlet(name = "QuizCreatedUserServlet", value = "/QuizCreatedUserServlet")
public class QuizCreatedByUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        QuizzesDAO QuizDao;
        QuizDao = new QuizzesDAO();
        ResultSet RS = null;

        try {
            RS = QuizDao.GetQuizzesByAuthor((String) request.getSession().getAttribute("UserName"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        request.getRequestDispatcher("Achievments.jsp").forward(request, response);
    }
}