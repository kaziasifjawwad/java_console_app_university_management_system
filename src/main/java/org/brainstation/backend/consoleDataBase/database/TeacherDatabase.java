package org.brainstation.backend.consoleDataBase.database;

import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import org.brainstation.backend.course.Course;
import org.brainstation.backend.user.Student;
import org.brainstation.backend.user.Teacher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TeacherDatabase {
    private List<Teacher> teacherlist;

    private static TeacherDatabase teacherDatabase;


    private TeacherDatabase(){}

    public static TeacherDatabase getInstance(){
        if(teacherDatabase==null){
            teacherDatabase = new TeacherDatabase();
            teacherDatabase.setTeacherlist(teacherDatabase.readList());
        }
        return teacherDatabase;
    }
    public List<Teacher> readList(){
        try {
            File myObj = new File(DatabaseConfiguration.teacherDataPath);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Teacher> teacherList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(DatabaseConfiguration.splitter);
                Teacher tempTeacher = new Teacher(
                        data[1],data[2],data[3],data[4]
                );
                tempTeacher.setUserid(Integer.parseInt(data[0]));
                tempTeacher.setCourses(HelperDatabaseClass.listBuilder(data[5]));
                teacherList.add(tempTeacher);
            }
            myReader.close();
            return teacherList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Teacher>();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Teacher>();
        }
    }


    public List<Teacher> getTeacherlist() {
        return teacherlist;
    }

    public void setTeacherlist(List<Teacher> teacherlist) {
        this.teacherlist = teacherlist;
    }


    public void saveTeacher(Teacher teacher,int teacherId){
        teacher.setUserid(teacherId);
        this.teacherlist.add(teacher);
        System.out.println(this.teacherlist);

    }

    public Teacher getTeacherById(int courseId){
        for(int index=0;index<this.teacherlist.size();index++){
            if(this.teacherlist.get(index).getUserid()==courseId) return this.teacherlist.get(index);
        }
        return null;
    }

    public void saveAllTeacher(){
        HelperDatabaseClass.saveData(this.teacherlist,DatabaseConfiguration.teacherDataPath);
    }


}
