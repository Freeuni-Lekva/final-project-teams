//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ObjectClasses;

import DAOs.AccountDAO;
import java.sql.SQLException;

public class Mail {
    private final String sender;
    private final String receiver;
    private final String type;
    private final String message;

    public Mail(int sender_id, int receiver_id, String type, String message) throws SQLException {
        AccountDAO accountDAO = new AccountDAO();
        this.sender = accountDAO.getUserNameByAccountId(sender_id);
        this.receiver = accountDAO.getUserNameByAccountId(receiver_id);
        this.type = type;
        this.message = message;
    }

    public String getSender() {
        return this.sender;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getMessage() {
        return this.message;
    }

    public String getType() {
        return this.type;
    }
}
