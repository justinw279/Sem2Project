public class Class {

    private String className;
    private SeatingChart seatingChart;
    public Class(String className, int numStudents, int numRows, int numColumns) {
        seatingChart = new SeatingChart(numStudents, numRows, numColumns);
        this.className = className;
    }
}
