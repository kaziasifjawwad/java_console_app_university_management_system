package org.brainstation.backend.examControl;
import org.brainstation.backend.consoleDataBase.DatabaseConfiguration;

public class Exam {
    private int examId;
    private double totalMarks;
    private int section;
    private double passMarks;

    private String examType;

    public Exam(){}

    public Exam(double totalMarks, int section, double passMarks, String examType) {
        this.totalMarks = totalMarks;
        this.section = section;
        this.passMarks = passMarks;
        this.examType = examType;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }
    public int getSection() {
        return section;
    }

    public void setSection(int course) {
        this.section = course;
    }

    public double getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(double passMarks) {
        this.passMarks = passMarks;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String toString(){
        String splitter = DatabaseConfiguration.splitter;
        return this.examId+
                splitter+
                this.totalMarks+
                splitter+
                this.section+
                splitter+
                this.passMarks+
                splitter+
                this.examType;
    }
}
