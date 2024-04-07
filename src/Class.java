package src;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Class {

    private ArrayList<Student> students = new ArrayList<Student>();
    String name = "";
    int period = 0;
    private SeatingChart seatingChart;


    public Class(String name, int period, ArrayList<Student> s) {
        this.name = name;
        this.period = period;
        students = s;
    }
    public void setSeatingChart(SeatingChart chart) {
        seatingChart = chart;
    }
    public String getName() {
        return name;
    }

    public int getPeriod() {
        return period;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public SeatingChart getSeatingChart() {
        return seatingChart;
    }



    public static Class createNewClass() {
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
        System.out.println("b) Import from a CSV file -- DO NOT USE -- NOT COMPLETE");
        System.out.println("q) Exit out");

        option = scan.nextLine();

        if (option.equals("a")) {

            System.out.print("How many students? ");
            int numOfStudents = scan.nextInt();
            scan.nextLine();

            System.out.println();
            System.out.println("Beginning to create students...");

            for (int i = 0; i < numOfStudents; i++) {


                System.out.print("Enter student " + (i + 1) + " first name: ");
                String first = scan.nextLine();

                System.out.print("Enter student " + (i + 1) + " last name: ");
                String last = scan.nextLine();

                System.out.print("Enter student " + (i + 1) + " student ID: ");
                int id = scan.nextInt();
                scan.nextLine();

                s.add(new Student(first, last, id));

            }
        } else if (option.equals("b")) {
            Scanner fileScan = new Scanner(System.in);
            System.out.println("Checking under \\src for a file called students.csv");
            System.out.println("The CSV file should have a First Name Column, Last Name Column, and Student ID Column.");
            System.out.println();
            File f = new File("src\\students.csv");
            try {
                fileScan = new Scanner(f);
                while (fileScan.hasNextLine()) {
                    String data = fileScan.nextLine();
                    String[] dataArr = data.split(",");

                    String first = dataArr[0];
                    String last = dataArr[1];
                    String id = dataArr[2];

                    s.add(new Student(first, last, Integer.parseInt(id)));
                }
                System.out.println(s);

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else if (option.equals("q")) {
            return null;
        }
        return new Class(n, p, s);
    }

    public static void viewClass(ArrayList<Class> classes) {
        System.out.println("List of all of your classes");
        for (Class c : classes) {
            System.out.println("--------");
            System.out.println("Class name: " + c.getName());
            System.out.println("Class period: " + c.getPeriod());
            System.out.println("List of students:");
            for (Student student : c.getStudents()) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getId());
            }
            System.out.println("Seating chart: ");
            if (c.getSeatingChart() != null) {

                c.getSeatingChart().printSeatingChart();
            } else {
                System.out.println("No seating chart");
            }

            System.out.println("--------");
        }
    }
}


