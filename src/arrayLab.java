import java.util.Arrays;
import java.util.Scanner;
public class arrayLab{
    static double[] list = new double[20];
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < list.length; i++){
            System.out.println("Enter a number:");
            double number = scanner.nextDouble();
            list[i] = number;
        }
        System.out.println(Arrays.toString(list));
    }
}
