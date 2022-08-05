package org.brainstation;

import javafx.application.Application;
import javafx.stage.Stage;
import org.brainstation.frontend.WelcomeScreen;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

//    private static Scene scene;
    private static WelcomeScreen teacherView;
    @Override
    public void start(Stage stage) throws IOException {
        try{
            teacherView.showWelcomeScene(stage);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        teacherView = new WelcomeScreen();
        launch();
    }

}