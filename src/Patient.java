public class Patient {
    //declaring the variables used in the patient class
    int idNumber ,age;
    String bloodType, name;

    //default constructor declaring default values
    Patient(){
        idNumber = 0;
        age = 0;
        bloodType = BloodType.Group.OPlus();
        name = "John Doe";

    }


//overloaded constructor that takes in user input along with getters
    Patient(int idNumber, int age, String bloodType, String name){
        this.idNumber = idNumber;
        this.age = age;
        this.bloodType = bloodType;
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getAge() {
        return age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getName() {
        return name;
    }
}
