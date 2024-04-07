package src;

import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private ArrayList<MajorAssignment> majorAssignments;
    private ArrayList<MinorAssignment> minorAssignments;
    private ArrayList<Assignment> assignments;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void addMajor(MajorAssignment majorAssignment) {
        majorAssignments.add(majorAssignment);
        assignments.add(majorAssignment);
    }

    public void addMinor(MinorAssignment minorAssignment) {
        minorAssignments.add(minorAssignment);
        assignments.add(minorAssignment);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

}
