package org.brainstation.frontend.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.brainstation.backend.consoleDataBase.Database;
import org.brainstation.backend.user.Teacher;
import org.brainstation.backend.user.User;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherFormController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;



    @FXML
    TableView<Teacher> tableOtTeacher;
    @FXML
    private TableColumn<Teacher, String> email_p;


    @FXML
    private TableColumn<Teacher, String> firstName_p;

    @FXML
    private TableColumn<Teacher, String> lastName_p;

    @FXML
    private Button saveTeacher;
    
    private Database database;

    private ObservableList<Teacher> teachers;

    public TeacherFormController(){
        this.database = Database.getInstance();

    }


    public void saveTeacher(ActionEvent actionEvent){
        System.out.println(firstName.getText());
        Teacher teacher = new Teacher(
                firstName.getText(),lastName.getText(),email.getText(),"teacher"
        );
        System.out.println(teacher);
        database.saveTeacher(teacher);
        updateTeachers();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTeachers();
    }

    public void updateTeachers(){
        teachers = FXCollections.observableArrayList(this.database.getTeacherlist());
        firstName_p.setCellValueFactory(new PropertyValueFactory<Teacher, String>("firstName"));
        lastName_p.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastName"));
        email_p.setCellValueFactory(new PropertyValueFactory<Teacher, String>("email"));
        tableOtTeacher.setItems(teachers);
    }
}
