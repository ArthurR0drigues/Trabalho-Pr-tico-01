package br.cefetmg.gestaoentregasview;

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

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, DAOException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        DAO<Empresa> teste = new DAO<Empresa>(Empresa.class, "persistence");
        Empresa novo = new Empresa(1, "snacksmart", "cnpjoto", "123456789-11", 0.1, funcionarios, clientes);
        teste.salvar(novo);
        System.out.println(teste.consultar(1).getNome());
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