package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.PedidoController;
import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import br.cefetmg.gestaoentregascontroller.outros.Comissao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RelatorioController implements Initializable {

    @FXML
    private DatePicker dataInicio;

    @FXML
    private DatePicker dataFim;

    @FXML
    private Button botaoGerarRelatorio;

    private PedidoController pedidoController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pedidoController = new PedidoController();
    }

    @FXML
    private void gerarRelatorio() {
        LocalDate dataInicioSelecionada = dataInicio.getValue();
        LocalDate dataFimSelecionada = dataFim.getValue();

        if (dataInicioSelecionada != null && dataFimSelecionada != null) {
            Map<Funcionario, Map<LocalDate, Double>> comissoes = pedidoController.gerarRelatorio(dataInicioSelecionada, dataFimSelecionada);
            abrirJanelaComissao(comissoes);
        } else {
            System.out.println("Selecione as datas corretamente");
        }
    }
    
    private void abrirJanelaComissao(Map<Funcionario, Map<LocalDate, Double>> comissoes) {
        
        Stage stage = new Stage();
        stage.setTitle("Comissão por Vendedor por Dia");

        TableView<Comissao> tableView = new TableView<>();
        tableView.setEditable(false);

        TableColumn<Comissao, String> colunaFuncionario = new TableColumn<>("Funcionário");
        colunaFuncionario.setCellValueFactory(new PropertyValueFactory<>("funcionario"));

        TableColumn<Comissao, LocalDate> colunaData = new TableColumn<>("Data");
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));

        TableColumn<Comissao, Double> colunaComissao = new TableColumn<>("Comissão");
        colunaComissao.setCellValueFactory(new PropertyValueFactory<>("comissao"));

        tableView.getColumns().addAll(colunaFuncionario, colunaData, colunaComissao);

        ObservableList<Comissao> observableList = FXCollections.observableArrayList();

        for (Funcionario funcionario : comissoes.keySet()) {
            for (LocalDate data : comissoes.get(funcionario).keySet()) {
                observableList.add(new Comissao(funcionario.getNome(), data, comissoes.get(funcionario).get(data)));
            }
        }

        tableView.setItems(observableList);

        Scene scene = new Scene(tableView, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}