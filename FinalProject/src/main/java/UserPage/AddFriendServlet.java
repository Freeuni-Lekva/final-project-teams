package UserPage;

import DAOs.AccountDAO;
import DAOs.MailsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(
        name = "addFriendServlet",
        value = {"/addFriendServlet"}
)
public class AddFriendServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("UserNameOfFriend");
        String messageForFriend = request.getParameter("MessageForAddingFriend");
        AccountDAO acc = new AccountDAO();

        try {
            if (acc.accountUsernameExists(userName)) {
                MailsDao mailsDao = new MailsDao();
                mailsDao.addMail((String)request.getSession().getAttribute("UserName"), userName, "addFriend", messageForFriend);
                RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("noSuchUser.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
