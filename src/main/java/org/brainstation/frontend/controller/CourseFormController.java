package org.brainstation.frontend.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.brainstation.backend.consoleDataBase.Database;
import org.brainstation.backend.course.Course;
import org.brainstation.backend.user.Teacher;
import org.brainstation.frontend.WelcomeScreen;

import java.net.URL;
import java.util.ResourceBundle;

//implements Initializable
public class CourseFormController implements Initializable{

    @FXML
    private TextField Coursedescription_f;

    @FXML
    private TextField courseInit_f;

    @FXML
    private TableColumn<Course, String> courseInit_p;

    @FXML
    private TextField courseName_f;


    @FXML
    private TableColumn<Course, String> courseName_p;

    @FXML
    private Button saveCourse;

    @FXML
    private TableView<Course> tableOfCourse;

    private Database database;

    private ObservableList<Course> courses;

//    private ObservableList<Teacher> teachers;

    public CourseFormController(){
        this.database = Database.getInstance();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCourses();
        addButtonToTableForDelete();
        addButtonToTableForView();
    }

    public void updateCourses(){
        courses = FXCollections.observableArrayList(this.database.getCourselist());
        courseName_p.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        courseInit_p.setCellValueFactory(new PropertyValueFactory<Course, String>("courseInitial"));
        tableOfCourse.setItems(courses);
    }



    private void addButtonToTableForDelete() {
        TableColumn<Course, Void> colBtn = new TableColumn("Delete");
        Callback<TableColumn<Course, Void>, TableCell<Course, Void>> cellFactory = new Callback<TableColumn<Course, Void>, TableCell<Course, Void>>() {
            @Override
            public TableCell<Course, Void> call(final TableColumn<Course, Void> param) {
                final TableCell<Course, Void> cell = new TableCell<Course, Void>() {

                    private final Button btn = new Button("Delete");

                    {
                        btn.setStyle("-fx-background-color: red;-fx-text-fill: white");
                        btn.setOnAction((ActionEvent event) -> {
                            Course data = getTableView().getItems().get(getIndex());
                            Database.getInstance().deleteCourse(data);
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
        tableOfCourse.getColumns().add(colBtn);
    }


    private void addButtonToTableForView() {
        TableColumn<Course, Void> colBtn = new TableColumn("View");
        Callback<TableColumn<Course, Void>, TableCell<Course, Void>> cellFactory = new Callback<TableColumn<Course, Void>, TableCell<Course, Void>>() {
            @Override
            public TableCell<Course, Void> call(final TableColumn<Course, Void> param) {
                final TableCell<Course, Void> cell = new TableCell<Course, Void>() {

                    private final Button btn = new Button("View full pofile");

                    {
                        btn.setStyle("-fx-background-color: #5656fd;-fx-text-fill: white");

                        btn.setOnAction((ActionEvent event) -> {
                            Course data = getTableView().getItems().get(getIndex());
                            Stage stage = new Stage();
                            try{
//                                FXMLLoader loader = new FXMLLoader(App.class.getResource("teacherProfile.fxml"));
//                                Parent load = loader.load();
//                                Scene scene = new Scene(load,800,800);
//                                System.out.println(scene+"==============");
//                                TeacherIndividualProfileController teacher = loader.getController();
//                                teacher.setTeacher(data);
//                                stage.setScene(scene);
//                                stage.show();
                                TeacherIndividualCourseProfileController.course = data;
                                WelcomeScreen.setRoot("courseProfile");

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
        tableOfCourse.getColumns().add(colBtn);
    }



    @FXML
    void saveCourseFunction(ActionEvent event) {

        Course course = new Course(
                courseName_f.getText(),courseInit_f.getText(), Coursedescription_f.getText()
        );
        database.saveCourse(course);
        database.save();
        updateCourses();
    }


}