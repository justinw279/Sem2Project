package src;

import java.util.ArrayList;

public class Assignment {

    private String name;
    private double grade;

    public Assignment(String n, double g) {
        name = n;
        grade = g;
    }

    public void setGrade(double g) {
        grade = g;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void addAssignment(Student s, Assignment a) {
        s.addAssignment(a);
    }

    public String printAssignments(Student s, ArrayList<Assignment> a) {
        String toReturn = "";
        toReturn += "Assignments for " + s.getFirstName() + " " + s.getLastName() + " " + s.getId();
        for (int i = 0; i < a.size(); i++) {
            toReturn += "\nAssignment " + i;
            toReturn += "\nName: " + a.get(i).getGrade();
            if (a.get(i) instanceof MajorAssignment) {
                toReturn += "\nEligible for corrections? " + ((MajorAssignment) a.get(i)).getEligibleForCorrections();
            } else if (a.get(i) instanceof MinorAssignment) {
                toReturn += "\nOn coompletion? " + ((MinorAssignment) a.get(i)).getOnCompletion();
            }
            toReturn += "\n";
        }
        return toReturn;
    }




}
