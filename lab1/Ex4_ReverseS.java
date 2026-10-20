import java.util.Scanner;

public class Ex4_ReverseS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter string: ");
        String s = scanner.nextLine();

        String reverse = "";

        for (int i = s.length() - 1; i>=0;i--) {
            reverse += s.charAt(i);
        }

        System.out.println("Reverse string is: " + reverse);

        scanner.close();
    }
}
