package legacy.gui.panels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import legacy.database.Criteria;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import legacy.database.User;
import legacy.database.UserRole;
import legacy.gui.helpers.CloserModel;
import legacy.gui.helpers.FieldQueryModel;
import legacy.gui.helpers.OpenerModel;
import legacy.gui.helpers.StatusModel;

public class QueriesPanel extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(QueriesPanel.class.getName());
    private final OpenerModel o;
    private final CloserModel c;
    private final StatusModel s;
    private Criteria crit;
    private User user;
    private FieldQueryModel fieldQueryModel;
    private FieldQueryModel c2;
    private FieldQueryModel c3;

    private QueriesPanel() {
        initComponents();
        List<UserRole> roles = new ArrayList<>();
        user = new User("foo", "bar");
        fieldQueryModel = new FieldQueryModel(user);
        o = new OpenerModel(user);
        c = new CloserModel(user);
        s = new StatusModel();

        crit1.setModel(fieldQueryModel);
        crit2.setModel(fieldQueryModel);
        crit3.setModel(fieldQueryModel);

        crit1.setModel(new DefaultComboBoxModel(new String[]{"name"}));
        crit2.setModel(new DefaultComboBoxModel(new String[]{"phone"}));
        crit3.setModel(new DefaultComboBoxModel(new String[]{"email"}));

        opener.setModel(o);
        closer1.setModel(c);
        status.setModel(s);
    }

    public QueriesPanel(User user) {
        this.user = user;
        initComponents();
        o = new OpenerModel(user);
        c = new CloserModel(user);
        s = new StatusModel();
        fieldQueryModel = new FieldQueryModel(user);
        crit1.setModel(fieldQueryModel);
        crit2.setModel(fieldQueryModel);
        crit3.setModel(fieldQueryModel);

        crit1.setModel(new DefaultComboBoxModel(new String[]{"name"}));
        crit2.setModel(new DefaultComboBoxModel(new String[]{"phone"}));
        crit3.setModel(new DefaultComboBoxModel(new String[]{"email"}));

        opener.setModel(o);
        closer1.setModel(c);
        status.setModel(s);
        center.setVisible(user.getRoles().contains(UserRole.MANAGER) || user.getRoles().contains(UserRole.CLOSER));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        center = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        scrollLeft = new javax.swing.JScrollPane();
        left = new javax.swing.JPanel();
        criteria = new javax.swing.JPanel();
        crit1 = new javax.swing.JComboBox();
        crit1F = new javax.swing.JTextField();
        crit2 = new javax.swing.JComboBox();
        crit2F = new javax.swing.JTextField();
        crit3 = new javax.swing.JComboBox();
        crit3F = new javax.swing.JTextField();
        oldRight = new javax.swing.JPanel();
        closerL = new javax.swing.JLabel();
        closer1 = new javax.swing.JComboBox();
        openerL = new javax.swing.JLabel();
        opener = new javax.swing.JComboBox();
        statusL = new javax.swing.JLabel();
        status = new javax.swing.JComboBox();
        scrollRight = new javax.swing.JScrollPane();
        search = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        center.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(600);

        left.setLayout(new java.awt.GridLayout(1, 2));

        criteria.setLayout(new java.awt.GridLayout(3, 2));

        crit1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        criteria.add(crit1);
        criteria.add(crit1F);

        crit2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        criteria.add(crit2);
        criteria.add(crit2F);

        crit3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        criteria.add(crit3);
        criteria.add(crit3F);

        left.add(criteria);

        oldRight.setLayout(new java.awt.GridLayout(3, 2));

        closerL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        closerL.setText("closer 1");
        oldRight.add(closerL);

        closer1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        oldRight.add(closer1);

        openerL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        openerL.setText("opener");
        oldRight.add(openerL);

        opener.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        oldRight.add(opener);

        statusL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        statusL.setText("status");
        oldRight.add(statusL);

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        oldRight.add(status);

        left.add(oldRight);

        scrollLeft.setViewportView(left);

        jSplitPane1.setLeftComponent(scrollLeft);

        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        scrollRight.setViewportView(search);

        jSplitPane1.setRightComponent(scrollRight);

        center.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String openerString = opener.getSelectedItem().toString();
        String closerString = closer1.getSelectedItem().toString();
        String statusString = status.getSelectedItem().toString();
        String crit1 = crit1F.getText();
        String crit2 = crit2F.getText();
        String crit3 = crit3F.getText();
        crit = new Criteria(openerString, closerString, statusString, crit1, crit2, crit3);

        String q1a = crit1;
        String q1b = crit1F.getText();
        String q2a = crit2;
        String q2b = crit2F.getText();
        String q3a = crit3;
        String q3b = crit3F.getText();

        Map<String, String> m = new HashMap<>();
        m.put("opener", openerString);
        m.put("closer", openerString);
        m.put("status", openerString);
        m.put(q1a, q1b);
        m.put(q2a, q2b);
        m.put(q3a, q3b);

        //   crit = new Criteria(m);
        this.firePropertyChange("criteria", null, crit);
    }//GEN-LAST:event_searchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel center;
    private javax.swing.JComboBox closer1;
    private javax.swing.JLabel closerL;
    private javax.swing.JComboBox crit1;
    private javax.swing.JTextField crit1F;
    private javax.swing.JComboBox crit2;
    private javax.swing.JTextField crit2F;
    private javax.swing.JComboBox crit3;
    private javax.swing.JTextField crit3F;
    private javax.swing.JPanel criteria;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel oldRight;
    private javax.swing.JComboBox opener;
    private javax.swing.JLabel openerL;
    private javax.swing.JScrollPane scrollLeft;
    private javax.swing.JScrollPane scrollRight;
    private javax.swing.JButton search;
    private javax.swing.JComboBox status;
    private javax.swing.JLabel statusL;
    // End of variables declaration//GEN-END:variables

}
