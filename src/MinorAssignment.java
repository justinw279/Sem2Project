package src;

public class MinorAssignment extends Assignment {

    boolean onCompletion;

    public MinorAssignment(String n, double g, boolean onCompletion) {

        double grade = 0;

        if (onCompletion) {
            if (g > 0) {
                grade = 100;
            }
        }

        grade = 100;

        super(n, grade);
    }

}
