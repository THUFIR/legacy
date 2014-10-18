package legacy.gui.panels;

import java.util.logging.Logger;
import legacy.database.Clients;
import legacy.database.User;
import legacy.gui.helpers.LengthRestrictedDocument;

public class Contact extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(Contact.class.getName());
    private Clients bean = new Clients();

    public Contact() {
        initComponents();
        init2();
    }

    private void init2() {
        address.setDocument(new LengthRestrictedDocument(12));
        city.setDocument(new LengthRestrictedDocument(12));
        company.setDocument(new LengthRestrictedDocument(12));
        address.setDocument(new LengthRestrictedDocument(12));
        address.setDocument(new LengthRestrictedDocument(12));
        country.setDocument(new LengthRestrictedDocument(6));
        province.setDocument(new LengthRestrictedDocument(2));
        postal.setDocument(new LengthRestrictedDocument(6));
        phone1.setDocument(new LengthRestrictedDocument(10));
        phone2.setDocument(new LengthRestrictedDocument(10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        top = new javax.swing.JScrollPane();
        fields = new javax.swing.JPanel();
        companyL = new javax.swing.JLabel();
        company = new javax.swing.JTextField();
        nameL = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        addressL = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        cityL = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        provinceL = new javax.swing.JLabel();
        province = new javax.swing.JTextField();
        postalL = new javax.swing.JLabel();
        postal = new javax.swing.JTextField();
        countryL = new javax.swing.JLabel();
        country = new javax.swing.JTextField();
        phone1L = new javax.swing.JLabel();
        phone1 = new javax.swing.JTextField();
        phone2L = new javax.swing.JLabel();
        phone2 = new javax.swing.JTextField();
        emailL = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        bottom = new javax.swing.JScrollPane();
        notes = new javax.swing.JTextPane();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        fields.setLayout(new java.awt.GridLayout(11, 2));

        companyL.setText("company");
        fields.add(companyL);

        company.setMinimumSize(new java.awt.Dimension(10, 200));
        fields.add(company);

        nameL.setText("name");
        fields.add(nameL);
        fields.add(name);

        addressL.setText("address");
        fields.add(addressL);
        fields.add(address);

        cityL.setText("city");
        fields.add(cityL);
        fields.add(city);

        provinceL.setText("province");
        fields.add(provinceL);
        fields.add(province);

        postalL.setText("postal code");
        fields.add(postalL);
        fields.add(postal);

        countryL.setText("country");
        fields.add(countryL);

        country.setText("Canada");
        fields.add(country);

        phone1L.setText("phone 1");
        fields.add(phone1L);

        phone1.setText("0");
        fields.add(phone1);

        phone2L.setText("phone 2");
        fields.add(phone2L);
        fields.add(phone2);

        emailL.setText("email");
        fields.add(emailL);
        fields.add(email);

        top.setViewportView(fields);

        jSplitPane1.setLeftComponent(top);

        bottom.setViewportView(notes);

        jSplitPane1.setRightComponent(bottom);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel addressL;
    private javax.swing.JScrollPane bottom;
    private javax.swing.JTextField city;
    private javax.swing.JLabel cityL;
    private javax.swing.JTextField company;
    private javax.swing.JLabel companyL;
    private javax.swing.JTextField country;
    private javax.swing.JLabel countryL;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailL;
    private javax.swing.JPanel fields;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameL;
    private javax.swing.JTextPane notes;
    private javax.swing.JTextField phone1;
    private javax.swing.JLabel phone1L;
    private javax.swing.JTextField phone2;
    private javax.swing.JLabel phone2L;
    private javax.swing.JTextField postal;
    private javax.swing.JLabel postalL;
    private javax.swing.JTextField province;
    private javax.swing.JLabel provinceL;
    private javax.swing.JScrollPane top;
    // End of variables declaration//GEN-END:variables

    private void populate() {
        init2();
        try {
            address.setText(bean.getAddress());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            city.setText(bean.getCity());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            company.setText(bean.getCompany());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            country.setText(bean.getCountry());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            email.setText(bean.getEmail());
        } catch (Exception e) {
        }
        try {
            name.setText(bean.getName());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            phone1.setText(bean.getPhone1());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            phone2.setText(bean.getPhone2());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            postal.setText(bean.getPostal());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            province.setText(bean.getProvince());
        } catch (Exception e) {
            log.warning(e.toString());
        }
        try {
            notes.setText(bean.getNotes());
        } catch (Exception e) {
            log.warning(e.toString());
        }
    }

    public void setClients(Clients bean) {
        this.bean = bean;
        populate();
    }

    public Clients getClientsBean() {
        bean.setAddress(address.getText());
        bean.setCity(city.getText());
        bean.setCompany(company.getText());
        bean.setCountry(country.getText());
        bean.setEmail(email.getText());
        bean.setName(name.getText());
        bean.setNotes(notes.getText());
        bean.setPhone1(phone1.getText());
        bean.setPhone2(phone2.getText());
        bean.setPostal(postal.getText());
        bean.setProvince(province.getText());
        return bean;
    }

    public void setUser(User user) {
        log.fine(user.toString());
    }

}
