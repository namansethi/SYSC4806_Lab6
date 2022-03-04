package Spring.MVC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class AddressBookController {

    private  AddressBook addressBook;
    private  AddressBookView addressBookView;

    public AddressBookController(AddressBook book, AddressBookView view) {
        this.addressBook = book;
        this.addressBookView = view;
    }


    public static void main(String[] args) {
        // Model
        AddressBook addressBook = new AddressBook();
        // View
        AddressBookView addressBookView = new AddressBookView();
        // Controller
        AddressBookController addressBookController = new AddressBookController(addressBook,addressBookView);

        addressBookController.init();

    }

    private void init() {

        launch();

        // Create Frame
        addressBookView.setjFrame(new JFrame("Dependency Injection"));
        addressBookView.getjFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addressBookView.getjFrame().setLocationRelativeTo(null);
        addressBookView.getjFrame().setSize(new Dimension(400, 400));
        addressBookView.getjFrame().setLayout(new GridLayout(0,1));
        // Create MVC.BuddyInfo String Array
        addressBook.addBuddy(new BuddyInfo("Bob",123456789));
        addressBook.addBuddy(new BuddyInfo("Larry",987654321));

        updateBuddyList(addressBook, addressBookView);

        addressBookView.getjFrame().add(addressBookView.getBuddyInfoList());

        // Create Name Field
        addressBookView.setNameField(new JTextField("Enter Name Here"));
        addressBookView.getjFrame().add(addressBookView.getNameField());

        // Create Number Field
        addressBookView.setNumberField(new JTextField("Enter Number Here"));
        addressBookView.getjFrame().add(addressBookView.getNumberField());

        // Add button
        addressBookView.setAddBuddyInfoButton(new JButton("Add"));
        addressBookView.getjFrame().add(addressBookView.getAddBuddyInfoButton());


        addressBookView.getAddBuddyInfoButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addressBook.addBuddy(new BuddyInfo(addressBookView.getNameField().getText(),Integer.parseInt(addressBookView.getNumberField().getText())));

                // Update list
                updateBuddyList(addressBook, addressBookView);


            }
        });


        addressBookView.getjFrame().setVisible(true);


    }

    private static void updateBuddyList(AddressBook addressBook, AddressBookView addressBookView) {
        String[] buddyInfoList = new String[10];
        Arrays.fill(buddyInfoList, "");
        for(int i = 0;i<addressBook.getBuddyListSize();i++){
            buddyInfoList[i] = addressBook.getBuddyList().get(i).getName() + ", " + addressBook.getBuddyList().get(i).getNumber();
        }
        addressBookView.getBuddyInfoList().setListData(buddyInfoList);
    }

    public void launch() {
        String[] contextPaths = new String[] {"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}
