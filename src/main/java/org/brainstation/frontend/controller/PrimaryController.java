package org.brainstation.frontend.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import org.brainstation.frontend.WelcomeScreen;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        WelcomeScreen.setRoot("secondary");
    }
}
