package legacy.gui.table;

import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import legacy.database.Clients;
import legacy.database.Criteria;
import legacy.database.Queries;

public class ClientsTableModel extends DefaultTableModel {

    private static final Logger log = Logger.getLogger(ClientsTableModel.class.getName());
    Queries q = Queries.INSTANCE;

    public ClientsTableModel() {
        log.fine("created..");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void select(Criteria c) {
        populate(q.selectByCriteria(c));
    }

    private void populate(List<Clients> clients) {
        populateColumns();
        dataVector = new Vector();
        log.fine(clients.toString());
        Vector clientVector = null;
        for (Clients c : clients) {
            clientVector = new Vector();
            long id = c.getId();
            String date = c.getDateCreated();
            String model = c.getModel();
            String phone1 = c.getPhone1();
            String features = c.getFeatures();
            clientVector.add(id);
            clientVector.add(date);
            clientVector.add(model);
            clientVector.add(phone1);
            clientVector.add(features);
            dataVector.add(clientVector);
        }
    }

    private void populateColumns() {
        columnIdentifiers = new Vector();
        columnIdentifiers.add("id");
        columnIdentifiers.add("date");
        columnIdentifiers.add("vehicle");
        columnIdentifiers.add("phone1");
        columnIdentifiers.add("features");
    }
}
