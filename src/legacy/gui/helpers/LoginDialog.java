package legacy.gui.helpers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import legacy.database.User;

public class LoginDialog extends javax.swing.JDialog {

    private static final Logger log = Logger.getLogger(LoginDialog.class.getName());
    private final JLabel jlblUsername = new JLabel("Username");
    private final JLabel jlblPassword = new JLabel("Password");
    private final JTextField jtfUsername = new JTextField(15);
    private final JPasswordField jpfPassword = new JPasswordField();
    private final JButton jbtOk = new JButton("Login");
    private final JButton jbtCancel = new JButton("Cancel");
    private final JLabel jlblStatus = new JLabel(" ");
    private User user;
    private LoginDialog() {
        this(null, true);
    }

    private LoginDialog(Frame parent, boolean modal) {
        super(parent, modal);
        log.fine("simple constructor..");
        initComponents();
    }

    public LoginDialog(final JFrame parent, boolean modal) {
        super(parent, modal);
        log.fine("complex constructor..");
        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(jlblUsername);
        p3.add(jlblPassword);
        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);
        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);
        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jbtOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User u = new User(jtfUsername.getText(), new String(jpfPassword.getPassword()));
                    if (Arrays.equals(u.getPassword().toCharArray(), jpfPassword.getPassword())
                            && u.getUser().equals(jtfUsername.getText())) {
                        user = new User(jtfUsername.getText(), new String(jpfPassword.getPassword()));
                        parent.setVisible(true);
                        setVisible(false);
                    } else {
                        jlblStatus.setText("Invalid username or password");
                    }
                
            }
        });
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
                System.exit(0);
            }
        });
    }

    private void fire(User user) {
        this.firePropertyChange("user", null, user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public User getUser() {
        return user;
    }
}
