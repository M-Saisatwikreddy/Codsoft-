import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] marks = new double[5];
        String[] subjects = {"Physics", "Chemistry", "Biology", "Mathematics", "Computer"};


        System.out.println("Enter marks out of 100 for the following subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print(subjects[i] + ": ");
            marks[i] = scanner.nextDouble();
        }
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (totalMarks / 500) * 100;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else if (averagePercentage >= 50) {
            grade = "E";
        } else {
            grade = "F";
        }
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + "/500");
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}


