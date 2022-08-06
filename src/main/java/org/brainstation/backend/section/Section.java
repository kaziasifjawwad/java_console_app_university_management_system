package org.brainstation.backend.section;

import org.brainstation.backend.course.Course;
import org.brainstation.backend.user.Student;
import org.brainstation.backend.user.Teacher;

import java.util.LinkedList;
import java.util.List;

public class Section {

    private static int sectionId;
    private Course course;
    private List<Student> students = new LinkedList<>();
    private int sectionNumber;
    private Teacher teacher;

    public Section(){}
    public Section(Course course, int sectionNumber, Teacher teacher) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCourseId() {
        return sectionId;
    }

    public void setCourseId(int courseId) {
        this.sectionId = courseId;
    }
}
