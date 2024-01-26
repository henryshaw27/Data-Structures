//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class MoneyConverter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("How much money would you like to count?");
        double initialDollars = sc.nextDouble();

        int dollars = (int)(initialDollars * 100);

        int twentyDollarBills = (dollars / 2000);
        int tenDollarBills = ((dollars % 2000) / 1000);
        int fiveDollarBills = (((dollars % 2000) % 1000) / 500);
        int oneDollarBills = ((((dollars % 2000) % 1000) % 500) / 100);

        int quarters = (((((dollars % 2000) % 1000) % 500) % 100) / 25);
        int dimes = ((((((dollars % 2000) % 1000) % 500) % 100) % 25) / 10);
        int nickels = (((((((dollars % 2000) % 1000) % 500) % 100) % 25) % 10) / 5);
        int pennies = (((((((dollars % 2000) % 1000) % 500) % 100) % 25) % 10) % 5);

        System.out.println(twentyDollarBills + " $20 bills, " + tenDollarBills + " $10 bills, " + fiveDollarBills + " $5 bills, " + oneDollarBills + " $1 bills, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + pennies + " pennies.");





    }

    
}