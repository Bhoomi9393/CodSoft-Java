import java.util.*;
import java.io.*;

class Student implements Serializable
{
    private static final long serialVersionUID = 1L;
    String name;
    int roll;
    String grade;
    String course;
    int phone;

    public Student(String name, int roll, String grade, String course, int phone)
    {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
        this.course = course;
        this.phone = phone;
    }
    public int rollNo()
    {
        return roll;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }
    public void setPhone(int phone)
    {
        this.phone = phone;
    }
    public String toString()
    {
        return "Name: " + name + ", Roll no: " + roll + ", Grade: " + grade + ", Course: " + course + ", Phone: " + phone;
    }
}
public class StudentManagementSystem
{
    private static List<Student> students = new ArrayList<>();
    private static final String File_Name = "Student.Database";

    public static void main(String[] args) 
    {
        loadData();
        Scanner Sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\n--------- Student Management System ---------\n");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("\n Enter your choice:");
            while(!Sc.hasNextInt())
            {
                System.out.println("Enter a valid number");
                Sc.next();
            }
            choice = Sc.nextInt();
            Sc.nextLine();

            switch(choice)
            {
                case 1 -> add(Sc);
                case 2 -> remove(Sc); 
                case 3 -> search(Sc); 
                case 4 -> display(); 
                case 5 -> save();
                default -> System.out.println("Invalid Choice!"); 
            }
        }
        while (choice != 5);
    }
    private static void add(Scanner Sc)
    {
        System.out.println("Enter name:");
        String name = Sc.nextLine().trim();
        System.out.println("Enter Roll No.:");
        int roll = getIntInput(Sc);
        System.out.println("Enter Grade:");
        String grade = Sc.nextLine().trim();
        System.out.println("Enter Course:");
        String course = Sc.nextLine().trim();
        System.out.println("Enter Phone Number:");
        int phone = getIntInput(Sc);

        if (name.isEmpty() || grade.isEmpty() || course.isEmpty())
        {
            System.out.println("Fields cannot be Empty");
            return;
        }
        students.add(new Student(name, roll, grade, course, phone));
        System.out.println("Student added");
    }
    private static void remove(Scanner Sc)
    {
        System.out.println("Enter Roll number to remove:");
        int roll = getIntInput(Sc);
        boolean found = false;

        Iterator<Student> it = students.iterator();
        while(it.hasNext())
        {
            if(it.next().rollNo() == roll)
            {
                it.remove();
                System.out.println("Student Removed");
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Student not found");
        }
    }
    private static void search(Scanner Sc)
    {
        System.out.println("Enter Roll Number to Search:");
        int roll = getIntInput(Sc);

        for(Student a : students)
        {
            if(a.rollNo() == roll )
            {
                System.out.println("Found " + a);
                return;
            }
        }
        System.out.println("Student not found!");
    }
    private static void display()
    {
        if(students.isEmpty())
        {
            System.out.println("No Student to Display");
            return;
        }
        for (Student a : students)
        {
            System.out.println(a);
        }
    }
    private static void save()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_Name)))
        {
            oos.writeObject(students);
            System.out.println("Data Saved.");
        }
        catch (IOException e) 
        {
            System.out.println("Error in saving Data!");
        }
    }
    private static int getIntInput(Scanner Sc)
    {
        while (!Sc.hasNextInt())
        {
            System.out.println("Enter valid number!");
            Sc.next();
        }
        int num = Sc.nextInt();
        Sc.nextLine(); 
        return num;

    }
    private static void loadData()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(File_Name)))
        {
            students = (List<Student>) ois.readObject();
        }
        catch(Exception e)
        {
            students = new ArrayList<>();
        }
    }
}
