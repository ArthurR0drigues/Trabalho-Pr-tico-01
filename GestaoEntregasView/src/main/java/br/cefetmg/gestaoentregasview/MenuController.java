package br.cefetmg.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void sairParaLogin() throws IOException {
        App.setRoot("telaLogin");
    }
}