package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailsDao {

    private static final String ADD_FRIEND = "addFriend";
    private static final String CHALLENGE_QUIZ = "challengeQuiz";
    private static final String MESSAGE = "message";

    private final Connection conn;

    public MailsDao(){
        this.conn = DBConnection.getConnection();
    }

    public List<Integer> getReceivedMailsForUser(String userName) throws SQLException {
        AccountDAO accDao = new AccountDAO();
        PreparedStatement prepStmt = conn.prepareStatement("SELECT id FROM mails WHERE " +
                "receiver_id = ?;");
        prepStmt.setInt(1, accDao.getAccountIdByUsername(userName));
        ResultSet rs = prepStmt.executeQuery();

        List<Integer> mails = new ArrayList<>();

        while(rs.next()){
            mails.add(rs.getInt("id"));
        }

        return mails;

    }

    public boolean addMail(String senderUserName, String receiverUserName, String mailType, String message) throws SQLException {
        if(senderUserName.trim().length() == 0 || receiverUserName.trim().length() == 0 || mailType.trim().length() == 0) return false;
        if(!mailType.equals(ADD_FRIEND) && !mailType.equals(CHALLENGE_QUIZ) && !mailType.equals(MESSAGE)) return false;
        AccountDAO accDao = new AccountDAO();
        if(accDao.accountUsernameExists(senderUserName) && accDao.accountUsernameExists(receiverUserName) ){
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO mails (sender_id, receiver_id, mail_type, message) " +
                    " VALUES (?, ?, ?, ?);");
            prepStmt.setString(1, senderUserName);
            prepStmt.setString(2, receiverUserName);
            prepStmt.setString(3, mailType);
            prepStmt.setString(4, message);
            prepStmt.executeUpdate();
            return true;
        }
        return false;
    }

}
