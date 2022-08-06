package org.brainstation.backend.consoleDataBase;

import org.brainstation.backend.consoleDataBase.database.CourseDataBase;
import org.brainstation.backend.consoleDataBase.database.HelperDatabaseClass;
import org.brainstation.backend.consoleDataBase.database.StudentDataBase;
import org.brainstation.backend.consoleDataBase.database.TeacherDatabase;
import org.brainstation.backend.course.Course;
import org.brainstation.backend.user.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private static Database jsonDatabase;

    private  TeacherDatabase teacherDatabase;

    private  CourseDataBase courseDataBase;

    private  StudentDataBase studentDataBase;

    private ArrayList<Integer> modelId;

    private Database(){}


    public static Database getInstance(){
        if(jsonDatabase==null){
            jsonDatabase = new Database();
            jsonDatabase.teacherDatabase = TeacherDatabase.getInstance();
            jsonDatabase.courseDataBase = CourseDataBase.getInstance();
//            jsonDatabase.studentDataBase = StudentDataBase.getInstance();
//            jsonDatabase.modelId = getModelIdFile();
        }
        return jsonDatabase;
    }

    private static ArrayList<Integer> getModelIdFile(){
        try{
            File myObj = new File(DatabaseConfiguration.idHandler);
            Scanner myReader = new Scanner(myObj);
            String line = myReader.nextLine();
            System.out.println(line);
            ArrayList<Integer> list = HelperDatabaseClass.listBuilder(line);
            myReader.close();
            return list;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public  TeacherDatabase getTeacherDatabase() {
        return teacherDatabase;
    }

    public  CourseDataBase getCourseDataBase() {
        return courseDataBase;
    }

    public  StudentDataBase getStudentDataBase() {
        return studentDataBase;
    }


    public List<Teacher> readTeacherList(){return this.teacherDatabase.readList();}
    public List<Teacher> getTeacherlist(){return this.teacherDatabase.getTeacherlist();}
    public void saveTeacher(Teacher teacher){
        int id=this.modelId.get(0);
        this.teacherDatabase.saveTeacher(teacher,id);
        id++;
        this.modelId.set(0,id);
        HelperDatabaseClass.saveLine(this.modelId,DatabaseConfiguration.idHandler);
    }

    public List<Course> readCourseList(){return this.courseDataBase.readList();}
    public List<Course> getCourselist(){return this.courseDataBase.getCourselist();}
    public void saveCourse(Course course){
        int id=this.modelId.get(1);
        this.courseDataBase.saveCourse(course,id);
        id++;
        this.modelId.add(1,id);
        HelperDatabaseClass.saveLine(this.modelId,DatabaseConfiguration.idHandler);
    }
    public Course getCourseById(int courseId){return this.courseDataBase.getCourseById(courseId);}

    public void save(){
        this.teacherDatabase.saveAllTeacher();
        this.courseDataBase.saveAllCourse();
    }






}