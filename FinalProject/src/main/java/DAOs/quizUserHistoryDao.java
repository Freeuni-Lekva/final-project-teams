package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class quizUserHistoryDao implements quizHistoryDao{

    private final Connection conn;

    public quizUserHistoryDao() throws SQLException {
        this.conn = DBConnection.getConnection();
        //  this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/VSTB","root", "1234");
    }

    @Override
    public void addQuiz(int quiz_id, int user_id) {

    }

    @Override
    public void updateQuiz(int quiz_id, int user_id) {

    }

    @Override
    public int getQuizId(int quiz_id, int user_id) {
        return 0;
    }

    @Override
    public int getScore(int quiz_id, int user_id) throws SQLException {
/*
        PreparedStatement prepStmt = conn.prepareStatement("SELECT QH.score FROM quizHistory QH " +
                "where QH.quiz_id = ? AND QH.user_id = ?;");

        prepStmt.setInt(1, quiz_id);
        prepStmt.setInt(2,user_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs.getInt(1);
        */
        return 0;
    }

    @Override
    public int getTime(int quiz_id, int user_id) throws SQLException {
        /*
        PreparedStatement prepStmt = conn.prepareStatement("SELECT QH.quiz_time FROM quizHistory QH " +
                "where QH.quiz_id = ? AND QH.user_id = ?;");

        prepStmt.setInt(1, quiz_id);
        prepStmt.setInt(2,user_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs.getInt(1);
        */
        return 1;
    }

    @Override
    public ResultSet getStats() throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH;");

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getQuizStats(int quiz_id) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_id = ?;");

        prepStmt.setInt(1, quiz_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getQuizStatsSortByTime(int quiz_id) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_id = ? order by quiz_time;");

        prepStmt.setInt(1, quiz_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getQuizStatsSortByScore(int quiz_id) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_id = ? order by score;");

        prepStmt.setInt(1, quiz_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getMaxQuizScore(int quiz_id) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement("SELECT max(score) FROM quizHistory QH  " +
                "                where QH.quiz_id = ?;");

        prepStmt.setInt(1, quiz_id);
        ResultSet rs = prepStmt.executeQuery();
        //Integer MaxS = rs.getInt("max(score)");
        //System.out.println(MaxS);
        return rs;
    }
}
