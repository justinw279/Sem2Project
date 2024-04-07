package src;

public class MajorAssignment extends Assignment {

    boolean eligibleForCorrections;

    public MajorAssignment(String n, double g, boolean e) {
        super(n, g);
        eligibleForCorrections = e;
    }

    @Override
    public void addAssignment(Student s, Assignment a) {
        s.addMajor((MajorAssignment) a);
    }

}
