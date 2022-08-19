package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface quizHistoryDao {
    public void addQuiz(int quiz_id,int user_id);
    public void updateQuiz(int quiz_id,int user_id);
    public int getQuizId(int quiz_id,int user_id);
    public int getScore(int quiz_id,int user_id) throws SQLException;
    public int getTime(int quiz_id,int user_id) throws SQLException;
    public ResultSet getStats() throws SQLException;
    public ResultSet getQuizStats(int quiz_id) throws SQLException;
    public ResultSet getQuizStatsSortByTime(int quiz_id) throws SQLException;
    public ResultSet getQuizStatsSortByScore(int quiz_id) throws SQLException;
    public ResultSet getMaxQuizScore(int quiz_id) throws SQLException;

    //Integer getMaxQuizScore() throws SQLException;
}