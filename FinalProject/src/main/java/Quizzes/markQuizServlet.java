package Quizzes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "markQuizServlet", value = "/markQuizServlet")
public class markQuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void clearAttributes(HttpServletRequest request, HttpServletResponse response){
//        request.getServletContext().removeAttribute("QUIZ");
//        request.getServletContext().removeAttribute("LAST_ID");
    }
    private void doForSinglePage(Quiz q, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Problem> quiz = q.getQuiz();

        int totalMark = 0;
        int outOf = quiz.size();

        for(int i = 0; i < quiz.size(); i++){
            String correctAnswer = quiz.get(i).getAnswer().getAnswer();
            String userAnswer = request.getParameter("userAnswer" + i);
            if(correctAnswer.equals(userAnswer)){
                totalMark ++;
            }
        }
        request.getSession().setAttribute("USER_MARK", "" + totalMark);
        request.getSession().setAttribute("MAX_MARK", "" + outOf);
        clearAttributes(request, response);
        request.getRequestDispatcher("quizResultPage.jsp").forward(request, response);
    }
    private void doForMultiplePage(Quiz q, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currMark = Integer.parseInt((String)request.getSession().getAttribute("USER_MARK"));
        int lastId = Integer.parseInt((String)request.getSession().getAttribute("LAST_ID"));

        ArrayList<Problem> quiz = q.getQuiz();

        String correctAnswer = quiz.get(lastId).getAnswer().getAnswer();
        String userAnswer = request.getParameter("userAnswer" + lastId);
        if(correctAnswer.equals(userAnswer)){
            currMark ++;
        }
        lastId += 1;
        request.getSession().setAttribute("USER_MARK", "" + currMark);
        request.getSession().setAttribute("LAST_ID", "" + lastId);
        if(lastId >= quiz.size()){
            request.getSession().setAttribute("USER_MARK", "" + currMark);
            request.getSession().setAttribute("MAX_MARK", "" + quiz.size());
            clearAttributes(request, response);
            request.getRequestDispatcher("quizResultPage.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quiz q = (Quiz) request.getSession().getAttribute("QUIZ");
        if(q.getQuizType().equals(q.SINGLE_PAGE)){
            doForSinglePage(q, request, response);
        } else if(q.getQuizType().equals(q.MULTIPLE_PAGE)){
            doForMultiplePage(q, request, response);
        }
    }
}

