package Spring.MVC;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AddressBookView extends JFrame {
    private JButton addBuddyInfoButton;
    private JList buddyInfoList;
    private JTextField nameField;
    private JTextField numberField;
    private JFrame jFrame;
    private List panelComponents;

    public List getPanelComponents() {
        return panelComponents;
    }

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(400, 400));
        setLayout(new GridLayout(0,1));
        setVisible(true);

        for (Iterator iter = panelComponents.iterator();
             iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }




    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JButton getAddBuddyInfoButton() {
        return addBuddyInfoButton;
    }

    public void setAddBuddyInfoButton(JButton addBuddyInfoButton) {
        this.addBuddyInfoButton = addBuddyInfoButton;
    }

    public JList getBuddyInfoList() {
        return buddyInfoList;
    }

    public void setBuddyInfoList(JList buddyInfoList) {
        this.buddyInfoList = buddyInfoList;
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
}
