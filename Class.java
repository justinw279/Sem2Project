import java.util.Scanner;

public class Class {







    public static void createNewClass() {

        Scanner scan = new Scanner(System.in);
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


                System.out.print("Enter student " + (i + 1) + " first name:");
                String first = scan.nextLine();

                System.out.print("Enter student " + (i + 1) + " last name:");
                String last = scan.nextLine();



            }

        } else if (option.equals("b")) {

        } else if (option.equals("q")) {

        }

    }


}
