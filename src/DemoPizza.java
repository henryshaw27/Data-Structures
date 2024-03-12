import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DemoPizza extends JFrame {
    List<String> toppingsList;
    JTextField toppingField;
    JCheckBox deliveryCheckBox;
    JTextField addressField;

    public DemoPizza() {
        toppingsList = new ArrayList<>();

        //Creating labels and buttons for the user to enter toppings
        JLabel toppingLabel = new JLabel("Enter a topping:");
        toppingField = new JTextField(15);
        JButton addToppingButton = new JButton("Add Topping");


        //Creating items to get delivery information
        deliveryCheckBox = new JCheckBox("Would you like delivery?");
        JLabel addressLabel = new JLabel("Enter delivery address:");
        addressField = new JTextField(15);

        //Button to calculate final prices and display toppings
        JButton finishButton = new JButton("Finish Order");

        //setting the layout for the frame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //adding the contents to the frame
        add(toppingLabel);
        add(toppingField);
        add(addToppingButton);
        add(deliveryCheckBox);
        add(addressLabel);
        add(addressField);
        add(finishButton);

        //performs addTopping function
        addToppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTopping();
            }
        });
        //performs finishOrder function
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishOrder();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //pulls topping entered into text field, and clears the text field, and shows message saying topping was added
    private void addTopping() {
        String topping = toppingField.getText().trim();
        if (!topping.isEmpty()) {
            toppingsList.add(topping);
            toppingField.setText("");
            JOptionPane.showMessageDialog(this, "Topping added: " + topping);
        }
    }

    //adds toppings entered to topping array, adding the statements to the option pane, and catching the exception
    private void finishOrder() {
        String[] toppingsArray = toppingsList.toArray(new String[0]);
        String deliveryAddress = addressField.getText().trim();



        try {
            if (deliveryCheckBox.isSelected()) {
                // Create statement for a pizza with delivery
                DeliveryPizza deliveryPizza = new DeliveryPizza(toppingsArray, deliveryAddress, toppingsList.size());
                JOptionPane.showMessageDialog(this, "Order Summary: " + deliveryPizza);
            } else {
                // Create statement for a pizza without delivery
                Pizza pizza = new Pizza(toppingsArray, toppingsList.size());
                JOptionPane.showMessageDialog(this, "Order Summary: " + pizza);
            }
        //catching the exception
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        dispose(); // Close the GUI window after finishing the order
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoPizza();
            }
        });
    }
}
