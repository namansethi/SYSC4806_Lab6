package Spring.MVC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBuddyActionListener implements ActionListener {

    private AddressBook book;
    private JTextField nameField;
    private JTextField numberField;
    private BuddyInfoJList buddyInfoJList;

    public BuddyInfoJList getBuddyInfoJList() {
        return buddyInfoJList;
    }

    public void setBuddyInfoJList(BuddyInfoJList buddyInfoJList) {
        this.buddyInfoJList = buddyInfoJList;
    }


    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getNumberField() {
        return numberField;
    }

    public void setNumberField(JTextField numberField) {
        this.numberField = numberField;
    }

    public AddressBook getBook() {
        return book;
    }

    public void setBook(AddressBook book) {
        this.book = book;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        book.addBuddy(new BuddyInfo(nameField.getText(),Integer.parseInt(numberField.getText())));
        buddyInfoJList.init();
    }
}
