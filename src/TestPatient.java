import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient extends JFrame{
    //declaring patients along with the components of the GUI
    Patient patient1, patient2, patient3;
    JLabel patient1Label, patient2idNumLabel, patient2ageLabel, patient2BTLabel, patient2nameLabel, patient3idNumLabel, patient3ageLabel, patient3nameLabel, patient1Statement, patient2Statement, patient3Statement, title;
    JTextField patient2idNum, patient2age, patient2BT, patient2name, patient3idNum, patient3age, patient3name;
    JButton finalButton;

    public TestPatient(){
        //setting title for the GUI
        super("Blood Group Interface");
        //initializing all GUI components
        title = new JLabel("Blood Group Interface");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        patient1Label = new JLabel("Patient 1 has default values.");

        patient2idNumLabel = new JLabel("Enter Patient 2 ID Number:");
        patient2ageLabel = new JLabel("Enter Patient 2 Age");
        patient2BTLabel = new JLabel("Enter Patient 2 Blood Type");
        patient2nameLabel = new JLabel("Enter Patient Name");

        patient3idNumLabel = new JLabel("Enter Patient 3 ID Number");
        patient3ageLabel = new JLabel("Enter Patient 3 Age");
        patient3nameLabel = new JLabel("Enter Patient 3 Name");

        patient1Statement = new JLabel(" ");
        patient2Statement = new JLabel(" ");
        patient3Statement = new JLabel(" ");

        patient2idNum = new JTextField(10);
        patient2age = new JTextField(10);
        patient2BT = new JTextField(10);
        patient2name = new JTextField(10);

        patient3idNum = new JTextField(10);
        patient3age = new JTextField(10);
        patient3name = new JTextField(10);

        finalButton = new JButton("Display Patient Data");

        //action listener for when button is pressed
        finalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //declaring default values for patient 1
                patient1 = new Patient();

                //declaring user input values for patient 2
                int pat2id = Integer.parseInt(patient2idNum.getText());
                int pat2age = Integer.parseInt(patient2age.getText());
                String patient2BloodType = patient2BT.getText();
                String pat2name = patient2name.getText();
                String pat2BT = " ";
                //switch function to declare the users blood type and give an invalid statement if a blood type isn't entered
                switch(patient2BloodType) {
                    case "A+":
                        pat2BT = BloodType.Group.APlus();
                        break;
                    case "A-":
                        pat2BT = BloodType.Group.ANeg();
                        break;
                    case "B+":
                        pat2BT = BloodType.Group.BPlus();
                        break;
                    case "B-":
                        pat2BT = BloodType.Group.BNeg();
                        break;
                    case "AB+":
                        pat2BT = BloodType.Group.ABPlus();
                        break;
                    case "AB-":
                        pat2BT = BloodType.Group.ABNeg();
                        break;
                    case "O+":
                        pat2BT = BloodType.Group.OPlus();
                        break;
                    case "O-":
                        pat2BT = BloodType.Group.ONeg();
                        break;
                    default:
                        pat2BT = "Entered invalid blood type.";
                }

                //patient 2 with user values
                patient2 = new Patient(pat2id, pat2age, pat2BT, pat2name);

                //declaring user values for patient 3 along with the default blood type
                int pat3id = Integer.parseInt(patient3idNum.getText());
                int pat3age = Integer.parseInt(patient3age.getText());
                String pat3BT = BloodType.Group.OPlus();
                String pat3name = patient3name.getText();

                //patient 3 with user values and default blood type
                patient3 = new Patient(pat3id, pat3age, pat3BT, pat3name);

                //output statements for the patients
                patient1Statement.setText("Patient 1 ID Number: " + patient1.getIdNumber() + ", Name: " + patient1.getName() + ", Age: " + patient1.getAge() + ", Blood Type: " + patient1.getBloodType());
                patient2Statement.setText("Patient 2 ID Number: " + patient2.getIdNumber() + ", Name: " + patient2.getName() + ", Age: " + patient2.getAge() + ", Blood Type: " + patient2.getBloodType());
                patient3Statement.setText("Patient 3 ID Number: " + patient3.getIdNumber() + ", Name: " + patient3.getName() + ", Age: " + patient3.getAge() + ", Blood Type: " + patient3.getBloodType());
            }

        });

        //organization and setup of the GUI
        JPanel finalPanel = new JPanel(new GridLayout(5,1));

        JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        JPanel patient1Panel = new JPanel();
        patient1Panel.add(patient1Label);

        JPanel patient2Panel = new JPanel(new GridLayout(2,4));
        patient2Panel.add(patient2idNumLabel);
        patient2Panel.add(patient2nameLabel);
        patient2Panel.add(patient2ageLabel);
        patient2Panel.add(patient2BTLabel);
        patient2Panel.add(patient2idNum);
        patient2Panel.add(patient2name);
        patient2Panel.add(patient2age);
        patient2Panel.add(patient2BT);


        JPanel patient3Panel = new JPanel(new GridLayout(2,3));
        patient3Panel.add(patient3idNumLabel);
        patient3Panel.add(patient3nameLabel);
        patient3Panel.add(patient3ageLabel);
        patient3Panel.add(patient3idNum);
        patient3Panel.add(patient3name);
        patient3Panel.add(patient3age);


        JPanel statementPanel = new JPanel(new GridLayout(4,1));
        statementPanel.add(patient1Statement);
        statementPanel.add(patient2Statement);
        statementPanel.add(patient3Statement);
        statementPanel.add(finalButton);

        finalPanel.add(titlePanel);
        finalPanel.add(patient1Panel);
        finalPanel.add(patient2Panel);
        finalPanel.add(patient3Panel);
        finalPanel.add(statementPanel);

        add(finalPanel);

    }
        //print the GUI
    public static void main(String[] args) {
        TestPatient testPatient = new TestPatient();
        testPatient.setSize(800, 500);
        testPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testPatient.setVisible(true);
    }
}




