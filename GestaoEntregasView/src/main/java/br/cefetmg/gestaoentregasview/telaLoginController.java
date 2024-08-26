package br.cefetmg.gestaoentregasview;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaLoginController {

    @FXML
    private TextField nomeLabelLogin;

    @FXML
    private TextField labelSenhaLogin;

    @FXML
    private Button botaoLogin;
    
    @FXML
    private void realizar_login() throws IOException {
        
        String nome = nomeLabelLogin.getText();
        String senha = labelSenhaLogin.getText();
        
        System.out.println("Nome: " + nome);
        System.out.println("Senha: " + senha);
        
        App.setRoot("menu");
    }

}
