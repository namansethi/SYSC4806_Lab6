package Spring;

import Spring.MVC.AddressBook;
import Spring.MVC.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
            AddressBook book1 = new AddressBook();
            book1.addBuddy(new BuddyInfo("Jack", 123));
            book1.addBuddy(new BuddyInfo("Bob", 234));

            AddressBook book2 = new AddressBook();
            book2.addBuddy(new BuddyInfo("Earl", 198));
            book2.addBuddy(new BuddyInfo("Howard", 987));

            repository.save(book1);
            repository.save(book2);



            // fetch all customers
            log.info("BuddyInfo found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addressBook : repository.findAll()) {
                for (BuddyInfo buddyInfo : addressBook.getBuddyList()) {
                    log.info(buddyInfo.toString());
                }
            }
            log.info("");

            // fetch an individual addressbook by ID
            AddressBook addressbook = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(addressbook.toString());
            log.info("");


            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
