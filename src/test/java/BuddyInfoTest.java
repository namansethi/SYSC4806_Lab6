import Spring.MVC.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BuddyInfoTest {

    @Test
    public void testConstructor() {
        String name = "Bob";
        int number = 123456789;
        BuddyInfo buddy = new BuddyInfo(name,number);
        assertEquals(buddy.getName(),name);
        assertEquals(buddy.getNumber(),number);

    }
    @Test
    public void performJPA() {
        // Creating objects representing some buddyInfos
        BuddyInfo buddyInfo1 = new BuddyInfo();
        buddyInfo1.setId(1L);
        buddyInfo1.setName("Bob");
        buddyInfo1.setNumber(123456789);

        BuddyInfo buddyInfo2 = new BuddyInfo();
        buddyInfo2.setId(2L);
        buddyInfo2.setName("Carl");
        buddyInfo1.setNumber(234567890);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Persisting the buddies entity objects
        em.persist(buddyInfo1);
        em.persist(buddyInfo2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo B");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddies\n----------------");

        for (BuddyInfo p : results) {
            System.out.println(p.getName() + " (id=" + p.getId() + ")");
        }

        // Closing connection
        em.close();
        emf.close();
    }
}