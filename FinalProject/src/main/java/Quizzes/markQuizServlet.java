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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Shemovida");
        Quiz q = (Quiz) request.getServletContext().getAttribute("QUIZ");
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
}

/*
1. why -> because
2. you, cake -> want
3. cp iny -> 1945
 */
