package org.brainstation.backend.section;

import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import java.util.LinkedList;
import java.util.List;

public class Section {

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    private int sectionId;
    private int courseId;
    private List<Integer> students = new LinkedList<>();
    private int sectionNumber;
    private int teacher;

    public Section(){}
    public Section(int course, int sectionNumber) {
        this.courseId = course;
        this.sectionNumber = sectionNumber;
    }

    public int getCourse() {
        return courseId;
    }

    public void setCourse(int course) {
        this.courseId = course;
    }

    public List<Integer> getStudents() {
        return students;
    }

    public void setStudent(int studentId){this.students.add(studentId);}

    public void setStudents(List<Integer> students) {
        this.students = students;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getCourseId() {
        return sectionId;
    }

    public void setCourseId(int courseId) {
        this.sectionId = courseId;
    }

    public String toString(){
        String splitter = DatabaseConfiguration.splitter;
        return this.sectionId+
                splitter+
                this.courseId+
                splitter+
                this.sectionNumber+
                splitter+
                this.teacher+
                splitter+
                this.students.toString();
    }
}
