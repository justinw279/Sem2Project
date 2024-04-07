package src;

import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private ArrayList<MajorAssignment> majorAssignments;
    private ArrayList<MinorAssignment> minorAssignments;

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

}
