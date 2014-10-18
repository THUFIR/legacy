package legacy.gui.helpers;

import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import legacy.database.User;

public class FieldQueryModel extends DefaultComboBoxModel {

    private static final Logger log = Logger.getLogger(FieldQueryModel.class.getName());
    private final User user;

    public FieldQueryModel() {
        user = new User();
        init();
    }

    public FieldQueryModel(User user) {
        this.user = user;
        init();
    }

    private void init() {
        removeAllElements();
        addElement("name");
        addElement("phone");
        addElement("email");
    }
}
