package org.brainstation.backend;


import org.brainstation.backend.consoleDataBase.Database;
import org.brainstation.backend.course.Course;
import org.brainstation.backend.user.Teacher;

public class Test {
    public static void main(String[] args) {
        Database database = Database.getInstance();

//        Teacher teacher = new Teacher("Tawhid","Anwar","tawhid@gmail.com","Teacher");
//        database.saveTeacher(teacher);
//        teacher = new Teacher("Mahtin","Abdullah","mahtin@gmail.com","Teacher");
//        database.saveTeacher(teacher);
//        teacher = new Teacher("Tanzim","Reza","teza@gmail.com","Teacher");
//        database.saveTeacher(teacher);

//        Course course = new Course("python","cse110","course1");
//        database.saveCourse(course);
//        course = new Course("python oop","cse111","course2");
//        database.saveCourse(course);
//        course = new Course("data structure","cse220","course3");
//        database.saveCourse(course);
//        course = new Course("Networking","cse320","course4");
//        database.saveCourse(course);

        database.getTeacherlist().get(0).setCourseId(
                database.getCourselist().get(0).getCourseId()
        );

        database.getTeacherlist().get(0).setCourseId(
                database.getCourselist().get(1).getCourseId()
        );

        database.getTeacherlist().get(0).setCourseId(
                database.getCourselist().get(2).getCourseId()
        );

        database.save();

    }
}
