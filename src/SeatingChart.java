package src;

import java.util.ArrayList;

public class SeatingChart {
    private Class cl;
    private Student[][] seatingChart;
    private int numRows;
    private int numCol;
    public SeatingChart(int numStudents, int numRows, int numColumns, Class cl) {
        this.numRows = numRows;
        numCol = numColumns;
        this.cl = cl;
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

    public void makeSeatingChart(ArrayList<Student> students) {
        int idx = 0;
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[0].length; k++) {
                if (idx >= students.size() - 1) {
                    seatingChart[i][k] = null;
                } else {
                    seatingChart[i][k] = students.get(idx);
                    idx++;
                }
            }
        }
        cl.setSeatingChart(this);
    }

    public void makeSeatingChartRandom(ArrayList<Student> students) {
        ArrayList<Student> temp = students;
        int idx = (int) (Math.random() * students.size()) + 1;
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[0].length; k++) {
                if (temp.size() == 0) {
                    seatingChart[i][k] = null;
                } else {
                    seatingChart[i][k] = temp.remove(idx);
                    idx = (int) (Math.random() * students.size());
                }
            }
        }
        cl.setSeatingChart(this);
    }

    public void printSeatingChart() {
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < numCol; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        int counter = 1;
        for (Student[] row : seatingChart) {
            System.out.print(counter + " ");
            for (Student student : row) {
                if (student != null) {
                    System.out.print(student.getFirstName().substring(0, 1) + student.getLastName().substring(0, 1) + " ");
                } else {
                    System.out.print("__");
                }
            }
            System.out.println();
            counter++;
        }
        System.out.println();
    }
}
