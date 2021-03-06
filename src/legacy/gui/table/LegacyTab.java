package legacy.gui.table;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import legacy.database.Clients;
import legacy.database.Criteria;
import legacy.database.Queries;
import legacy.database.User;
import legacy.database.UserRole;
import legacy.gui.panels.QueriesPanel;

public class LegacyTab extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(LegacyTab.class.getName());
    private final ClientsTable table;
    private final Queries q = Queries.INSTANCE;
    private final QueriesPanel queriesPanel;
    private User user;

    private LegacyTab() {
        List<UserRole> roles = new ArrayList<>();
        roles.add(UserRole.OPENER);
        user = new User("foo", "bar");
        initComponents();
        table = new ClientsTable();
        queriesPanel = new QueriesPanel(user);
        topA.add(queriesPanel, BorderLayout.CENTER);
        bottomA.add(table, BorderLayout.CENTER);
        addSearchBoxListener();
        addRowSelectedListener();
    }

    public LegacyTab(User user) {
        this.user = user;
        initComponents();
        table = new ClientsTable();
        queriesPanel = new QueriesPanel(user);
        topA.add(queriesPanel, BorderLayout.CENTER);
        bottomA.add(table, BorderLayout.CENTER);
        addSearchBoxListener();
        addRowSelectedListener();
        if (user.getRoles().contains(UserRole.OPENER)) {
            setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        split = new javax.swing.JSplitPane();
        top = new javax.swing.JScrollPane();
        topA = new javax.swing.JPanel();
        bottom = new javax.swing.JScrollPane();
        bottomA = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        split.setDividerLocation(150);
        split.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        topA.setLayout(new java.awt.BorderLayout());
        top.setViewportView(topA);

        split.setTopComponent(top);

        bottomA.setLayout(new java.awt.BorderLayout());
        bottom.setViewportView(bottomA);

        split.setBottomComponent(bottom);

        add(split, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bottom;
    private javax.swing.JPanel bottomA;
    private javax.swing.JSplitPane split;
    private javax.swing.JScrollPane top;
    private javax.swing.JPanel topA;
    // End of variables declaration//GEN-END:variables

    private void addSearchBoxListener() {
        queriesPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("criteria".equals(evt.getPropertyName())) {
                    table.select((Criteria) evt.getNewValue());
                }
            }
        });
    }

    private void addRowSelectedListener() {
        table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("client".equals(evt.getPropertyName())) {
                    String s = evt.getNewValue().toString();
                    int i = Integer.parseInt(s);
                    fire(i);
                }
            }
        });
    }

    private void fire(int i) {
        Clients b = q.findById(i);
        this.firePropertyChange("client", null, b);
    }

    public void setUser(User user) {
        //     queriesPanel.setUser(user);
        table.setUser(user);
        if (user.getRoles().contains(UserRole.OPENER)) {
            table.setVisible(false);
        }
        log.fine(user.toString());
    }

}
