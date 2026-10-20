// Exercise 2: Fraction Class - State Validation and Object Operations
import java.util.Scanner;

class Fraction {

    // Attributes: private data, denominator must never be 0
    private int numerator;
    private int denominator;

    // No-argument constructor: represents 0/1
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Parameterized constructor: validates the denominator
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        // Keep the sign in the numerator
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Copy constructor: creates a new, distinct object with the same values
    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    // Helper: greatest common divisor
    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Returns a new simplified Fraction (this object is not changed)
    public Fraction simplify() {
        int g = gcd(numerator, denominator);
        return new Fraction(numerator / g, denominator / g);
    }

    // Returns a new Fraction: this + other
    public Fraction add(Fraction other) {
        int n = this.numerator * other.denominator + other.numerator * this.denominator;
        int d = this.denominator * other.denominator;
        return new Fraction(n, d).simplify();
    }

    // Returns a new Fraction: this - other
    public Fraction subtract(Fraction other) {
        int n = this.numerator * other.denominator - other.numerator * this.denominator;
        int d = this.denominator * other.denominator;
        return new Fraction(n, d).simplify();
    }

    // Returns a new Fraction: this * other
    public Fraction multiply(Fraction other) {
        int n = this.numerator * other.numerator;
        int d = this.denominator * other.denominator;
        return new Fraction(n, d).simplify();
    }

    // Returns a new Fraction: this / other
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by a fraction equal to 0");
        }
        int n = this.numerator * other.denominator;
        int d = this.denominator * other.numerator;
        return new Fraction(n, d).simplify();
    }

    // Returns true if both fractions have the same numerator and denominator
    public boolean equalsValue(Fraction other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    // Prints the fraction as numerator/denominator
    public void display() {
        System.out.println(numerator + "/" + denominator);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numerator of fraction 1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the denominator of fraction 1: ");
        int d1 = sc.nextInt();

        System.out.print("Enter the numerator of fraction 2: ");
        int n2 = sc.nextInt();
        System.out.print("Enter the denominator of fraction 2: ");
        int d2 = sc.nextInt();

        Fraction f1 = new Fraction(n1, d1);
        Fraction f2 = new Fraction(n2, d2);

        System.out.print("f1 = ");
        f1.display();
        System.out.print("f2 = ");
        f2.display();

        System.out.print("f1 + f2 = ");
        f1.add(f2).display();
        System.out.print("f1 - f2 = ");
        f1.subtract(f2).display();
        System.out.print("f1 * f2 = ");
        f1.multiply(f2).display();
        System.out.print("f1 / f2 = ");
        f1.divide(f2).display();

        System.out.print("Simplified f1 = ");
        f1.simplify().display();

        sc.close();

        /*
         * TESTS
         *
         * Test 1: f1 = 1/2, f2 = 3/4
         *   f1 + f2 -> 5/4
         *   f1 - f2 -> -1/4
         *   f1 * f2 -> 3/8
         *   f1 / f2 -> 2/3
         *   simplify(6/8) -> 3/4
         *
         * Test 2: denominator equal to 0 -> IllegalArgumentException "Denominator cannot be 0"
         *
         * Test 3: copy constructor
         *   Fraction f1 = new Fraction(1, 2);
         *   Fraction copy = new Fraction(f1);
         *   copy.display();                            // 1/2
         *   System.out.println(copy == f1);            // false: different objects
         *   System.out.println(copy.equalsValue(f1));  // true: same values
         */
    }
}