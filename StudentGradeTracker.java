import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

       
        double[][] grades = new double[numStudents][numSubjects];

        
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter the grade for student in point value" + (i + 1) + ", subject " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < numStudents; i++) {
            double total = 0;
            for (int j = 0; j < numSubjects; j++) {
                total += grades[i][j];
            }
            double average = total / numSubjects;
            System.out.println("Average grade for student " + (i + 1) + ": " + average);
        }

        scanner.close();
    }
}
