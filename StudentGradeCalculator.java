import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        String[] names = new String[n];
        String[] courses = new String[n];
        double[][] camarks = new double[n][5];
        double[] midtermmarks = new double[n];
        double[] totalmarks = new double[n];
        double[] overallpercentage = new double[n];
        char[] grades = new char[n];

        // Input student details and marks
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            names[i] = scanner.next();
            System.out.print("Course: ");
            courses[i] = scanner.next();
            System.out.print("CA marks (out of 100) for 5 subjects (separated by spaces): ");
            for (int j = 0; j < 5; j++) {
                camarks[i][j] = scanner.nextDouble();
            }
            System.out.print("Midterm marks (out of 100): ");
            midtermmarks[i] = scanner.nextDouble();
        }

        // Calculate total marks, overall percentage and grades
        for (int i = 0; i < n; i++) {
            double caTotal = 0;
            for (int j = 0; j < 5; j++) {
                caTotal += camarks[i][j];
            }
            double caPercentage = (caTotal / 500.0) * 40.0; // 40% CA Weight-age
            double midtermPercentage = (midtermmarks[i] / 100.0) * 60.0; // 60% Mid Term Weight-age
            totalmarks[i] = caPercentage + midtermPercentage;
            overallpercentage[i] = totalmarks[i];
            if (overallpercentage[i] >= 80) {
                grades[i] = 'A';
            } else if (overallpercentage[i] >= 60) {
                grades[i] = 'B';
            } else if (overallpercentage[i] >= 40) {
                grades[i] = 'C';
            } else {
                grades[i] = 'D';
            }
        }

        // Display the result sheet in tabular format
        System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s%-15s%-10s\n", "Name", "Course", "CA1", "CA2", "CA3", "CA4",
                "Midterm", "Overall%");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s%-10s", names[i], courses[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10.2f", camarks[i][j]);
            }
            System.out.printf("%-15.2f%-10.2f%-3c\n", midtermmarks[i], overallpercentage[i], grades[i]);
        }
        scanner.close();
    }
}
