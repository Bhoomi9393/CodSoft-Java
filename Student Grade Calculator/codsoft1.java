import java.util.InputMismatchException;
import java.util.Scanner;

public class codsoft1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfSubjects = 0;

        while (true) {
            try {
                System.out.print("Enter number of subjects: ");
                numberOfSubjects = sc.nextInt();
                if (numberOfSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than zero.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); 
            }
        }

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks out of 100 for subject " + (i + 1) + ": ");
                    int inputMark = sc.nextInt();
                    if (inputMark < 0 || inputMark > 100) {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                    } else {
                        marks[i] = inputMark;
                        totalMarks += inputMark;
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    sc.next(); 
                }
            }
        }

        double average = (double) totalMarks / numberOfSubjects;

        String grade;
        String remark;

        if (average >= 90) {
            grade = "O";
            remark = "Outstanding";
        } else if (average >= 80) {
            grade = "A";
            remark = "Excellent";
        } else if (average >= 70) {
            grade = "B";
            remark = "Very Good";
        } else if (average >= 60) {
            grade = "C";
            remark = "Good";
        } else if (average >= 50) {
            grade = "D";
            remark = "Fair";
        } else if (average >= 40) {
            grade = "E";
            remark = "Pass";
        } else {
            grade = "Fail";
            remark = "Needs Improvement";
        }

        System.out.println("\n--- Marksheet ---");
        System.out.println("Total Marks: " + totalMarks + " / " + (numberOfSubjects * 100));
        System.out.println("Average Marks: " + String.format("%.2f", average) + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remark);

        sc.close();
    }
}
