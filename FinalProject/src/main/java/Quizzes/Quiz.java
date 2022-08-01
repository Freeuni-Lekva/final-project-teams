package Quizzes;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private ArrayList<Problem> quiz;

    private String Name;
    private String Description;

    public Quiz(){
        quiz = new ArrayList<>();
    }

    public void addProblem(Problem problem){
        quiz.add(problem);
    }
    public void addProblem(Question q, Answer a){
        Problem p = new Problem(q, a);
        quiz.add(p);
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<Problem> getQuiz(){
        return quiz;
    }
}
