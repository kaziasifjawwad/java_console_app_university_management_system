package org.brainstation.backend.course;

import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;

public class Course {
    private String courseName;
    private String courseInitial;
    private String courseDescription;

    private int courseId;

    public Course(){}

    public Course(String courseName, String courseInitial, String courseDescription) {
        this.courseName = courseName;
        this.courseInitial = courseInitial;
        this.courseDescription = courseDescription;

    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInitial() {
        return courseInitial;
    }

    public void setCourseInitial(String courseInitial) {
        this.courseInitial = courseInitial;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String toString(){
//        String courseName, String courseInitial, String courseDescription
        String splitter = DatabaseConfiguration.splitter;
        return  this.getCourseId()+
                splitter+
                this.getCourseName()+
                splitter+
                this.getCourseInitial()+
                splitter+
                this.getCourseDescription();
    }
}
