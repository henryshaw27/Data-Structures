import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class UseDinnerParty extends JFrame {
    //Creating all GUI buttons and labels and initializing Party and DinnerParty
    Party party = new Party();
    DinnerParty dinnerParty = new DinnerParty();
    JLabel guest_statement;
    JLabel get_count;
    JLabel option_header;
    JLabel option_statement;
    JLabel drink_header;
    JLabel drink_statement;
    JLabel final_statement;
    JFrame frame;
    JTextField guest_count;
    JRadioButton option_1;
    JRadioButton option_2;
    JRadioButton drink_option1;
    JRadioButton drink_option2;
    JButton end;

    public UseDinnerParty() {
        //Creating frame
        frame = new JFrame();
       //Creating dinner option buttons and setting values to them when clicked
        option_1 = new JRadioButton("Option 1: Steak");
        option_1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (option_1.isSelected()) {
                    dinnerParty.setDinnerChoice(1);
                }
            }
        });
        option_2 = new JRadioButton("Option 2: Chicken");
        option_2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (option_2.isSelected()) {
                    dinnerParty.setDinnerChoice(2);
                }
            }
        });
        //Creating buttons for drink options and setting values to them when clicked
        drink_option1 = new JRadioButton("Option 1: Wine");
        drink_option1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (drink_option1.isSelected()){
                    dinnerParty.setDrinkChoice(1);
                }
            }
        });
        drink_option2 = new JRadioButton("Option 2: Water");
        drink_option2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (drink_option2.isSelected()){
                    dinnerParty.setDrinkChoice(2);
                }
            }
        });
        //Creating all labels
        get_count = new JLabel("How many guests will be attending?");
        option_header = new JLabel("Choose an option to have for dinner:");
        drink_header = new JLabel("Choose an option to have for drinks:");
        guest_count = new JTextField();
       //Creating button to create the invitation
        end = new JButton("Create Invitation");
       //Statements that show when the invitation is created
        guest_statement = new JLabel("There will be     guests");
        option_statement = new JLabel("");
        drink_statement = new JLabel("");
        party.setDisplayInvitation("Please come to my party!");
        final_statement = new JLabel(party.getDisplayInvitation());

        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              //Pulling the number of guests from the text field and adding to the invitation statement
               String guest = guest_count.getText();
               guest_statement.setText("There will be " + guest + " guests");
              //Determining which option and drink statements will be shown based on the value assigned to them earlier
               if(dinnerParty.dinnerChoice == 1){
                   option_statement.setText("Steak will be served");
               }
                if(dinnerParty.dinnerChoice == 2){
                    option_statement.setText("Chicken will be served");
                }
                if(dinnerParty.drinkChoice == 1){
                    drink_statement.setText("Wine will be served");
                }
                if(dinnerParty.drinkChoice == 2){
                    drink_statement.setText("Water will be served");
                }
            }

        });

        //creating panels and layouts for the questions and statements
        JPanel text = new JPanel(new GridLayout(2, 1));
        JPanel buttons = new JPanel(new GridLayout(6, 1));
        JPanel statements = new JPanel(new GridLayout(5, 1));

       //setting the frame
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setLayout(new BorderLayout());

        //creating button groups for the radio buttons
        ButtonGroup options = new ButtonGroup();
        ButtonGroup drinks = new ButtonGroup();

        //creating panel for the guest count
        text.add(get_count);
        text.add(guest_count);

        //adding buttons to respective button groups
        options.add(option_1);
        options.add(option_2);
        drinks.add(drink_option1);
        drinks.add(drink_option2);

        //panel for dinner and drink options
        buttons.add(option_header);
        buttons.add(option_1);
        buttons.add(option_2);
        buttons.add(drink_header);
        buttons.add(drink_option1);
        buttons.add(drink_option2);

        //panel for the invitation statements
        statements.add(end);
        statements.add(guest_statement);
        statements.add(option_statement);
        statements.add(drink_statement);
        statements.add(final_statement);

        //formatting the layout
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Dinner Party Invitation");
        frame.pack();
        frame.add(text, BorderLayout.WEST);
        frame.add(buttons, BorderLayout.EAST);
        frame.add(statements, BorderLayout.SOUTH);
        frame.setVisible(true);


    }
    //running the GUI
    public static void main(String[] args){ UseDinnerParty dinner = new UseDinnerParty();
    }
    }