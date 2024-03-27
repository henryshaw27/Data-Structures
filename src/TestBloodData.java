import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestBloodData extends JFrame{

    //Declaring components of the GUI
    JLabel bloodTypeLabel, blood1Label, default1Label, blood2Label, default2Label;
    JTextField bloodText;
    JButton showStatement;

    public TestBloodData(){
        //Creating labels and text fields to acquire blood type
        bloodTypeLabel = new JLabel("Enter your blood type:");
        bloodText = new JTextField(10);
        blood1Label = new JLabel(" ");
        default1Label = new JLabel(" ");
        blood2Label = new JLabel(" ");
        default2Label = new JLabel(" ");
        showStatement = new JButton("Show Blood Group");

        //action listener for when button is pressed
        showStatement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Setting default blood type
                String Default = BloodType.Group.OPlus();
                //Setting the text from the text field to a string for the switch function
                String bloodType = bloodText.getText();
                //switch function that takes in the users blood type, prints the default, then sets the users as the default and reprints
                switch(bloodType){
                    case "A+":
                        blood1Label.setText("My Blood group is " + BloodType.Group.APlus());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.APlus();
                        blood2Label.setText("My Blood group is " + BloodType.Group.APlus());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "A-":
                        blood1Label.setText("My Blood group is " + BloodType.Group.ANeg());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.ANeg();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.ANeg());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "B+":
                        blood1Label.setText("My Blood group is " + BloodType.Group.BPlus());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.BPlus();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.BPlus());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "B-":
                        blood1Label.setText("My Blood group is " + BloodType.Group.BNeg());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.BNeg();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.BNeg());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "AB+":
                        blood1Label.setText("My Blood Group is " + BloodType.Group.ABPlus());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.ABPlus();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.ABPlus());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "AB-":
                        blood1Label.setText("My Blood Group is " + BloodType.Group.ABNeg());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.ABNeg();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.ABNeg());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "O+":
                        blood1Label.setText("My Blood Group is " + BloodType.Group.OPlus());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.OPlus();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.OPlus());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    case "O-":
                        blood1Label.setText("My Blood Group is " + BloodType.Group.ONeg());
                        default1Label.setText("Default Blood Group is: " + Default);
                        Default = BloodType.Group.ONeg();
                        blood2Label.setText("My Blood Group is " + BloodType.Group.ONeg());
                        default2Label.setText("Default Blood Group is: " + Default);
                        break;
                    //shows invalid type if a blood type isn't entered
                    default:
                        blood1Label.setText("Invalid Type ");
                        default1Label.setText(" ");
                        blood2Label.setText(" ");
                        default2Label.setText(" ");

                }

            }
        });

        //organizing the setup of the GUI
        JPanel finalPanel = new JPanel(new GridLayout(2,1));

        JPanel textPanel = new JPanel(new GridLayout(2,1));
        textPanel.add(bloodTypeLabel);
        textPanel.add(bloodText);


        JPanel statementPanel = new JPanel(new GridLayout(5,1));
        statementPanel.add(blood1Label);
        statementPanel.add(default1Label);
        statementPanel.add(blood2Label);
        statementPanel.add(default2Label);
        statementPanel.add(showStatement);


        finalPanel.add(textPanel);
        finalPanel.add(statementPanel);

        add(finalPanel);

    }
    //print the GUI
    public static void main(String[] args) {
        TestBloodData testBloodData = new TestBloodData();
        testBloodData.setSize(400, 400);
        testBloodData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testBloodData.setVisible(true);
    }
}