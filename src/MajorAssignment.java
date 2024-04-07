package src;

import java.util.ArrayList;

public class MajorAssignment extends Assignment {

    boolean eligibleForCorrections;

    public MajorAssignment(String n, double g, boolean e) {
        super(n, g);
        eligibleForCorrections = e;
    }

    public boolean getEligibleForCorrections() {
        return true;
    }

    @Override
    public void addAssignment(Student s, Assignment a) {
        s.addMajor((MajorAssignment) a);
    }

    @Override
    public String printAssignments(Student s, ArrayList<Assignment> a) {
        String toReturn = "";
        toReturn += "Major assignments for " + s.getFirstName() + " " + s.getLastName() + " " + s.getId();
        for (int i = 0; i < a.size(); i++) {
            toReturn += "\nMajor assignment " + i;
            toReturn += "\nName: " + a.get(i).getGrade();
            toReturn += "\nEligible for corrections? " + ((MajorAssignment) a.get(i)).getEligibleForCorrections();
            toReturn += "\n";
        }
        return toReturn;
    }

}
