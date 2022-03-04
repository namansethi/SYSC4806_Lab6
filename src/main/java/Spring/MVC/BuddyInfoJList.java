package Spring.MVC;

import javax.swing.*;
import java.util.Arrays;

public class BuddyInfoJList extends JList {

    private AddressBook addressBook;

    public void init(){
        String[] buddyInfoList = new String[10];
        Arrays.fill(buddyInfoList, "");
        for(int i = 0;i<addressBook.getBuddyList().size();i++){
            buddyInfoList[i] = addressBook.getBuddyList().get(i).getName() + ", " +addressBook.getBuddyList().get(i).getNumber();
        }

        this.setListData(buddyInfoList);

    }




    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }
}
