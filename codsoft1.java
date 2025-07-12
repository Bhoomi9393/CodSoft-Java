import java.util.Scanner;

public class codsoft1 
{
    public static void main(String[]args)
    {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter number of Subjects: ");
        int n = Sc.nextInt();

        int marks[] = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++)
        {
            while (true) 
            {
                System.out.println("Enter marks out of 100 for subject " + (i+1) + " :");
                marks[i] = Sc.nextInt();
                if (marks[i] >= 0 && marks[i] <= 100) 
                {
                    total += marks[i];
                    break;
                }
                else
                {
                    System.out.println("Invalid marks! Must be between 0 and 100.");
                }
            }
        }

        double avg = (double)total/n;
        String grade;

        if(avg >= 90)
        {
            grade = "O";
        }
        else if(avg >= 80)
        {
            grade = "A";
        }
        else if(avg >= 70)
        {
            grade = "B";
        }
        else if(avg >= 60)
        {
            grade = "C";
        }
        else if(avg >= 50)
        {
            grade = "D";
        }
        else if(avg >= 40)
        {
            grade = "E";
        }
        else
        {
            grade = "Fail";
        }
        System.out.println("...Result...");
        System.out.println("Total Marks: " + total + "/" + (n * 100));
        System.out.println("Average Marks: " + String.format("%.2f",avg) + "%");
        System.out.println("Grade: " + grade);

        Sc.close();
    }
}
