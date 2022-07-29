package DAOs;

import java.sql.Connection;
import java.sql.ResultSet;

public class UserDAO {
    private Connection userConnection;
    private Connection skillsConnection;
    private Connection friendConnection;

    public UserDAO(){
        this.userConnection = UserDBConnection.getConnection();
    }

    public boolean accountExists(String name){
        return false;
    }

    public boolean validAccount(String name, String password){
        return false;
    }

    public void addAccount(String name, String password){ }

    public boolean addFriend(String name, String friend){return false;}

    public boolean removeFriend(String name, String friend){
        return false;
    }

    public boolean addSkill(String name, String skill){
        return false;
    }

    public ResultSet searchPeopleBySkill(String skill){
        return null;
    }
}
