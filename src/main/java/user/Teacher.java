package user;

import course.Course;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends User implements BasicUser{

    private List<Course> course;

    public Teacher(){
        course = new LinkedList<>();
    }

    public Teacher(String firstName, String lastName, String email, String role) {
        super(firstName, lastName, email, role);
        course = new LinkedList<>();
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "course=" + course +
                '}';
    }

    public List<Course> getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course.add(course);
    }
}
