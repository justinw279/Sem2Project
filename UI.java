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
        System.out.println("Welcome to the book of grades.");
        System.out.print("Enter class name: ");
        className = scan.nextLine();
        System.out.print("Enter students: ");
        students = scan.nextInt();
    }

    //put a feature where you can input students based on file

}
