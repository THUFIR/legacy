package legacy.gui.panels;

import java.util.logging.Logger;
import legacy.database.Clients;

public class ClientsPanel extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(ClientsPanel.class.getName());

    public ClientsPanel() {
        initComponents();
    }

    public void setRecord(Clients c) {
        record.setText(c.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        record = new javax.swing.JTextPane();

        setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(record);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane record;
    // End of variables declaration//GEN-END:variables
}
