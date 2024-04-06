package src;

import java.util.ArrayList;

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

    public void makeSeatingChart(ArrayList<Student> students) {
        int idx = 0;
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[0].length; k++) {
                seatingChart[i][k] = students.get(idx);
                idx++;
            }
        }
    }

    public void makeSeatingChartRandom(ArrayList<Student> students) {
        ArrayList<Student> temp = students;
        int idx = (int) (Math.random() * students.size()) + 1;
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[0].length; k++) {
                seatingChart[i][k] = temp.remove(idx);
                idx = (int) (Math.random() * students.size()) + 1;
            }
        }
    }

}
