package legacy.database;

import java.util.Map;
import java.util.logging.Logger;

public class Criteria {

    private static final Logger log = Logger.getLogger(Criteria.class.getName());
     private String opener;
     private String closer1;
     private String status;
     private String name;
     private String phone1;
     private String email;

    private Criteria() {
    }

    public Criteria(String... s) {
        opener = s[0];
        closer1 = s[1];
        status = s[2];
        name = s[3];
        phone1 = s[4];
        email = s[5];
    }


    @Override
    public String toString() {
        return getOpener() + getCloser1() + getStatus() + getName() + getPhone1() + getEmail();
    }

    public String getOpener() {
        return opener;
    }

    public void setOpener(String opener) {
        this.opener = opener;
    }

    public String getCloser1() {
        return closer1;
    }

    public void setCloser1(String closer1) {
        this.closer1 = closer1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
