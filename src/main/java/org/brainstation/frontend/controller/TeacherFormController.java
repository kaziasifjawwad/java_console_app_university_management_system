package org.brainstation.frontend.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.brainstation.backend.consoleDataBase.Database;
import org.brainstation.backend.user.Teacher;
import javafx.util.Callback;
import org.brainstation.frontend.WelcomeScreen;

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
    private TableColumn<Teacher, Button> updateTeacher;

    
    private Database database;

    private ObservableList<Teacher> teachers;
    public TeacherFormController(){
        this.database = Database.getInstance();

    }


    public void saveTeacher(ActionEvent actionEvent){
        Teacher teacher = new Teacher(
                firstName.getText(),lastName.getText(),email.getText(),"teacher"
        );
        database.saveTeacher(teacher);
        database.save();
        updateTeachers();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTeachers();
        addButtonToTableForDelete();
        addButtonToTableForView();
    }

    public void updateTeachers(){
        teachers = FXCollections.observableArrayList(this.database.getTeacherlist());
        firstName_p.setCellValueFactory(new PropertyValueFactory<Teacher, String>("firstName"));
        lastName_p.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastName"));
        email_p.setCellValueFactory(new PropertyValueFactory<Teacher, String>("email"));
        tableOtTeacher.setItems(teachers);


    }


    private void addButtonToTableForDelete() {
        TableColumn<Teacher, Void> colBtn = new TableColumn("Delete");
        Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>> cellFactory = new Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>>() {
            @Override
            public TableCell<Teacher, Void> call(final TableColumn<Teacher, Void> param) {
                final TableCell<Teacher, Void> cell = new TableCell<Teacher, Void>() {

                    private final Button btn = new Button("Delete");

                    {
                        btn.setStyle("-fx-background-color: red;-fx-text-fill: white");
                        btn.setOnAction((ActionEvent event) -> {
                            Teacher data = getTableView().getItems().get(getIndex());
                            Database.getInstance().deleteTeacher(data);
                            Database.getInstance().save();
                            getTableView().getItems().remove(data);
                            getTableView().refresh();
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        tableOtTeacher.getColumns().add(colBtn);
    }

    private void addButtonToTableForView() {
        TableColumn<Teacher, Void> colBtn = new TableColumn("View");
        Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>> cellFactory = new Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>>() {
            @Override
            public TableCell<Teacher, Void> call(final TableColumn<Teacher, Void> param) {
                final TableCell<Teacher, Void> cell = new TableCell<Teacher, Void>() {

                    private final Button btn = new Button("View full pofile");

                    {
                        btn.setStyle("-fx-background-color: #5656fd;-fx-text-fill: white");

                        btn.setOnAction((ActionEvent event) -> {
                            Teacher data = getTableView().getItems().get(getIndex());
                            Stage stage = new Stage();
                            try{
                                TeacherIndividualProfileController.teacher = data;
                                WelcomeScreen.setRoot("teacherProfile");

                            }catch (Exception e){
                                System.out.println(e);
                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        tableOtTeacher.getColumns().add(colBtn);
    }

    @FXML
    void goToMainPage(ActionEvent event)throws  Exception{
        WelcomeScreen.setRoot("adminMainPage");
    }

}
