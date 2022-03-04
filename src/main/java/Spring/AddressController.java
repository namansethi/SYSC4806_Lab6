
package Spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import Spring.MVC.AddressBook;
import Spring.MVC.BuddyInfo;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/addressbook")
    public String getAddressBooks() {

        String ret = "<H1>List of Address Books</H1>";

        ret += "<table border=1> <tr> <th>id</th></tr>";
        for (AddressBook addressBook : addressBookRepository.findAll()) {
            ret += "<tr>";
            ret +=  "<td><a href = \"/addressbook/" + addressBook.getId() + "\">" + addressBook.getId() + "</a> </td>";
        }
        ret += "</table>";

        ret += "<p>Select an id to view the buddy info inside.</p>";

        return ret;
    }

    @GetMapping("/addressbook/{id}")
    public String getAddressBook(@PathVariable(value = "id") Long id) {

        Optional<AddressBook> addressBook = addressBookRepository.findById(id);


        String ret = "<H1>List of Address Books</H1>";

        ret += "<table border=1> <tr> <th>ID</th><th>Name</th><th>Number</th></tr>";

        if(addressBook.isPresent()){
            for (BuddyInfo buddyInfo : addressBook.get().getBuddyList()) {
                ret += "<tr>";
                ret +=  "<td>" +buddyInfo.getId() + "</td>";
                ret +=  "<td>" +buddyInfo.getName() + "</td>";
                ret +=  "<td>" +buddyInfo.getNumber() + "</td>";
                ret +=  "</tr>";
            }
        }else{
            throw new NullPointerException();
        }

        ret += "</table>";

        return ret;
    }

    @PostMapping("/addressbook")
    public AddressBook addAddressBook(@RequestBody AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    @PostMapping("/addressbook/{id}")
    public AddressBook addBuddy(@PathVariable(value = "id") Long id, @RequestBody BuddyInfo buddyInfo) {
        Optional<AddressBook> addressbook = addressBookRepository.findById(id);
        if(addressbook.isPresent()){
            addressbook.get().addBuddy(buddyInfo);
            return addressBookRepository.save(addressbook.get());
        }else{
            throw new NullPointerException();
        }
    }

    @DeleteMapping("/addressbook/{id}")
    public AddressBook removeBuddy(@PathVariable(value = "id") Long id, @RequestBody BuddyInfo buddyInfo) {
        Optional<AddressBook> addressbook = addressBookRepository.findById(id);
        if(addressbook.isPresent()){
            addressbook.get().removeBuddy(buddyInfo.getName());
            return addressBookRepository.save(addressbook.get());
        }else{
            throw new NullPointerException();
        }
    }

}
