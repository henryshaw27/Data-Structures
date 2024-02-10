import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pizzaApplication extends JFrame{

    //Creating all variables, radio buttons, checkboxes, and buttons
    double toppings_price = 0;
    double base_price = 0;
    double extra_price = 0;
    double total_price = base_price + toppings_price + extra_price;

    byte count = 0;
    JLabel price;
    JFrame frame;
    JRadioButton small;
    JRadioButton medium;
    JRadioButton large;
    JRadioButton super_large;
    JCheckBox pepperoni;
    JCheckBox sausage;
    JCheckBox peppers;
    JCheckBox onions;
    JCheckBox extra_cheese;
    JCheckBox option_button;
    JButton final_price;
    public pizzaApplication() {

        //Creating JFrame
        frame = new JFrame();

        //Radio buttons for pizza sizes along with item listeners and if statements controlling the buttons
        small = new JRadioButton("Small: $5");
        small.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (small.isSelected()) {
                    base_price = 5;
                }
            }
        });
        medium = new JRadioButton("Medium: $10");
        medium.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
               if (medium.isSelected()){
                   base_price = 10;
               }
            }
        });
        large = new JRadioButton("Large: $15");
        large.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
               if (large.isSelected()){
                   base_price = 15;
               }
            }
        });
        super_large = new JRadioButton("Super: $20");
        super_large.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (super_large.isSelected()){
                    base_price = 20;
                }
            }
        });
        //Check boxes for toppings along with item listeners and if statements controlling the item listeners
        pepperoni = new JCheckBox("Pepperoni");
        pepperoni.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (pepperoni.isSelected()){
                    count += 1;
            }
                else{
                    count -= 1;
                }
        }
    });
        sausage = new JCheckBox("Sausage");
        sausage.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (sausage.isSelected()){
                    count += 1;
                }
                else{
                    count -= 1;
                }
            }
        });
        peppers = new JCheckBox("Peppers");
        peppers.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (peppers.isSelected()){
                    count += 1;
                }
                else{
                    count -= 1;
                }
            }
        });
        onions = new JCheckBox("Onions");
        onions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (onions.isSelected()){
                    count += 1;
                }
                else{
                    count -= 1;
                }
            }
        });
        extra_cheese = new JCheckBox("Extra Cheese");
        extra_cheese.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (extra_cheese.isSelected()){
                    count += 1;
                }
                else{
                    count -= 1;
                }
            }
        });
        option_button = new JCheckBox("Add $10 to order for rapid pickup");
        option_button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (option_button.isSelected()){
                    extra_price = 10;
                }
                else{
                    extra_price = 0;
                }
            }
        });


        //Final price statement
        price = new JLabel("Total Price is: $" + total_price);

        //Header for pizza application
        JLabel title = new JLabel("Pizza Shop");
        title.setFont(new Font("Arial", Font.BOLD, 36 ));

        //Header for size selection
        JLabel size_label = new JLabel("Choose a size:");
        size_label.setFont(new Font("Arial", Font.BOLD, 20));

        //Header for toppings
        JLabel toppings_label = new JLabel("Choose up to 3 toppings:");
        toppings_label.setFont(new Font("Arial", Font.BOLD, 16));



        //Creating the button to calculate the final price
        final_price = new JButton("Calculate Price");

        //Implementing if statements to control the calculation of the final price
        final_price.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (count > 3) {
                    price.setText("Too many toppings, MAX = 3");
                }
                if (count == 3){
                    toppings_price = 1.25;
                }
                else if (count == 2){
                    toppings_price = 1;
                }
                else if (count == 1){
                    toppings_price = 0.50;
                }
                else if (count == 0){
                    toppings_price = 0;
                }

                if (count < 3 && extra_cheese.isSelected()){
                    toppings_price -= 0.50;
                }
                else if (count == 3 && extra_cheese.isSelected()){
                    toppings_price -= 0.25;
                }

                if (count > 3) {
                    price.setText("Too many toppings, MAX = 3");
                }

                else {
                    total_price = toppings_price + base_price + extra_price;
                    price.setText("Total Price is: $" + total_price);
                }
            }
        });
        //Creating the panels for the size selection and toppings columns
        JPanel pizzas = new JPanel(new GridLayout(5, 1));
        JPanel toppings = new JPanel(new GridLayout(6,1));

        //Creating the panel for the button
        JPanel button = new JPanel(new GridLayout(1, 3));

        //Creating the panel for the header
        JPanel header = new JPanel();

        //Setting frame size and layout
        frame.setMinimumSize(new Dimension(800,400));
        frame.setLayout(new BorderLayout());

        //Putting radio buttons into a group so only one can be selected at a time
        ButtonGroup sizes = new ButtonGroup();

        //Adding header
        header.add(title);

        //Radio button group
        sizes.add(small);
        sizes.add(medium);
        sizes.add(large);
        sizes.add(super_large);

        //Adding header and radio buttons for size selection
        pizzas.add(size_label);
        pizzas.add(small);
        pizzas.add(medium);
        pizzas.add(large);
        pizzas.add(super_large);


        //Adding header and checkboxes for toppings
        toppings.add(toppings_label);
        toppings.add(pepperoni);
        toppings.add(sausage);
        toppings.add(peppers);
        toppings.add(onions);
        toppings.add(extra_cheese);

        //Adding button to calculate final price
        button.add(option_button);
        button.add(price);
        button.add(final_price);


        //Setting up and organizing layout of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BigY Pizza Application");
        frame.pack();
        frame.add(header, BorderLayout.NORTH);
        frame.add(pizzas, BorderLayout.WEST);
        frame.add(toppings, BorderLayout.EAST);
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);

    }
    //Running pizza application
    public static void main(String[] args){
        pizzaApplication pizza = new pizzaApplication();
    }



    }