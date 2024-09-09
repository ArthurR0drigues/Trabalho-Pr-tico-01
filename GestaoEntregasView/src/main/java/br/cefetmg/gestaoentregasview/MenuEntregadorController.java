package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.PedidoController;
import br.cefetmg.gestaoentregasentidades.entidades.Pedido;
import java.io.ObjectInputFilter.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

public class MenuEntregadorController implements Initializable {

    @FXML
    private TableView<Pedido> tableView;

    @FXML
    private TableColumn<Pedido, String> colunaData;

    @FXML
    private TableColumn<Pedido, Double> colunaValorTotal;

    @FXML
    private TableColumn<Pedido, Status> colunaEnum;

    private PedidoController pedidoController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pedidoController = new PedidoController();
        tableView.getColumns().addAll(colunaData, colunaValorTotal, colunaEnum);
        configurarColunas();
        carregarPedidosEntregues();
    }

    private void configurarColunas() {
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataPedido"));
        colunaValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        colunaEnum.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void carregarPedidosEntregues() {
        List<Pedido> pedidosEntregues = pedidoController.entregues();
        ObservableList<Pedido> observableList = FXCollections.observableArrayList(pedidosEntregues);
        tableView.setItems(observableList);
    }
}