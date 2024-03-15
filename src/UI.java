package src;

import java.util.Scanner;

public class UI {

    int students;
    Scanner scan;
    String className;

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
            System.out.println("b) Modify new class");
            System.out.println("c) Delete new class");
            System.out.println("d) Create assignment");
            System.out.println("e) Modify assignment");
            System.out.println("f) Delete assignment");
            System.out.println("e) Modify grades for a class");
            System.out.println("q) Quit");
            option = scan.nextLine();
            switch (option) {
                case "a":
                    Class.createNewClass();
                case "b":
                    System.out.println("in progress");
                case "c":
                    System.out.println("in progress");
                case "d":
                    System.out.println("in progress");
                case "e":
                    System.out.println("in progress");
                case "f":
                    System.out.println("in progress");
                case "g":
                    System.out.println("in progress");
                case "h":
                    System.out.println("in progress");
            }
        }


    }

    //put a feature where you can input students based on file

}
