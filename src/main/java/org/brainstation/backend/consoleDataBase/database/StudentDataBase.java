package org.brainstation.backend.consoleDataBase.database;
import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import org.brainstation.backend.user.Student;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files


public class StudentDataBase {
    private List<Student> studentlist;

    private static StudentDataBase studentDatabase;


    private StudentDataBase(){}

    public static StudentDataBase getInstance(){
        if(studentDatabase==null){
            studentDatabase = new StudentDataBase();
            studentDatabase.setStudentlist(studentDatabase.readList());
        }
        return studentDatabase;
    }
    public List<Student> readList(){
        try {
            File myObj = new File(DatabaseConfiguration.studentDataPath);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Student> studentList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(DatabaseConfiguration.splitter);
                Student tempStudent = new Student(
                        data[1],data[2],data[3],data[4]
                );
//                tempStudent.setCourses(StringTOList.listBuilder(data[5]));
//                teacherList.add(tempTeacher);
            }
            myReader.close();
            return studentList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Student>();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Student>();
        }
    }


    public List<Student> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(List<Student> studentlist) {
        this.studentlist = studentlist;
    }



    public void saveStudent(Student student){
        System.out.println(student);
        student.setUserid(1);
        this.studentlist.add(student);
        HelperDatabaseClass.saveData(this.studentlist,DatabaseConfiguration.studentDataPath);
    }

    public Student getStudentById(int courseId){
        for(int index=0;index<this.studentlist.size();index++){
            if(this.studentlist.get(index).getUserid()==courseId) return this.studentlist.get(index);
        }
        return null;
    }

}
