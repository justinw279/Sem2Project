package src;

import java.util.ArrayList;
import java.util.Scanner;
public class SeatingChart {
    private Class cl;
    private Student[][] seatingChart;
    private Scanner scan;

    public SeatingChart(int numStudents, int numRows, int numColumns, Class cl) {
        scan = new Scanner(System.in);
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
                if (idx >= students.size()) {
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
        int idx = (int) (Math.random() * students.size());
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
        for (int i = 1; i <= seatingChart[0].length; i++) {
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
                    System.out.print("__" + " ");
                }
            }
            System.out.println();
            counter++;
        }
        System.out.println();
        System.out.print("Do you want to see a student's info? (y/n) ");
        String answer = scan.nextLine();
        if (answer.equals("y")) {
            getStudentInfo();
        }
    }

    public void addStudent(Student student) {
        boolean hasEmpty = false;
        int iidx = 0;
        int kidx = 0;
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[i].length; k++) {
                if (seatingChart[i][k] == null) {
                    if (!hasEmpty) {
                        hasEmpty = true;
                        iidx = i;
                        kidx = k;
                    }
                }
            }
        }
        if (hasEmpty) {
            seatingChart[iidx][kidx] = student;
        } else {
            Student[][] temp = new Student[seatingChart.length + 1][seatingChart[0].length];
            for (int i = 0; i < seatingChart.length; i++) {
                for (int k = 0; k < seatingChart[i].length; k++) {
                    temp[i][k] = seatingChart[i][k];
                }
            }
            iidx = seatingChart.length;
            temp[iidx][0] = student;
            seatingChart = temp;
        }
    }

    public void removeStudent(int id) {
        for (int i = 0; i < seatingChart.length; i++) {
            for (int k = 0; k < seatingChart[i].length; k++) {
                if (seatingChart[i][k] != null) {
                    if (seatingChart[i][k].getId() == id) {
                        seatingChart[i][k] = null;
                    }
                }
            }
        }
    }

    public void getStudentInfo() {
        System.out.print("What row is this student in? ");
        int row = scan.nextInt();
        scan.nextLine();
        System.out.print("What column is this student in? ");
        int col = scan.nextInt();
        scan.nextLine();
        System.out.println();
        Student s = seatingChart[row - 1][col - 1];
        MajorAssignment a = new MajorAssignment("Generic", 100, true);
        MinorAssignment b = new MinorAssignment("Generic", 100, true);
        System.out.println(a.printAssignments(s, s.getAssignments()));
        System.out.println(b.printAssignments(s, s.getAssignments()));
    }
}
