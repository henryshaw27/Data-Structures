import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUI extends JFrame {
   //initializing all components used within the GUI
   ShoppingCart shoppingCart = new ShoppingCart();

   JTextField itemArea, quantityArea, priceArea;
   JTextField search;
   JCheckBox deliveryCheck;
   JButton addButton, removeButton, searchButton, calculatePrice;
   JLabel itemLabel, quantityLabel, priceLabel, searchLabel, finalPrice, searchStatement;
   int delivery_fee = 0;

   public GUI() {
      itemLabel = new JLabel("Enter Item:");
      itemArea = new JTextField(10);
      quantityLabel = new JLabel("Enter Quantity:");
      quantityArea = new JTextField(10);
      priceLabel = new JLabel("Enter Price:");
      priceArea = new JTextField(10);
      searchLabel = new JLabel("Search");
      search = new JTextField(10);
      searchButton = new JButton("Search");
      searchStatement = new JLabel("");
      deliveryCheck = new JCheckBox("Delivery for $10");
      finalPrice = new JLabel("");

      addButton = new JButton("Add Item");
      removeButton = new JButton("Remove Item");
      searchButton = new JButton("Search");
      calculatePrice = new JButton("Calculate Price");


      //Action listener to run add function when adding quantity, price, and item to the array
      addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            String itemName = itemArea.getText();
            int quantity = Integer.parseInt(quantityArea.getText());
            double price = Double.parseDouble(priceArea.getText());

            Item item = new Item(itemName, price);
            ItemOrder itemOrder = new ItemOrder(item, quantity);
            shoppingCart.addItem(itemOrder);
         }
      });

      //Same thing as add actions listener except it searches for an element in the array and removes it if it is present
      removeButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            String itemName = itemArea.getText();
            int quantity = Integer.parseInt(quantityArea.getText());
            double price = Double.parseDouble(priceArea.getText());

            Item item = new Item(itemName, price);
            ItemOrder itemOrder = new ItemOrder(item, quantity);

            ItemOrder existingItemOrder = shoppingCart.searchItem(itemName);
            if (existingItemOrder != null) {
               shoppingCart.removeItem(existingItemOrder);
            }
         }
      });

      //Prints item statement if it exists in the array and prints the item is not found if null
      searchButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            String itemName = search.getText();
            ItemOrder foundItem = shoppingCart.searchItem(itemName);

            if (foundItem != null) {
               searchStatement.setText("Item found: " + foundItem.getItem().getName());
            } else {
               searchStatement.setText("Item not found");
            }
         }
      });

      //Adds $10 to total if groceries are delivered
      deliveryCheck.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent itemEvent) {
            if (deliveryCheck.isSelected()){
               delivery_fee = 10;
            }
            else{
               delivery_fee = 0;
            }

         }
      });

      //Calculates total price with calculate total function and delivery fee
      calculatePrice.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            double total = shoppingCart.calculateTotal() + delivery_fee;
            finalPrice.setText("Total Price: " + total) ;
         }
      });

      //Creating panels and layout of the GUI

      JPanel finalPanel = new JPanel(new GridLayout(7, 1));
      JPanel itemPanel = new JPanel();
      itemPanel.add(itemLabel);
      itemPanel.add(itemArea);

      JPanel quantityPanel = new JPanel();
      quantityPanel.add(quantityLabel);
      quantityPanel.add(quantityArea);

      JPanel pricePanel = new JPanel();
      pricePanel.add(priceLabel);
      pricePanel.add(priceArea);

      JPanel searchPanel = new JPanel();
      searchPanel.add(searchLabel);
      searchPanel.add(search);
      searchPanel.add(searchButton);

      JPanel statementPanel = new JPanel(new GridLayout(2,1));
      statementPanel.add(searchStatement);
      statementPanel.add(finalPrice);

      JPanel buttonsPanel = new JPanel(new GridLayout(1, 3));
      buttonsPanel.add(addButton);
      buttonsPanel.add(removeButton);
      buttonsPanel.add(calculatePrice);

      JPanel deliveryPanel = new JPanel();
      deliveryPanel.add(deliveryCheck);



      finalPanel.add(itemPanel);
      finalPanel.add(quantityPanel);
      finalPanel.add(pricePanel);
      finalPanel.add(searchPanel);
      finalPanel.add(deliveryPanel);
      finalPanel.add(buttonsPanel);
      finalPanel.add(statementPanel);


      add(finalPanel);
   }

   public static void main(String[] args) {
      GUI gui = new GUI();
      gui.setSize(400, 400);
      gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gui.setVisible(true);
   }
}
