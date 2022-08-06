package org.brainstation.backend.consoleDataBase.database;

import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import org.brainstation.backend.course.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDataBase {
    private List<Course> courselist;

    private static CourseDataBase courseDataBase;


    private CourseDataBase(){}

    public static CourseDataBase getInstance(){
        if(courseDataBase==null){
            courseDataBase = new CourseDataBase();
            courseDataBase.setCourseList(courseDataBase.readList());
        }
        return courseDataBase;
    }
    public List<Course> readList(){
        try {
            File myObj = new File(DatabaseConfiguration.courseDataPath);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Course> courseList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(DatabaseConfiguration.splitter);
                Course tempCourse = new Course(
                        data[1],data[2],data[3]
                );
                tempCourse.setCourseId(Integer.parseInt(data[0]));
//                tempCourse.setCourses(HelperDatabaseClass.listBuilder(data[5]));
                courseList.add(tempCourse);
            }
            myReader.close();
            return courseList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Course>();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Course>();
        }
    }


    public List<Course> getCourselist() {
        return courselist;
    }

    public void setCourseList(List<Course> courselist) {
        this.courselist = courselist;
    }


    public void saveCourse(Course course,int courseId){
        course.setCourseId(courseId);
        this.courselist.add(course);
        saveAllCourse();
    }

    public Course getCourseById(int courseId){
        System.out.println(this.courselist);
        for(int index=0;index<this.courselist.size();index++){
            if(this.courselist.get(index).getCourseId()==courseId){
                return this.courselist.get(index);
            }
        }
        return null;
    }
    public void saveAllCourse(){HelperDatabaseClass.saveData(this.courselist,DatabaseConfiguration.courseDataPath);}

}
