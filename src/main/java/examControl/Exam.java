package examControl;
import course.Course;
import user.Student;
import user.Teacher;

public class Exam {
    private double totalMarks;
    private double obtainedMarks;
    private Course course;
    private Student student;
    private Teacher teacher;
    private double passMarks;

    public Exam(double totalMarks, double obtainedMarks, Course course, Student student, Teacher teacher, double passMarks) {
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        this.course = course;
        this.student = student;
        this.teacher = teacher;
        this.passMarks = passMarks;
    }


    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(double obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(double passMarks) {
        this.passMarks = passMarks;
    }
}
