package src;

public class SeatingChart {
    private Student[][] seatingChart;
    public SeatingChart(int numStudents, int numRows, int numColumns) {
        seatingChart = new Student[numRows][numColumns];
        int counter = 0;
        while (counter <= numStudents)
        for(int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[i].length; k++) {
                seatingChart[i][k] = new Student();
                counter++;
            }
        }
    }

    public Student getStudent(String name) {
        return new Student();
    }

    public Student getStudent(int id) {
        return new Student();
    }

    public Student getStudent(int row, int column) {
        return new Student();
    }


}
