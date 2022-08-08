package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class quizUserHistoryDao implements quizHistoryDao{

    private final Connection conn;

    public quizUserHistoryDao(Connection conn) {
        this.conn = DBConnection.getConnection();
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

        PreparedStatement prepStmt = conn.prepareStatement("SELECT QH.score FROM quizHistory QH " +
                "where QH.quiz_id = ? AND QH.user_id = ?;");

        prepStmt.setInt(1, quiz_id);
        prepStmt.setInt(2,user_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs.getInt(1);
    }

    @Override
    public int getTime(int quiz_id, int user_id) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement("SELECT QH.quiz_time FROM quizHistory QH " +
                "where QH.quiz_id = ? AND QH.user_id = ?;");

        prepStmt.setInt(1, quiz_id);
        prepStmt.setInt(2,user_id);

        ResultSet rs = prepStmt.executeQuery();

        return rs.getInt(1);
    }

    @Override
    public List<Integer> getStats(int quiz_id) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM quizHistory QH " +
                "where QH.quiz_id = ?;");

        prepStmt.setInt(1, quiz_id);

        ResultSet rs = prepStmt.executeQuery();

        return null;
    }
}
