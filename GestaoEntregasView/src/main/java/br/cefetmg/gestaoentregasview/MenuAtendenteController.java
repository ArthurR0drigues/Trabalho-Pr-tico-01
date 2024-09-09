package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.Node;
import javafx.stage.Window;

public class MenuAtendenteController {
    @FXML
    private void rcliente(ActionEvent event) throws IOException {
        App.abrirRegistros("Registros de cliente", new ClienteController());
    }
    
    @FXML
    private void fcliente(ActionEvent event) throws IOException {
        App.abrirFormulario("Formulario de cliente", new ClienteController());
    }
    
    @FXML
    private void ritemPedido(ActionEvent event) throws IOException {
        App.abrirRegistros("Registros de itemPedido", new ItemPedidoController());
    }
    
    @FXML
    private void fitemPedido(ActionEvent event) throws IOException {
        App.abrirFormulario("Formulario de itemPedido", new ItemPedidoController());
    }
    
    @FXML
    private void rpedido(ActionEvent event) throws IOException {
        App.abrirRegistros("Registros de pedido", new PedidoController());
    }
    
    @FXML
    private void fpedido(ActionEvent event) throws IOException {
        App.abrirFormulario("Formulario de pedido", new PedidoController());
    }
    
    @FXML
    private void rproduto(ActionEvent event) throws IOException {
        App.abrirRegistros("Registros de produto", new ProdutoController());
    }
    
    @FXML
    private void fproduto(ActionEvent event) throws IOException {
        App.abrirFormulario("Formulario de produto", new ProdutoController());
    }
    
    @FXML
    private void irParaRelatorios(ActionEvent event) throws IOException {
         
    }

    @FXML
    public void sairParaLogin(ActionEvent event) throws IOException {
        Window window = ((Node) event.getSource()).getScene().getWindow();
        window.hide();
    }
}
