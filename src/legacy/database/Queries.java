package legacy.database;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public enum Queries {

    INSTANCE;
    private final Logger log = Logger.getLogger(Queries.class.getName());
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LegacyDatabasePU");
    EntityManager em = emf.createEntityManager();

    private EntityManager reconnect() {
        emf = Persistence.createEntityManagerFactory("LegacyDatabasePU");
        em = emf.createEntityManager();
        log.info("em\t" + em.isOpen());
        return em;
    }

    private List<Clients> findAll() {
        reconnect();
        Query q = em.createQuery("select c from Clients c");
        List<Clients> clients = q.getResultList();
        em.close();
        emf.close();
        return clients;
    }

    public List<Clients> selectByCriteria(Criteria criteria) {
        log.info(criteria.toString());
        reconnect();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Clients> clientCriteriaQuery = criteriaBuilder.createQuery(Clients.class);
        Root<Clients> clientRoot = clientCriteriaQuery.from(Clients.class);
        clientCriteriaQuery.select(clientRoot);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.name), "%" + criteria.getName() + "%"));
        predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.phone1), "%" + criteria.getPhone1() + "%"));
        predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.email), "%" + criteria.getEmail() + "%"));
        if (!criteria.getOpener().equalsIgnoreCase("all")) {
            predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.opener), "%" + criteria.getOpener() + "%"));
        }
        if (!criteria.getCloser1().equalsIgnoreCase("all")) {
            predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.closer1), "%" + criteria.getCloser1() + "%"));
        }
        if (!criteria.getStatus().equalsIgnoreCase("all")) {
            predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.status), "%" + criteria.getStatus() + "%"));
        }
        clientCriteriaQuery.where(predicates.toArray(new Predicate[0]));
        List<Clients> clients = em.createQuery(clientCriteriaQuery).getResultList();
        em.close();
        emf.close();
        return clients;
    }

    public Clients findById(int id) {
        reconnect();
        Clients client = em.find(Clients.class, id);
        em.close();
        emf.close();
        return client;
    }

    public void send(int id) {
        reconnect();
        Clients c = em.find(Clients.class, id);
        java.util.Date date = new java.util.Date();
        Timestamp t = new Timestamp(date.getTime());
        em.getTransaction().begin();
        c.setDateUpdated(t.toString());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private Timestamp stamp() {
        Date d = new Date();
        return new Timestamp(d.getTime());
    }

    private int oldPersist(Clients client) {
        log.info(client.toString());
        reconnect();
        client.setDateCreated(stamp().toString());
        log.info("starting transaction...");
        em.getTransaction().begin();
        log.info("..transaction started..");
        em.persist(client);
        log.info("..client persisted..");
        em.getTransaction().commit();
        log.info("..comitted..");
        em.close();
        emf.close();
        log.info("transaction complete...");
        return client.getId();
    }

    public int persistClient(Clients client) {
        reconnect();
        em.getTransaction().begin();
        Clients c = new Clients();
        em.persist(c);
        em.flush();
        int id = c.getId();
        em.getTransaction().commit();
        em.close();
        emf.close();
        client.setId(id);
        update(client);
        return id;
    }

    public int update(Clients newClient) {
        reconnect();
        Clients oldClient = em.find(Clients.class, newClient.getId());
        em.getTransaction().begin();
        oldClient.setAddress(newClient.getAddress());
        oldClient.setCity(newClient.getCity());
        oldClient.setCloser1(newClient.getCloser1());
        oldClient.setCloser2(newClient.getCloser2());
        oldClient.setCountry(newClient.getCountry());
        oldClient.setCompany(newClient.getCompany());
        oldClient.setDateCancelled(newClient.getDateCancelled());
        oldClient.setDateSold(newClient.getDateSold());
       
        try {
            if ((oldClient.getDateCreated().length() < 3) || (oldClient.getDateCreated() == null)) {
                oldClient.setDateCreated(stamp().toString());
            }
        } catch (NullPointerException e) {
            log.info("no date");
        }
        oldClient.setDateUpdated(stamp().toString());
        oldClient.setDescription(newClient.getDescription());
        oldClient.setEmail(newClient.getEmail());
        oldClient.setExteriorColor(newClient.getExteriorColor());
        oldClient.setFeatures(newClient.getFeatures());
        //no id set
        oldClient.setInteriorColor(newClient.getInteriorColor());
        oldClient.setInteriorType(newClient.getInteriorType());
        oldClient.setKilometres(newClient.getKilometres());
        oldClient.setMake(newClient.getMake());
        oldClient.setMileageType(newClient.getMileageType());
        oldClient.setModel(newClient.getModel());
        oldClient.setNotes(newClient.getNotes());
        oldClient.setOpener(newClient.getOpener());
        oldClient.setPaymentMethod(newClient.getPaymentMethod());
        oldClient.setPhone1(newClient.getPhone1());
        oldClient.setPhone2(newClient.getPhone2());
        oldClient.setPostal(newClient.getPostal());
        oldClient.setPrice(newClient.getPrice());
        oldClient.setProvince(newClient.getProvince());
        oldClient.setRecording(newClient.getRecording());
        oldClient.setRefunded(newClient.getRefunded());
        oldClient.setRegFee(newClient.getRegFee());
        oldClient.setStatus(newClient.getStatus());
        oldClient.setTaxRate(newClient.getTaxRate());
        oldClient.setTrim(newClient.getTrim());
        oldClient.setVerifier(newClient.getVerifier());
        oldClient.setYear(newClient.getYear());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return newClient.getId();
    }
}
