package legacy.gui.helpers;

import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import legacy.database.User;

public class StatusModel extends DefaultComboBoxModel {

    private static final Logger log = Logger.getLogger(StatusModel.class.getName());

    public StatusModel() {
        removeAllElements();
        addElement("all");
        addElement("active");
        addElement("sold");
        addElement("cancelled");
        addElement("opened1");
        addElement("opened2");
        addElement("verify");
        addElement("not_interested");
    }

    void setUser(User user) {
        log.fine(user.toString());
    }
}
