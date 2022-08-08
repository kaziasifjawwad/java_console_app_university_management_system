package org.brainstation.frontend.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.brainstation.frontend.WelcomeScreen;


public class AdminMainPageViewController {

    @FXML
    private Button teacherView;

    @FXML
    void gotoTeacherForm(ActionEvent event) throws Exception{
        WelcomeScreen.setRoot("teacherForm");
    }

    @FXML
    void gotoCourseForm(ActionEvent event)throws  Exception{
        WelcomeScreen.setRoot("courseForm");
    }

}
