package Spring.MVC;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id = null;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyList;

    public AddressBook(){
        buddyList = new ArrayList<BuddyInfo>();
    }

    public void print() {

        System.out.println("Address Book");
        for (BuddyInfo buddy : buddyList) {
            buddy.print();
        }
    }

    public void addBuddy(BuddyInfo buddyInfo) {
        if(buddyInfo!=null){
            buddyList.add(buddyInfo);
        }else{
            throw new InvalidParameterException();

        }
    }

    public BuddyInfo getBuddy(int index) {
        if((index < buddyList.size()) && (index >=0)){
            return buddyList.get(index);
        }else{
            System.out.println("Buddy not found");
            throw new IndexOutOfBoundsException();
        }
    }

    public int getBuddyListSize() {
        return buddyList.size();
    }

    public void removeBuddy(int index) {
        if((index < buddyList.size()) && (index >=0)){
            buddyList.remove(index);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeBuddy(String name) {
        buddyList.removeIf(buddy -> Objects.equals(buddy.getName(), name));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }
}
