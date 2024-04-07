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

                    System.out.println("Major or minor assessment? (major/minor)");
                    String majorOrMinor = s.nextLine();

                    //String name

                    System.out.println("Which period?");
                    Class.viewClass(classes);
                    int pd = s.nextInt();

                    for (Class c : classes) {
                        if (c.getPeriod() == pd) {

                            for (Student s : c.getStudents()) {

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
