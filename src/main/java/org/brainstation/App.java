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
    private static Stage stage;
    private static WelcomeScreen teacherView;
    @Override
    public void start(Stage primarystage) throws IOException {
        stage = primarystage;
//        stage.setResizable(false);
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