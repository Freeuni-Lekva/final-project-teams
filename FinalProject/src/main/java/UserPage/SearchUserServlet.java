package UserPage;

import DAOs.AccountDAO;
import UserLoginSystem.AccountManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchUserServlet", value = "/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountManager manager = (AccountManager) getServletContext().getAttribute("Manager");
        String userName = request.getParameter("UserName");
        AccountDAO acc = new AccountDAO();
        request.setAttribute("accountsFoundList", acc.searchAccountByUsername(userName));
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

