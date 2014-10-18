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

public enum Database {

    INSTANCE;
    private final Logger log = Logger.getLogger(Database.class.getName());

    private EntityManager connect() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LegacyDatabasePU");
        EntityManager em = emf.createEntityManager();
        log.fine("" + em.isOpen());
        return em;
    }

    private List<Clients> findAll() {
        EntityManager em = connect();
        Query q = em.createQuery("select c from Clients c");
        List<Clients> clients = q.getResultList();
        em.close();
        return clients;
    }

    public List<Clients> selectByCriteria(Criteria criteria) {
        log.info(criteria.toString());
        EntityManager em = connect();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Clients> clientCriteriaQuery = criteriaBuilder.createQuery(Clients.class);
        Root<Clients> clientRoot = clientCriteriaQuery.from(Clients.class);
        clientCriteriaQuery.select(clientRoot);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.name), "%" + criteria.getName() + "%"));
        predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.phone1), "%" + criteria.getPhone1() + "%"));
        predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.email), "%" + criteria.getEmail() + "%"));
        if (!criteria.getStatus().equalsIgnoreCase("all")) {
            predicates.add(criteriaBuilder.like(clientRoot.get(Clients_.status), "%" + criteria.getStatus() + "%"));
        }
        clientCriteriaQuery.where(predicates.toArray(new Predicate[0]));
        List<Clients> clients = em.createQuery(clientCriteriaQuery).getResultList();
        em.close();
        return clients;
    }

    public Clients findById(int id) {
        EntityManager em = connect();
        Clients client = em.find(Clients.class, id);
        em.close();
        return client;
    }

    public void send(int id) {
        EntityManager em = connect();
        Clients c = em.find(Clients.class, id);
        java.util.Date date = new java.util.Date();
        Timestamp t = new Timestamp(date.getTime());
        em.getTransaction().begin();
        c.setDateUpdated(t.toString());
        em.getTransaction().commit();
        em.close();
    }

    private Timestamp stamp() {
        Date d = new Date();
        return new Timestamp(d.getTime());
    }

    public int persistClient(Clients client) {
        EntityManager em = connect();
        client.setDateCreated(stamp().toString());
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        log.fine(client.getTrim());
        em.close();
        return client.getId();
    }

    public int update(Clients newClient) {
        EntityManager em = connect();
        Clients oldClient = em.find(Clients.class, newClient.getId());
        em.getTransaction().begin();
        oldClient.setAddress(newClient.getAddress());
        oldClient.setCity(newClient.getCity());
        oldClient.setCountry(newClient.getCountry());
        oldClient.setCompany(newClient.getCompany());
        oldClient.setDateUpdated(stamp().toString());
        oldClient.setDescription(newClient.getDescription());
        oldClient.setEmail(newClient.getEmail());
        em.getTransaction().commit();
        em.close();
        return newClient.getId();
    }
}
