package practice.Gradebook;

public class Student extends Person {

    private double grade;

    public Student(String name, int id, double grade) {
        super(name, id);
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getGrade() + ")";
    }
}
