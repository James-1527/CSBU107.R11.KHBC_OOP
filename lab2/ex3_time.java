
import java.util.Scanner;

class Time {

    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be in [0, 23]");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be in [0, 59]");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be in [0, 59]");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    private int toSeconds() {
        return hour * 3600 + minute * 60 + second;
    }

    private void fromSeconds(int totalSeconds) {
        int t = Math.floorMod(totalSeconds, 86400);
        this.hour = t / 3600;
        this.minute = (t % 3600) / 60;
        this.second = t % 60;
    }

    public void addSeconds(int seconds) {
        fromSeconds(toSeconds() + seconds);
    }

    public void subtractSeconds(int seconds) {
        fromSeconds(toSeconds() - seconds);
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hour (0-23): ");
        int h = sc.nextInt();
        System.out.print("Enter minute (0-59): ");
        int m = sc.nextInt();
        System.out.print("Enter second (0-59): ");
        int s = sc.nextInt();

        Time time = new Time(h, m, s);
        System.out.print("Current time: ");
        time.display();

        System.out.print("Enter number of seconds to add: ");
        int add = sc.nextInt();
        time.addSeconds(add);
        System.out.print("After adding " + add + " seconds: ");
        time.display();

        System.out.print("Enter number of seconds to subtract: ");
        int sub = sc.nextInt();
        time.subtractSeconds(sub);
        System.out.print("After subtracting " + sub + " seconds: ");
        time.display();

        sc.close();

        /*
         * TESTS
         *
         * Test 1: 23:59:50 + 20 seconds -> 00:00:10 (wraps past midnight)
         *   Time t = new Time(23, 59, 50);
         *   t.addSeconds(20);
         *   t.display();                 // 00:00:10
         *
         * Test 2: 00:00:10 - 20 seconds -> 23:59:50 (wraps backward)
         *   Time t = new Time(0, 0, 10);
         *   t.subtractSeconds(20);
         *   t.display();                 // 23:59:50
         *
         * Test 3: invalid values -> IllegalArgumentException
         *   new Time(24, 0, 0);          // "Hour must be in [0, 23]"
         *   new Time(12, 60, 0);         // "Minute must be in [0, 59]"
         *   new Time(12, 30, 60);        // "Second must be in [0, 59]"
         *
         * Test 4: no-argument constructor
         *   new Time().display();        // 00:00:00
         */
    }
}