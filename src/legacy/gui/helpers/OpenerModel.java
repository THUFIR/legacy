package legacy.gui.helpers;

import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import legacy.database.User;
import legacy.database.UserRole;

public class OpenerModel extends DefaultComboBoxModel {

    private static final Logger log = Logger.getLogger(OpenerModel.class.getName());
    private User u;

    private OpenerModel() {
        removeAllElements();
        addElement("all");
        addElement("chelsey");
        addElement("zach");
        addElement("danelle");
        addElement("nick");
    }

    public OpenerModel(User u) {
        this.u = u;
        removeAllElements();
        if (u.getRoles().contains(UserRole.OPENER) && !u.getRoles().contains(UserRole.CLOSER)) {
            addElement(u.getUser());
        } else {
            addElement("all");
            addElement("zach");
            addElement("danelle");
            addElement("nick");
        }
    }

    void setUser(User user) {
        log.fine(user.toString());
    }
}
