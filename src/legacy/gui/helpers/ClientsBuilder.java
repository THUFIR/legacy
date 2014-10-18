package legacy.gui.helpers;

import java.util.logging.Logger;
import legacy.database.Clients;

public class ClientsBuilder extends Clients {

    private static final Logger log = Logger.getLogger(ClientsBuilder.class.getName());
    private final Clients b = new Clients();

    private ClientsBuilder() {
    }

    public ClientsBuilder(Clients c, Clients v, Clients s) {
        b.setAddress(c.getAddress());
        b.setCity(c.getCity());
        b.setCloser1(s.getCloser1());
        b.setCloser2(s.getCloser2());
        b.setCompany(c.getCompany());
        b.setConfirmation(s.getConfirmation());
        b.setCountry(c.getCountry());
        b.setDateCancelled(s.getDateCancelled());
        b.setDateCreated(c.getDateCreated());
        b.setDateSold(s.getDateSold());
      //  b.setDateUpdated(s.getDateUpdated());  // ????????
        b.setDescription(v.getDescription());
        b.setEmail(c.getEmail());
        b.setExteriorColor(v.getExteriorColor());
        b.setFeatures(s.getFeatures());
        b.setId(c.getId()); //*****
        b.setInteriorColor(v.getInteriorColor());
        b.setInteriorType(v.getInteriorType());
        b.setKilometres(v.getKilometres());
        b.setMake(v.getMake());
        b.setMileageType(v.getMileageType());
        b.setModel(v.getModel());
        b.setName(c.getName());
        b.setNotes(c.getNotes());
        b.setOpener(s.getOpener());
        b.setPaymentMethod(s.getPaymentMethod());
        b.setPhone1(c.getPhone1());
        b.setPhone2(c.getPhone2());
        b.setPostal(c.getPostal());
        b.setPrice(v.getPrice());
        b.setProvince(c.getProvince());
        b.setRecording(s.getRecording());
        b.setRefunded(s.getRefunded());
        b.setRegFee(s.getRegFee());
        b.setStatus(s.getStatus());
        b.setTaxRate(s.getTaxRate());
        b.setTrim(v.getTrim());
        b.setVerifier(s.getVerifier());
        b.setYear(v.getYear());
        log.fine(b.toString());
    }

    public Clients getBean() {
        return b;
    }
}
