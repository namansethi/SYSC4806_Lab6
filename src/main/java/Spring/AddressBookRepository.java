package Spring;

import java.util.List;

import Spring.MVC.AddressBook;
import Spring.MVC.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    AddressBook findById(long id);
}