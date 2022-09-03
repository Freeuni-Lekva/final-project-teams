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
    public void addQuiz(String quiz_name, String username,String score) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO quizHistory (quiz_name,username,score) " +
                " VALUES (?, ?,?);");
        prepStmt.setString(1,quiz_name);
        prepStmt.setString(2,username);
        prepStmt.setString(3,score);
        System.out.println("INSERTING INTO TABLE");
        prepStmt.executeUpdate();
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

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH;",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getQuizStats(String quiz_name) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_name = ?;",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        prepStmt.setString(1, quiz_name);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getUserStatsByTime(String Username) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.username = ? order by quiz_creation_date;",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        prepStmt.setString(1, Username);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
//        return null;
    }

    @Override
    public ResultSet getQuizStatsSortByTime(String quiz_name) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_name = ? order by quiz_creation_date;",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        prepStmt.setString(1, quiz_name);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getQuizStatsSortByScore(String quiz_name) throws SQLException {

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_name = ? order by score;",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        prepStmt.setString(1, quiz_name);

        ResultSet rs = prepStmt.executeQuery();

        return rs;
    }

    @Override
    public ResultSet getMaxQuizScore(String quiz_name) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement("SELECT max(score) FROM quizHistory QH  " +
                "                where QH.quiz_name = ?;");

        prepStmt.setString(1, quiz_name);
        ResultSet rs = prepStmt.executeQuery();
        //String MaxScore = rs.getString(1);
        //Integer MaxS = rs.getInt("max(score)");
        //System.out.println(MaxS);
        return rs;
    }

    @Override
    public ResultSet getUserStatsByScore(String Username) throws SQLException{
        return null;
    }

    @Override
    public ResultSet getUserStatsDistinct(String Username) throws SQLException{
        return null;
    }

}