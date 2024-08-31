package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.ClienteController;
import br.cefetmg.gestaoentregascontroller.EmpresaController;
import br.cefetmg.gestaoentregascontroller.EntidadeController;
import br.cefetmg.gestaoentregascontroller.PerfilController;
import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Cliente;
import br.cefetmg.gestaoentregasentidades.entidades.Empresa;
import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.VBox;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registros.fxml"));
        loader.setControllerFactory(c -> {
            if (RegistrosController.class.isAssignableFrom(c)) {
                var bingos = new EmpresaController();
                var dingos = bingos.entidade();
                return new RegistrosController<>(bingos, dingos);
            }
            return null;
        });
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registros de Empresa");
        stage.setResizable(false);
        stage.show();
        
        App.abrirNovaJanela("Cliente", new ClienteController());
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Método estático que abre uma nova janela.
     * @param nome (nome da entidade)
     * @param controller (controller respectivo à entidade)
     * @throws IOException
     */
    public static void abrirNovaJanela(String nome, EntidadeController controller) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(App.class.getResource("registros.fxml"));

        loader.setControllerFactory(c -> {
            if (RegistrosController.class.isAssignableFrom(c)) {
                return new RegistrosController<>(controller, controller.entidade());
            }
            return null;
        });

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage novaJanela = new Stage();

        novaJanela.setScene(scene);
        novaJanela.setTitle("Registros de " + nome);
        novaJanela.setResizable(false);
        novaJanela.showAndWait();
    }
}