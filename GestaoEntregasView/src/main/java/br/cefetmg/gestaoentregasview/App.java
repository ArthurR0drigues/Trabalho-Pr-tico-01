package br.cefetmg.gestaoentregasview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
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

    /**
     * Método estático que abre uma nova janela.
     * @param titulo (titulo da janela)
     * @param fxml (nome do arquivo fxml)
     * @param largura (em pixels)
     * @param altura (em pixels)
     * @throws IOException
     */
    public static void abrirNovaJanela(String titulo, String fxml, int largura, int altura) throws IOException {
        Parent root = loadFXML(fxml);
        Stage novaJanela = new Stage();
        novaJanela.setTitle(titulo);
        novaJanela.setScene(new Scene(root, largura, altura));
        novaJanela.showAndWait();
    }
}