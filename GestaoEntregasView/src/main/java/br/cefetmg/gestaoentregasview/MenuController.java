package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.*;
import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.lang.Class;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
    public void alternarPagina(String titleF, String titleR, EntidadeController controller) throws IOException{
        App.abrirFormulario(titleF, controller);
        App.abrirRegistros(titleR, controller);
    }
    
    
    @FXML
    private void irParaFuncionarios(ActionEvent event) throws IOException {
        FuncionarioController funcionarioController = new FuncionarioController();
        alternarPagina("Formulário de Funcionários", "Registro de Funcionários", funcionarioController);
    }

    @FXML
    private void irParaClientes(ActionEvent event) throws IOException {
        ClienteController clienteController = new ClienteController();
        alternarPagina("Formulário de Clientes", "Registro de Clientes", clienteController);
    }

    @FXML
    private void irParaPedidos(ActionEvent event) throws IOException {
        PedidoController pedidoController = new PedidoController();
        alternarPagina("Formulário de Pedidos", "Registro de Pedidos", pedidoController);
    }

    @FXML
    private void irParaProdutos(ActionEvent event) throws IOException {
        ProdutoController produtoController = new ProdutoController();
        alternarPagina("Formulário de Produtos", "Registro de Produtos", produtoController);
    }

    @FXML
    private void irParaRelatorios(ActionEvent event) throws IOException {
         App.setRoot("relatorio"); 
    }

    @FXML
    public void sairParaLogin(ActionEvent event) throws IOException {
        App.setRoot("telaLogin");  
    }
}
