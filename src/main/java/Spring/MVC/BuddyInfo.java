package Spring.MVC;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id = null;

    private String name;
    private int number;

    public BuddyInfo(){
    }

    public BuddyInfo(String providedName,int providedNumber){
        this.name = providedName;
        this.number = providedNumber;

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void print() {

        System.out.println("MVC.BuddyInfo id=" + id + ", Name: " + name + ", number: " + number);
    }

}
