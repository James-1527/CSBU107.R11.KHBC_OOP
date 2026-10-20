
import java.util.ArrayList;
import java.util.Scanner;

class UITStudent {

    private String studentId;
    private String fullName;
    private String major;
    private double gpa;

    public UITStudent() {
        this("UNKNOWN", "Unknown");
    }

    public UITStudent(String studentId, String fullName) {
        this(studentId, fullName, "Undeclared", 0.0);
    }

    public UITStudent(String studentId, String fullName, String major, double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be in [0.0, 4.0]");
        }
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        this.gpa = gpa;
    }

    public boolean isPassed() {
        return gpa >= 2.0;
    }

    public String academicClassification() {
        if (gpa >= 3.6) return "Excellent";
        if (gpa >= 3.2) return "Very Good";
        if (gpa >= 2.5) return "Good";
        if (gpa >= 2.0) return "Average";
        return "Failed";
    }

    public void displayInfo() {
        System.out.println("ID: " + studentId
                + " | Name: " + fullName
                + " | Major: " + major
                + " | GPA: " + gpa
                + " | Passed: " + (isPassed() ? "Yes" : "No")
                + " | Classification: " + academicClassification());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<UITStudent> students = new ArrayList<>();

        System.out.print("How many students do you want to enter? ");
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 1; i <= n; i++) {
            System.out.println("\nStudent " + i);
            System.out.println("  1) No-argument constructor (default student)");
            System.out.println("  2) Constructor with ID and name");
            System.out.println("  3) Constructor with ID, name, major and GPA");
            System.out.print("  Choose constructor (1-3): ");
            int choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    students.add(new UITStudent());
                    break;
                case 2:
                    System.out.print("  Enter student ID: ");
                    String id2 = sc.nextLine().trim();
                    System.out.print("  Enter full name: ");
                    String name2 = sc.nextLine().trim();
                    students.add(new UITStudent(id2, name2));
                    break;
                case 3:
                    System.out.print("  Enter student ID: ");
                    String id3 = sc.nextLine().trim();
                    System.out.print("  Enter full name: ");
                    String name3 = sc.nextLine().trim();
                    System.out.print("  Enter major: ");
                    String major = sc.nextLine().trim();
                    System.out.print("  Enter GPA (0.0 - 4.0): ");
                    double gpa = Double.parseDouble(sc.nextLine().trim());
                    students.add(new UITStudent(id3, name3, major, gpa));
                    break;
                default:
                    System.out.println("  Invalid choice, student " + i + " skipped.");
                    break;
            }
        }

        System.out.println("\n===== All students =====");
        for (UITStudent s : students) {
            s.displayInfo();
        }

        sc.close();

        /*
         * TESTS
         *
         * Test 1: no-argument constructor
         *   new UITStudent().displayInfo();
         *   // ID: UNKNOWN | Name: Unknown | Major: Undeclared | GPA: 0.0 | Passed: No | Classification: Failed
         *
         * Test 2: ID + name constructor
         *   new UITStudent("20230001", "Nguyen Van A").displayInfo();
         *   // major is Undeclared, GPA 0.0
         *
         * Test 3: full constructor, several GPAs
         *   new UITStudent("20230002", "Tran Thi B", "IT", 3.7);   // Excellent
         *   new UITStudent("20230003", "Le Van C", "IT", 3.3);     // Very Good
         *   new UITStudent("20230004", "Pham D", "IT", 2.6);       // Good
         *   new UITStudent("20230005", "Hoang E", "IT", 2.0);      // Average, passed (boundary)
         *   new UITStudent("20230006", "Vu F", "IT", 1.9);         // Failed, not passed
         *
         * Test 4: invalid GPA -> IllegalArgumentException "GPA must be in [0.0, 4.0]"
         *   new UITStudent("20230007", "Bad G", "IT", 4.5);
         */
    }
}