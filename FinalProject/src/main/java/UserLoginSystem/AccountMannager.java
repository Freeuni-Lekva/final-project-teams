package UserLoginSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class AccountMannager {
    private Connection accountsDB;
    private int id;

    public AccountMannager(Connection conn){
        accountsDB = conn;
        id = 1;
    }

    public boolean accountExists(String name){
        return false;
    }
    public boolean enterAccount(String name, String password){
        return false;
    }
    public void addAccount(String name, String password){

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
