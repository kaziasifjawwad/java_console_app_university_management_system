package org.brainstation.backend.user;


import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import org.brainstation.backend.course.Course;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends User implements BasicUser{

    private List<Integer> coursesId;

    public Teacher(){
        coursesId = new LinkedList<>();
    }

    public Teacher(String firstName, String lastName, String email, String role) {
        super(firstName, lastName, email, role);
        coursesId = new LinkedList<>();
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


    public List<Integer> getCourse() {
        return coursesId;
    }
    public void setCourseId(int courseId) {
        this.coursesId.add(courseId);
    }

    public void setCourses(List<Integer> course) {
        this.coursesId = course;
    }

    public List<Integer> getCourses() {
        return coursesId;
    }

    public String toString(){
        String splitter = DatabaseConfiguration.splitter;
        return this.getUserid()+
                splitter+
                this.getFirstName()+
                splitter+
                this.getLastName()+
                splitter+
                this.getEmail()+
                splitter+
                this.getRole()+
                splitter+
                this.getCourse().toString();
    }
}
