package org.brainstation.frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.brainstation.App;

import java.io.IOException;

public class WelcomeScreen {
    private static Scene scene;

    public void showWelcomeScene(Stage stage) throws Exception{
        scene = new Scene(loadFXML("courseForm"),800,800);
        System.out.println(scene+"***************************");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
