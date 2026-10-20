import java.util.Scanner;

public class Ex5_multiTable {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integer number: ");
        int n = scanner.nextInt();
        System.out.println("The multiplication Table is: ");
        for (int i = 1; i<= 10; i++) {
            int res = n * i;
            System.out.println(n+" * " + i + " = "+res );
        }
        scanner.close();
    }
}
