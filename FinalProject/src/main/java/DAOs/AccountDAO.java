package DAOs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    private final Connection conn;

    public AccountDAO(){
        this.conn = DBConnection.getConnection();
    }

    public boolean accountUsernameExists(String username) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement("SELECT a.id FROM accounts a " +
                "where a.username = ?;");
        prepStmt.setString(1, username);
        ResultSet rs = prepStmt.executeQuery();
        if(rs.next()) return true;
        return false;
    }

    public boolean isAccountValid(String username, String password) throws SQLException, NoSuchAlgorithmException {
        String hash = hashString(password);
        PreparedStatement prepStmt = conn.prepareStatement("SELECT a.id FROM accounts a " +
                "where a.username = ? AND a.password_hash = ?;");
        prepStmt.setString(1, username);
        prepStmt.setString(2, hash);
        ResultSet rs = prepStmt.executeQuery();
        if(rs.next()) return true;
        return false;
    }

    public boolean addAccount(String username, String password) throws SQLException, NoSuchAlgorithmException {
        if(!accountUsernameExists(username)){
            String hash = hashString(password);
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO accounts (username, password_hash) " +
                    " VALUES (?, ?);");
            prepStmt.setString(1, username);
            prepStmt.setString(2, hash);
            prepStmt.executeUpdate();
            return true;
        }
        return false;
    }

    // amaze ar vici vabshe
    public ResultSet searchAccountByUsername(String username){
        return null;
    }

    // returns Account Id by using its username. returns -1 if there is no such account with the
    // passed username
    public int getAccountIdByUsername(String username) throws SQLException {
        AccountDAO accDao = new AccountDAO();
        if(accDao.accountUsernameExists(username)){
            PreparedStatement prepStmt = conn.prepareStatement("SELECT a.id FROM accounts a " +
                    "where a.username = ?;");
            prepStmt.setString(1, username);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        } else {
            return -1;
        }
    }

    private static String hexToString(byte[] bytes) {
        StringBuffer buff = new StringBuffer();
        for (int i=0; i<bytes.length; i++) {
            int val = bytes[i];
            val = val & 0xff;  // remove higher bits, sign
            if (val<16) buff.append('0'); // leading 0
            buff.append(Integer.toString(val, 16));
        }
        return buff.toString();
    }

    private String hashString(String s) throws NoSuchAlgorithmException {
        String result = "";

        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(s.getBytes());

        byte[] digest = md.digest();

        result = hexToString(digest);

        return result;
    }
}