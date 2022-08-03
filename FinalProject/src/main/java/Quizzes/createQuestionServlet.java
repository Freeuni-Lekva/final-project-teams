package Quizzes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "createQuestionServlet", value = "/createQuestionServlet")
public class createQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chosenType = request.getParameter("questionType");
        Quiz q = (Quiz) request.getServletContext().getAttribute("QUIZ");

        if("finishedDescriptions".equals(chosenType)){
            String quizName = request.getParameter("quizName");
            String quizDescription = request.getParameter("quizDescription");
            q.setName(quizName);
            q.setDescription(quizDescription);
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
            return;
        }

        Question newQuestion;
        Answer newAnswer;
        if(questionResponseQuestion.NAME.equals(chosenType) &&
                !request.getParameter(questionResponseQuestion.QUESTION_NAME).equals("") &&
                !request.getParameter(questionResponseAnswer.ANSWER_NAME).equals("")){
            newQuestion = new questionResponseQuestion(request.getParameter(questionResponseQuestion.QUESTION_NAME));
            newAnswer = new questionResponseAnswer(request.getParameter(questionResponseAnswer.ANSWER_NAME));

            q.addProblem(newQuestion, newAnswer);
        } else if(fillBlankQuestion.NAME.equals(chosenType) &&
                !request.getParameter(fillBlankQuestion.FIRST_PART_NAME).equals("") &&
                !request.getParameter(fillBlankQuestion.SECOND_PART_NAME).equals("") &&
                !request.getParameter(fillBlankAnswer.ANSWER_NAME).equals("")){
            newQuestion = new fillBlankQuestion(request.getParameter(fillBlankQuestion.FIRST_PART_NAME), request.getParameter(fillBlankQuestion.SECOND_PART_NAME));
            newAnswer = new fillBlankAnswer(request.getParameter(fillBlankAnswer.ANSWER_NAME));

            q.addProblem(newQuestion, newAnswer);
        } else if(multipleChoiceQuestion.NAME.equals(chosenType) &&
                !request.getParameter(multipleChoiceQuestion.QUESTION_NAME).equals("") &&
                !request.getParameter("Answer1").equals("") &&
                !request.getParameter("CorrectAnswer").equals("")){
            newQuestion = new multipleChoiceQuestion(request.getParameter(multipleChoiceQuestion.QUESTION_NAME));
            newAnswer = new multipleChoiceAnswer();
            for(int i = 1; i <= 6; i++){
                String nextAnswer = request.getParameter("Answer" + i);
                if(nextAnswer.equals("")){
                    break;
                }
                ((multipleChoiceAnswer) newAnswer).addAnswer(nextAnswer);
            }
            String correctAnswer = request.getParameter("CorrectAnswer");
            ((multipleChoiceAnswer) newAnswer).setCorrectAnswer(correctAnswer);

            q.addProblem(newQuestion, newAnswer);
        } else if(pictureResponseQuestion.NAME.equals(chosenType) &&
                !request.getParameter(pictureResponseQuestion.QUESTION_NAME).equals("") &&
                !request.getParameter(pictureResponseAnswer.ANSWER_NAME).equals("")){//
            newQuestion = new pictureResponseQuestion(request.getParameter(pictureResponseQuestion.QUESTION_NAME));
            newAnswer = new pictureResponseAnswer(request.getParameter(pictureResponseAnswer.ANSWER_NAME));

            q.addProblem(newQuestion, newAnswer);
        }

//        System.out.println(request.getParameter(questionResponseQuestion.QUESTION_NAME));
//        System.out.println(request.getParameter(questionResponseAnswer.ANSWER_NAME));
//        Enumeration enumeration = request.getParameterNames();
//        while (enumeration.hasMoreElements()) {
//            String parameterName = (String) enumeration.nextElement();
//            System.out.println(parameterName);
//        }
        request.getRequestDispatcher("createQuestion.jsp").forward(request, response);
    }
}
