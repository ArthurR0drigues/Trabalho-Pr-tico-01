package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.EntidadeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/cefetmg/gestaoentregasview/telaLogin.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.setResizable(false);
        stage.show();
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
    
    public static void abrirJanela(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage novaJanela = new Stage();
        novaJanela.setScene(scene);
        novaJanela.setResizable(false);
        novaJanela.show();
    }

    public static void abrirRegistros(String titulo, EntidadeController controller) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(App.class.getResource("registros.fxml"));

        loader.setControllerFactory(c -> {
            if(RegistrosController.class.isAssignableFrom(c)) {
                return new RegistrosController<>(controller, controller.entidade());
            }
            return null;
        });

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage novaJanela = new Stage();

        novaJanela.setScene(scene);
        novaJanela.setTitle(titulo);
        novaJanela.setResizable(false);
        novaJanela.show();
    }
    
    public static void abrirFormulario(String titulo, EntidadeController controller) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(App.class.getResource("formularios.fxml"));

        loader.setControllerFactory(c -> {
            if(FormulariosController.class.isAssignableFrom(c)) {
                return new FormulariosController<>(controller, controller.entidade());
            }
            return null;
        });

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage novaJanela = new Stage();

        novaJanela.setScene(scene);
        novaJanela.setTitle(titulo);
        novaJanela.setResizable(false);
        novaJanela.show();
    }
}