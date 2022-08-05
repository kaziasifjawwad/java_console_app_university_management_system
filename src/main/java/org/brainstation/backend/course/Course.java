package org.brainstation.backend.course;

public class Course {
    private String courseName;
    private String courseInitial;
    private String courseDescription;


    public Course(String courseName, String courseInitial, String courseDescription, int courseId) {
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

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseInitial='" + courseInitial + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
