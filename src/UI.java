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
            System.out.println("f) Modify assignment");
            System.out.println("g) Delete assignment");
            System.out.println("h) Create seating chart for a class");
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
                    System.out.println("in progress");
                    break;
                case "f":
                    System.out.println("in progress");
                    break;
                case "g":
                    System.out.println("in progress");
                    break;
                case "h":
                    System.out.println("in progress");
                    break;
            }
        }


    }

    //put a feature where you can input students based on file

}
