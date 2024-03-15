package src;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Class {

    private ArrayList<Student> students = new ArrayList<Student>();
    String name = "";
    int period = 0;

    public Class(String name, int period, ArrayList<Student> s) {
        this.name = name;
        this.period = period;
        students = s;
    }







    public static void createNewClass(Teacher t) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> s = new ArrayList<>();

        System.out.print("What's the name of your class? ");
        String n = scan.nextLine();

        System.out.print("What period? ");
        int p = scan.nextInt();
        scan.nextLine();

        String option;

        System.out.println();
        System.out.println("How would you like to create new students?");
        System.out.println("a) Manually create class");
        System.out.println("b) Import from a CSV file");
        System.out.println("q) Exit out");

        option = scan.nextLine();

        if (option.equals("a")) {

            System.out.print("How many students? ");
            int numOfStudents = scan.nextInt();

            System.out.println();
            System.out.println("Beginning to create students...");

            for (int i = 0; i < numOfStudents; i++) {


                System.out.print("Enter student " + (i + 1) + " first name: ");
                String first = scan.nextLine();

                System.out.print("Enter student " + (i + 1) + " last name: ");
                String last = scan.nextLine();

                System.out.print("Enter student " + (i + 1) + " student ID: ");
                int id = scan.nextInt();

                s.add(new Student(first, last, id));
            }

        } else if (option.equals("b")) {

        }

        Class newClass = new Class(n, p, s);
        t.addNewClass(newClass);


    }


}
