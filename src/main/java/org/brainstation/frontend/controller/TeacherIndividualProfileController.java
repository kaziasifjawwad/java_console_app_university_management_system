package org.brainstation.frontend.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.brainstation.backend.consoleDataBase.Database;
import org.brainstation.backend.user.Teacher;
import org.brainstation.frontend.WelcomeScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherIndividualProfileController implements Initializable {

    @FXML
    private Button editTeacher;

    @FXML
    private TextField email_f;

    @FXML
    private TextField firstName_f;

    @FXML
    private TextField lastName_f;

    public static Teacher teacher;

    public boolean isEditClicked;

    @FXML
    private Button goToTeacherList;






    public TeacherIndividualProfileController(){
        this.isEditClicked = true;
//        this.email_f.setText("hello");
//        this.email_f.setEditable(false);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.email_f.setText(teacher.getEmail());
        this.firstName_f.setText(teacher.getFirstName());
        this.lastName_f.setText(teacher.getLastName());
        updateFieldStatus(false);
    }

    public void updateFieldStatus(boolean flag){
        this.email_f.setEditable(flag);
        this.firstName_f.setEditable(flag);
        this.lastName_f.setEditable(flag);
    }

    @FXML
    private void switchToTeacherList() throws IOException {
        WelcomeScreen.setRoot("teacherForm");
    }

    @FXML
    private void editTeacherFunction() throws IOException {
        if(this.isEditClicked){
            updateFieldStatus(true);
            this.editTeacher.setText("Update");
            this.isEditClicked = false;
        }else{
            TeacherIndividualProfileController.teacher.setFirstName(this.firstName_f.getText());
            TeacherIndividualProfileController.teacher.setLastName(this.lastName_f.getText());
            TeacherIndividualProfileController.teacher.setEmail(this.email_f.getText());
            Database.getInstance().save();
            updateFieldStatus(false);
            this.isEditClicked = true;
            this.editTeacher.setText("Edit");
        }
    }
}
