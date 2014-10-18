package legacy.database;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyProps {

    private static final Logger log = Logger.getLogger(MyProps.class.getName());
    private final Properties props = new Properties();
    private String dbUser = "user";
    private String dbPassword = "password";
    private int dbPort = 8080;
    private int serverPort = 8080;
    private String dbUrl = "localhost";
    private String dbDriver = "mysql";
    private boolean ssl = false;

    public MyProps() {
        getProps();
        load();
    }

    private void load() {
        dbUser = props.getProperty("dur.db.user");
        dbPassword = props.getProperty("dur.db.password");
        dbPort = Integer.parseInt(props.getProperty("dur.db.port"));
        dbUrl = props.getProperty("dur.db.url");
        dbDriver = props.getProperty("dur.db.driver");
    }

    public Properties getProps() {
        log.fine(props.toString());
        try {
            props.load(MyProps.class.getResourceAsStream("/client.properties"));
        } catch (IOException ex) {
            Logger.getLogger(MyProps.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.fine(props.toString());
        return props;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public int getDbPort() {
        return dbPort;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getJndiName() {
        return "foo";
    }

    public boolean getSSL() {
        return ssl;
    }

    public String getHost() {
        return "localhost";
    }

    @Override
    public String toString() {
        return dbDriver + dbUser + dbPassword + dbPort;
    }

}
