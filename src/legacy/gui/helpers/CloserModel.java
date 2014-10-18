package legacy.gui.helpers;

import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import legacy.database.User;
import legacy.database.UserRole;

public class CloserModel extends DefaultComboBoxModel {

    private static final Logger log = Logger.getLogger(CloserModel.class.getName());
    private User user;

    private CloserModel() {
    }

    public CloserModel(User user) {
        this.user = user;
        removeAllElements();
        addElement("all");
        addElement("opm");
        addElement("adam");
        addElement("justin");
        addElement("john");
        addElement("james");
        addElement("chelsey");
        addElement("tiffany");
        setUser();
    }

    void setUser() {
        if (user.getRoles().contains(UserRole.CLOSER) && !user.getRoles().contains(UserRole.MANAGER)) {
            removeAllElements();
            addElement(user.getUser());
        }
    }
}
