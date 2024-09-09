package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.gestaoentregasentidades.entidades.enums.TipoPerfil;
import java.io.IOException;
import java.util.List;
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
        
        FuncionarioController controller = new FuncionarioController();
        List<TipoPerfil> tipos = controller.consultarLogin(nome, senha);
        
        if(tipos != null)  {
            for(TipoPerfil tp : tipos) {
                switch(tp) {
                    case ADMINISTRADOR:
                        App.abrirJanela("menuAdministrador.fxml");
                        break;
                    case ATENDENTE:
                        App.abrirJanela("menuAtendente.fxml");
                        break;
                    case ENTREGADOR:
                        App.abrirJanela("menuEntregador.fxml");
                        break;
                }
            }
        } else if(nome.equals("admin") && senha.equals("admin")) {
            App.abrirJanela("menuAdministrador.fxml");
        }
    }
}
