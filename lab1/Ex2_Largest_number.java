import java.util.Scanner;

public class Ex2_Largest_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter number 2: ");
        int num2 = scanner.nextInt();

        System.out.println("Enter number 3: ");
        int num3 = scanner.nextInt();

        int max = num1;

        if (num1 > num2) {
            if (num1 > num3) {
                max = num1;
            } else {
                max = num3;
            }
        } else {
            if(num2 > num3) {
                max = num2;
            } else{
                max = num3;
            }
        }



        System.out.println("Largest number is: " + max);
        scanner.close();
    }
}