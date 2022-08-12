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
    private void doForSinglePage(Quiz q, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("Shemovida");
        ArrayList<Problem> quiz = q.getQuiz();

        int totalMark = 0;
        int outOf = quiz.size();

        for(int i = 0; i < quiz.size(); i++){
            String correctAnswer = quiz.get(i).getAnswer().getAnswer();
            String userAnswer = request.getParameter("userAnswer" + i);
//            System.out.println("correct answ: " + correctAnswer);
//            System.out.println("user answ: " + userAnswer);
            if(correctAnswer.equals(userAnswer)){
                totalMark ++;
            }
        }
        request.getSession().setAttribute("USER_MARK", "" + totalMark);
        request.getSession().setAttribute("MAX_MARK", "" + outOf);
        request.getRequestDispatcher("quizResultPage.jsp").forward(request, response);
    }
    private void doForMultiplePage(Quiz q, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        if(request.getSession().getAttribute("MAX_MARK") == null){
//            request.getSession().setAttribute("MAX_MARK", "0");
//        }
//        System.out.println(request.getSession().getAttribute("MAX_MARK"));
        int currMark = Integer.parseInt((String)request.getSession().getAttribute("USER_MARK"));
        int lastId = Integer.parseInt((String)request.getSession().getAttribute("LAST_ID"));

        ArrayList<Problem> quiz = q.getQuiz();

        String correctAnswer = quiz.get(lastId).getAnswer().getAnswer();
        String userAnswer = request.getParameter("userAnswer" + lastId);
//            System.out.println("correct answ: " + correctAnswer);
//            System.out.println("user answ: " + userAnswer);
        if(correctAnswer.equals(userAnswer)){
            currMark ++;
        }
        lastId += 1;
        request.getSession().setAttribute("USER_MARK", "" + currMark);
        request.getSession().setAttribute("LAST_ID", "" + lastId);
        if(lastId >= quiz.size()){
            request.getSession().setAttribute("USER_MARK", "" + currMark);
            request.getSession().setAttribute("MAX_MARK", "" + quiz.size());
            request.getSession().removeAttribute("LAST_ID");
            request.getRequestDispatcher("quizResultPage.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Shemovida");
        Quiz q = (Quiz) request.getServletContext().getAttribute("QUIZ");
        if(q.getQuizType().equals(q.SINGLE_PAGE)){
            doForSinglePage(q, request, response);
        } else if(q.getQuizType().equals(q.MULTIPLE_PAGE)){
            doForMultiplePage(q, request, response);
        }

    }
}

/*
1. why -> because
2. you, cake -> want
3. cp iny -> 1945
 */
