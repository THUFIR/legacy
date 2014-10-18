package legacy.database;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class User {

    private static final Logger log = Logger.getLogger(User.class.getName());
    private String user;
    private String password;
    private List<UserRole> roles = new ArrayList<>();

    private User() {
    }

    public User(String... s) {
        user = s[0];
        password = s[1];
        switch (user) {
            case "adam":
                roles.add(UserRole.CLOSER);
                password = "fklds362";
                break;
            case "john":
                roles.add(UserRole.CLOSER);
                password = "jklhjkl47457";
                break;
            case "tiffiny":
                roles.add(UserRole.OPENER);
                password = "fghf654";
                break;
            case "chelley":
                roles.add(UserRole.CLOSER);
                password = "mvjmf643";
                password = "mellon";
                break;
            case "chelsey":
                roles.add(UserRole.OPENER);
                password = "mvjmf643";
                password = "mellon";
                break;
            case "zach":
                roles.add(UserRole.OPENER);
                password = "hjk57";
                break;
            case "danelle":
                roles.add(UserRole.OPENER);
                password = "wer467";
                break;
            case "nick":
                roles.add(UserRole.OPENER);
                password = "mklj965";
                break;
            case "tia":
                roles.add(UserRole.MANAGER);
                password = "dghbv0757";
                break;
            case "tia2":
                roles.add(UserRole.MANAGER);
                password = "dghbv0757";
                break;
            case "doreen":
                roles.add(UserRole.MANAGER);
                password = "dnfgh2863";
                break;
            case "admin":
                roles.add(UserRole.MANAGER);
                password = "Trek4100";
                break;
            default:
                roles.add(UserRole.OPENER);
                password = "friend";
                break;
        }
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return user + "\t" + roles.toString();
    }

}
