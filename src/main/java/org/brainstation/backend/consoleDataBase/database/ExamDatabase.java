package org.brainstation.backend.consoleDataBase.database;

import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;
import org.brainstation.backend.examControl.Exam;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamDatabase {
    private List<Exam> examList;
    private static ExamDatabase examDatabase;

    private ExamDatabase(){}

    public static ExamDatabase getInstance(){
        if(examDatabase==null){
            examDatabase = new ExamDatabase();
            examDatabase.setExamlist(examDatabase.readList());
        }
        return examDatabase;
    }
    public List<Exam> readList(){
        try {
            File myObj = new File(DatabaseConfiguration.examDataPath);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Exam> examList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(DatabaseConfiguration.splitter);
                Exam tempExam = new Exam(
                       Double.parseDouble(data[1]),
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]),
                        data[4]
                );
                tempExam.setExamId(Integer.parseInt(data[0]));
//                tempExam.setCourses(HelperDatabaseClass.listBuilder(data[5]));
                examList.add(tempExam);
            }
            myReader.close();
            return examList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Exam>();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new ArrayList<Exam>();
        }
    }

    public List<Exam> getExamList() {
        return examList;
    }
    public void setExamlist(List<Exam> examList) {
        this.examList = examList;
    }

    public void saveExam(Exam exam,int examId){
        exam.setExamId(examId);
        this.examList.add(exam);
        System.out.println(this.examList);
    }

    public Exam getExamById(int examId){
        for(int index=0;index<this.examList.size();index++){
            if(this.examList.get(index).getExamId()==examId) return this.examList.get(index);
        }
        return null;
    }

    public void saveAllExam(){
        HelperDatabaseClass.saveData(this.examList,DatabaseConfiguration.examDataPath);
    }

    public void deleteExam(Exam exam){
        this.examList.remove(exam);
    }
}
