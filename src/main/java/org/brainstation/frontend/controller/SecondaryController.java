package org.brainstation.frontend.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import org.brainstation.frontend.WelcomeScreen;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        WelcomeScreen.setRoot("welcomeScene");
    }
}