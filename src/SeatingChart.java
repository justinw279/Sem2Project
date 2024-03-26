package src;

public class SeatingChart {
    private Student[][] seatingChart;
    public SeatingChart(int numStudents, int numRows, int numColumns) {
        seatingChart = new Student[numRows][numColumns];
        int counter = 0;
        while (counter <= numStudents)
        for(int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[i].length; k++) {
                seatingChart[i][k] = null;
                counter++;
            }
        }
    }

    public Student getStudent(String fistName, String lastName) {
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[i].length; k++) {
                if (seatingChart[i][k].getFirstName().equals(fistName) && seatingChart[i][k].getLastName().equals(lastName)) {
                    return seatingChart[i][k];
                }
            }
        }
        return null;
    }

    public Student getStudent(int id) {
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[i].length; k++) {
                if (seatingChart[i][k].getId() == id) {
                    return seatingChart[i][k];
                }
            }
        }
        return null;
    }

    public Student getStudent(int row, int col) {
        return seatingChart[row][col];
    }

    public void printSeatingChart() {
        for (Student[] row : seatingChart) {
            for (Student student : row) {
                System.out.print(student);
            }
            System.out.println();
        }
    }


}
