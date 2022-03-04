import Spring.MVC.AddressBook;
import Spring.MVC.BuddyInfo;
import org.junit.Test;
import org.junit.Assert;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.List;

public class AddressBookTest {

    AddressBook addressBook;

    @org.junit.Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
    }



    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test (expected = InvalidParameterException.class)
    public void addInvalidBuddy() {
        addressBook.addBuddy(null);
    }

    @Test
    public void addBuddy() {
        BuddyInfo buddy = new BuddyInfo("Bob",123456789);
        addressBook.addBuddy(buddy);
        Assert.assertEquals(addressBook.getBuddy(0),buddy);
        Assert.assertEquals(1,addressBook.getBuddyListSize());

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeInvalidBuddy() {
        addressBook.removeBuddy(0);
    }

    @Test
    public void removeBuddy() {
        BuddyInfo buddy = new BuddyInfo("Bob",123456789);
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(0);
        Assert.assertEquals(0,addressBook.getBuddyListSize());

    }

    @Test
    public void performJPA() {
        // Creating objects representing some buddyInfos
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1L);

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



        // Persisting the addressBook entity object
        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);

        em.persist(addressBook);

        tx.commit();

        // Check if address book 1 were persisted

        AddressBook addressBookFound = em.find(AddressBook.class, 1);
        if (addressBookFound != null) {
            addressBookFound.print();
        }

        // Check if buddies were persisted
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