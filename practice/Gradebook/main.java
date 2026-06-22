package practice.Gradebook;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        File data = new File("practice/Gradebook/StudentData.csv");
        try {
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextLine()) {
                String info = scanner.nextLine();
                String name = "";
                String idString = "";
                String gradeString = "";
                int count = 0;
                for (int i = 0; i < info.length(); i++) {
                    if (info.charAt(i) != ',') {
                        if (count == 0) {
                            name += info.charAt(i);
                        } else if (count == 1) {
                            idString += info.charAt(i);
                        } else {
                            gradeString += info.charAt(i);
                        }
                    } else {
                        count++;
                    }
                }
                try {
                    students.add(new Student(name, Integer.valueOf(idString), Double.valueOf(gradeString)));
                } finally {continue;}
            }
            scanner.close();
        }catch (Exception e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }finally {}

        ArrayList<Student> sortedStudents = new ArrayList<>();
        while (!students.isEmpty()) {
            double maxGrade = 0.0;
            int maxGradeIndex = 0;
            for (int i = 0; i < students.size(); i ++) {
                if (students.get(i).getGrade() > maxGrade) {
                    maxGradeIndex = i;
                    maxGrade = students.get(i).getGrade();
                }
            }
            sortedStudents.add(students.get(maxGradeIndex));
            students.remove(maxGradeIndex);
        }

        //print result
        System.out.println("Sorted Student Report");
        System.out.println("---------------------");
        for (int i = 0; i < sortedStudents.size(); i++) {
            System.out.println(sortedStudents.get(i).toString());
        }
    }
}
