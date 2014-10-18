package legacy.gui.panels;

import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.swing.JPanel;
import legacy.database.Clients;
import legacy.database.User;

public class Vehicle extends JPanel {

    private static final Logger log = Logger.getLogger(Vehicle.class.getName());
    private Clients b = new Clients();

    public Vehicle() {
        initComponents();
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
        fields = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        make = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        trim = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        mileage = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        mileageType = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        exterior = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        interior = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        interiorType = new javax.swing.JTextField();
        bottom = new javax.swing.JScrollPane();
        description = new javax.swing.JTextPane();

        setLayout(new java.awt.BorderLayout());

        split.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        fields.setLayout(new java.awt.GridLayout(11, 2));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("year");
        fields.add(jLabel31);

        year.setText("0");
        fields.add(year);

        jLabel32.setText("make");
        fields.add(jLabel32);
        fields.add(make);

        jLabel33.setText("model");
        fields.add(jLabel33);
        fields.add(model);

        jLabel34.setText("trim");
        fields.add(jLabel34);
        fields.add(trim);

        jLabel35.setText("price");
        fields.add(jLabel35);

        price.setText("0");
        fields.add(price);

        jLabel37.setText("mileage");
        fields.add(jLabel37);

        mileage.setText("0");
        fields.add(mileage);

        jLabel38.setText("mileage type");
        fields.add(jLabel38);
        fields.add(mileageType);

        jLabel39.setText("exterior color");
        fields.add(jLabel39);
        fields.add(exterior);

        jLabel40.setText("interior color");
        fields.add(jLabel40);
        fields.add(interior);

        jLabel41.setText("interior type");
        fields.add(jLabel41);
        fields.add(interiorType);

        top.setViewportView(fields);

        split.setTopComponent(top);

        bottom.setViewportView(description);

        split.setBottomComponent(bottom);

        add(split, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bottom;
    private javax.swing.JTextPane description;
    private javax.swing.JTextField exterior;
    private javax.swing.JPanel fields;
    private javax.swing.JTextField interior;
    private javax.swing.JTextField interiorType;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JTextField make;
    private javax.swing.JTextField mileage;
    private javax.swing.JTextField mileageType;
    private javax.swing.JTextField model;
    private javax.swing.JTextField price;
    private javax.swing.JSplitPane split;
    private javax.swing.JScrollPane top;
    private javax.swing.JTextField trim;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables

    public void setB(Clients b) throws NullPointerException {
        this.b = b;
        nullPop();
        try {
            pop();
        } catch (NullPointerException npe) {
            log.severe(npe.toString());
        }
    }

    private void pop() throws NullPointerException {
        exterior.setText(b.getExteriorColor());
        interior.setText(b.getInteriorColor());
        interiorType.setText(b.getInteriorType());
        make.setText(b.getMake());
        mileage.setText(b.getKilometres().toString());
        mileageType.setText(b.getMileageType());
        model.setText(b.getModel());
        price.setText(b.getPrice().toString());
        trim.setText(b.getTrim());
        year.setText(b.getYear().toString());
        description.setText(b.getDescription());
    }

    public void nullPop() {
        exterior.setText("");
        interior.setText("");
        interiorType.setText("");
        make.setText("");
        mileage.setText("0");
        mileageType.setText("");
        model.setText("");
        price.setText("0");
        trim.setText("");
        year.setText("0");
        description.setText("");
    }

    public Clients getB() {
        b.setExteriorColor(exterior.getText());
        b.setInteriorColor(interior.getText());
        b.setInteriorType(interiorType.getText());
        b.setMake(make.getText());
        try {
            b.setKilometres(Integer.parseInt(mileage.getText()));
        } catch (java.lang.NumberFormatException nfe) {
            log.fine(nfe.toString());
        }
        b.setMileageType(mileageType.getText());
        b.setModel(model.getText());
        b.setPrice(BigDecimal.valueOf(Double.parseDouble(price.getText())));
        b.setTrim(trim.getText());
        b.setYear(Integer.parseInt(year.getText()));
        b.setDescription(description.getText());
        log.fine(b.toString());
        return b;
    }

    public void setUser(User user) {
        log.fine(user.toString());
    }
}
