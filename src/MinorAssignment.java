package src;

public class MinorAssignment extends Assignment {

    boolean onCompletion;

    public MinorAssignment(String n, double g, boolean onCompletion) {
        super(n, g);
        if (onCompletion) {
            if (g > 0) {
                setGrade(100);
            }
        }
    }

}
