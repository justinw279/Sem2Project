package src;

import java.util.ArrayList;

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

    public boolean getOnCompletion() {
        return onCompletion;
    }

    @Override
    public void addAssignment(Student s, Assignment a) {
        s.addMinor((MinorAssignment) a);
    }

    @Override
    public String printAssignments(Student s, ArrayList<Assignment> a) {
        String toReturn = "";
        toReturn += "Minor assignments for " + s.getFirstName() + " " + s.getLastName() + " " + s.getId();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) instanceof MinorAssignment) {
                toReturn += "\nName: " + a.get(i).getName();
                toReturn += "\nGrade: " + a.get(i).getGrade();
                toReturn += "\nOn completion? " + ((MinorAssignment) a.get(i)).getOnCompletion();
                toReturn += "\n";
            }
        }
        return toReturn;
    }

}
