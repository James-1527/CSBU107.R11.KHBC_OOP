import java.util.Scanner;


public class Ex3_Sum_Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        int n = scanner.nextInt();

        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum is: " + sum);

        scanner.close();
    }
}
