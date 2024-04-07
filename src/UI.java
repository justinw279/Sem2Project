package src;
import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Scanner;

public class UI {

    int students;
    Scanner scan;
    String className;
    ArrayList<Class> classes = new ArrayList<>();

    public UI() {
        students = 0;
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Gradebook:");
        menu();
    }

    public void menu() {
        String option = "";
        while (!option.equals("q")) {
            System.out.println("a) Create new class");
            System.out.println("b) View class");
            System.out.println("c) Modify class");
            System.out.println("d) Delete class");
            System.out.println("e) Create assignment");
            System.out.println("f) Create seating chart for a class");
            System.out.println("q) Quit");
            System.out.print("Enter an option: ");
            option = scan.nextLine();
            switch (option) {
                case "a":
                    Class toAdd = Class.createNewClass();
                    if (toAdd != null) {
                        classes.add(toAdd);
                    }
                    break;
                case "b":
                    Class.viewClass(classes);
                    break;
                case "c":
                    System.out.println("in progress");
                    break;
                case "d":
                    System.out.println("in progress");
                    break;
                case "e":
                    Scanner s = new Scanner(System.in);

                    System.out.println("Name the assignment.");
                    String name = s.nextLine();

                    System.out.println("Major or minor assessment? (major/minor)");
                    String majorOrMinor = s.nextLine();

                    System.out.println("Which period?");

                    for (Class c: classes) {
                        System.out.println(STR."\{c.getName()} \{c.getPeriod()}");
                    }

                    int pd = s.nextInt();
                    System.out.println("PERIOD: " + pd);
                    s.nextLine();

                    if (majorOrMinor.equals("major")) {

                        System.out.print("Eligible for corrections? (y/n): ");
                        String tcE = s.nextLine();
                        boolean eligible = false;

                        if (tcE.equals("y")) {
                            eligible = true;
                        } else if (tcE.equals("n")){
                            eligible = false;
                        }

                        for (Class c : classes) {
                            if (c.getPeriod() == pd) {
                                for (Student stu : c.getStudents()) {
                                    System.out.print(stu.getFirstName() + " " + stu.getLastName() + " " + stu.getId() + " grade for assignment (0-100): ");
                                    double grade = scan.nextDouble();
                                    MajorAssignment assignment = new MajorAssignment(name, grade, eligible);
                                    assignment.addAssignment(stu, assignment);
                                }
                            }
                        }
                    } else if (majorOrMinor.equals("minor")) {
                        Scanner iHateScanner = new Scanner(System.in);
                        System.out.print("Graded based on completion? (y/n): ");
                        String cE = iHateScanner.nextLine();
                        boolean completion = false;

                        if (cE.equals("y")) {
                            completion = true;
                        } else if (cE.equals("n")){
                            completion = false;
                        }

                        for (Class c : classes) {
                            if (c.getPeriod() == pd) {

                                for (Student stu : c.getStudents()) {
                                    System.out.print(stu.getFirstName() + " " + stu.getLastName() + " " + stu.getId() + " grade for assignment (0-100): ");
                                    double grade = scan.nextDouble();
                                    MinorAssignment assignment = new MinorAssignment(name, grade, completion);
                                    assignment.addAssignment(stu, assignment);
                                }
                            }
                        }
                    }
                    break;
                case "g":
                    System.out.println("in progress");
                    break;
                case "f":
                    System.out.println("Which class would you like to create a seating chart for?");
                    String answer = scan.nextLine();
                    Class cl = null; // if it remains null it means no class was found with the name the user gave and no methods will be called on cl

                    for (int i = 0; i < classes.size(); i++) {
                        if (classes.get(i).getName().equalsIgnoreCase(answer)) {
                            cl = classes.get(i);
                        }
                    }

                    if (cl == null) {

                        System.out.println("Error: no class found");

                    } else {

                        System.out.println("Would you like to make the seating chart (a) alphabetically or (b) randomly?");
                        String ans = scan.nextLine();

                        if (ans.equals("a")) {

                            System.out.println("How many rows of seats are in the classroom?");
                            int rows = scan.nextInt();
                            scan.nextLine();
                            System.out.println("How many seats are in each row?");
                            int cols = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Creating seating chart...");
                            SeatingChart chart = new SeatingChart(cl.getStudents().size(), rows, cols, cl);
                            chart.makeSeatingChart(cl.getStudents());
                            chart.printSeatingChart();

                        } else if (ans.equals("b")) {

                            System.out.println("How many rows of seats are in the classroom?");
                            int rows = scan.nextInt();
                            scan.nextLine();
                            System.out.println("How many seats are in each row?");
                            int cols = scan.nextInt();
                            scan.nextLine();
                            SeatingChart chart = new SeatingChart(cl.getStudents().size(), rows, cols, cl);
                            System.out.println("Creating seating chart...");
                            chart.makeSeatingChartRandom(cl.getStudents());
                            System.out.println("Seating chart created; printing seating chart");
                            chart.printSeatingChart();

                        }
                    }
                    break;
            }
        }


    }

    //put a feature where you can input students based on file

}
