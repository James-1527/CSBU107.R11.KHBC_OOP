
import java.util.Random;
import java.util.Scanner;

class Dice {

    private int value;

    private static final Random random = new Random();

    public Dice() {
        this.value = 1;
    }

    public int roll() {
        this.value = random.nextInt(6) + 1;
        return this.value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many times do you want to roll the die? ");
        int n = sc.nextInt();

        Dice dice = new Dice();
        int[] counts = new int[7];

        for (int i = 0; i < n; i++) {
            int result = dice.roll();
            counts[result]++;
        }

        System.out.println("Last roll (object state): " + dice.getValue());
        System.out.println("Face | Count | Experimental probability");
        for (int face = 1; face <= 6; face++) {
            double probability = (double) counts[face] / n;
            System.out.printf("  %d  | %5d | %.4f%n", face, counts[face], probability);
        }

        sc.close();

        /*
         * TESTS
         *
         * Test 1: constructor sets the initial value to 1
         *   Dice d = new Dice();
         *   d.getValue();              // 1
         *
         * Test 2: roll() updates the state and returns the same value
         *   Dice d = new Dice();
         *   int r = d.roll();
         *   r == d.getValue();         // true, and 1 <= r <= 6
         *
         * Test 3: many rolls, each face should be near 1/6 (~0.1667)
         *   Enter n = 600000 in main(); every probability should be close to 0.1667.
         */
    }
}