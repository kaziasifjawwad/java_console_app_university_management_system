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
        scene = new Scene(loadFXML("welcome"),800,800);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        System.out.println("helloo");
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        System.out.println(fxmlLoader+"\t\t"+fxmlLoader);
        return fxmlLoader.load();
    }
}
