// Exercise 6: Calculator - Method Overloading
import java.util.Scanner;

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public double max(double a, double b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter two integers (a b): ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Enter two decimal numbers (x y): ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        System.out.print("Enter three integers (p q r): ");
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();

        System.out.println("add(a, b) with int arguments      -> add(int, int): " + calc.add(a, b));
        System.out.println("add(x, y) with double arguments   -> add(double, double): " + calc.add(x, y));

        System.out.println("add(p, q, r) with three ints      -> add(int, int, int): " + calc.add(p, q, r));

        System.out.println("max(a, b) with int arguments      -> max(int, int): " + calc.max(a, b));

        System.out.println("max(x, y) with double arguments   -> max(double, double): " + calc.max(x, y));

        System.out.println("add(5, 2.5) mixed arguments       -> add(double, double): " + calc.add(5, 2.5));

        sc.close();

        /*
         * TESTS
         *
         * Test 1: add(int, int)
         *   calc.add(2, 3);                  // 5, add(int, int) chosen
         *
         * Test 2: add(double, double)
         *   calc.add(2.5, 1.5);              // 4.0, add(double, double) chosen
         *
         * Test 3: add(int, int, int)
         *   calc.add(1, 2, 3);               // 6, add(int, int, int) chosen
         *
         * Test 4: max with int and double
         *   calc.max(7, 9);                  // 9, max(int, int) chosen
         *   calc.max(7.5, 2.0);              // 7.5, max(double, double) chosen
         *
         * Test 5: mixed arguments
         *   calc.add(5, 2.5);                // 7.5, int 5 is widened to double
         *                                    // so add(double, double) is chosen
         */
    }
}