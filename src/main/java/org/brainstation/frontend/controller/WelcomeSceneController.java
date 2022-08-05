package org.brainstation.frontend.controller;

import javafx.fxml.FXML;
import org.brainstation.frontend.WelcomeScreen;
import java.io.IOException;
import java.io.IOException;
import javafx.fxml.FXML;
import org.brainstation.frontend.WelcomeScreen;

public class WelcomeSceneController {

    @FXML
    private void switchToPrimary() throws IOException {
        WelcomeScreen.setRoot("primary");
    }
}