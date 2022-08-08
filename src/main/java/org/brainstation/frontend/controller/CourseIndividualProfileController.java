package org.brainstation.frontend.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.brainstation.backend.consoleDataBase.Database;
import org.brainstation.backend.course.Course;
import org.brainstation.backend.user.Teacher;
import org.brainstation.frontend.WelcomeScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseIndividualProfileController implements Initializable {

    @FXML
    private Button updateCourse_f;

    @FXML
    private TextField courseName_f;

    @FXML
    private TextField courseInit_f;

    @FXML
    private TextField description_f;

    public static Course course;

    public boolean isEditClicked;

    @FXML
    private Button courseList_f;






    public CourseIndividualProfileController(){
        this.isEditClicked = true;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(course+"\n\n\n\n**********");
        this.courseName_f.setText(course.getCourseName());
        this.courseInit_f.setText(course.getCourseInitial());
        this.description_f.setText(course.getCourseDescription());
        updateFieldStatus(false);
    }

    public void updateFieldStatus(boolean flag){
        this.courseName_f.setEditable(flag);
        this.courseInit_f.setEditable(flag);
        this.description_f.setEditable(flag);
    }

    @FXML
    private void switchToCourseList() throws IOException {
        System.out.println("-------------------------");
        WelcomeScreen.setRoot("courseForm");
    }

    @FXML
    private void editCourseFunction() throws IOException {
        System.out.println("hiiiii");
        if(this.isEditClicked){
            updateFieldStatus(true);
            this.updateCourse_f.setText("Update");
            this.isEditClicked = false;
        }else{
            course.setCourseName(description_f.getText());
            course.setCourseName(courseName_f.getText());
            course.setCourseInitial(courseInit_f.getText());
            Database.getInstance().save();
            updateFieldStatus(false);
            this.isEditClicked = true;
            this.updateCourse_f.setText("Edit");
        }
    }
}
