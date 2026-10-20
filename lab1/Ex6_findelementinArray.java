import java.util.Scanner;

public class Ex6_findelementinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n integer: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter x: ");
        int x = scanner.nextInt();

        int pos = -1;

        for (int i = 0; i <= arr.length - 1; i ++) {
            if (x == arr[i]) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println(pos);
        } else {
            System.out.println("First occurrence is: " + pos);
        }



        scanner.close();
    }
}
