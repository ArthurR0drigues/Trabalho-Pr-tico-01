package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.PedidoController;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatorioController<Pedido>{
    @FXML
    private TableView<Pedido> tableView;

    private final PedidoController controller;
    private final Class<Pedido> entityClass;

    public RelatorioController(PedidoController controller, Class<Pedido> entityClass) {
        this.controller = controller;
        this.entityClass = entityClass;
    }

    @FXML
    public void initialize() {
        this.configurarColunas();
        this.carregarDados();
    }

    private void configurarColunas() {
        
        for(Field field : entityClass.getDeclaredFields()) {

            if(Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) continue;
            if(field.isAnnotationPresent(javax.persistence.ManyToOne.class) || field.isAnnotationPresent(javax.persistence.OneToMany.class)) continue;

            TableColumn<Pedido, String> coluna = new TableColumn<>(field.getName());
            coluna.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(coluna);
        }
    }

    private void carregarDados() {
        var registros = controller.consultarTodos();
        System.out.println(registros.size());
        ObservableList<Pedido> observableList = (ObservableList<Pedido>) FXCollections.observableArrayList(registros);
        tableView.setItems(observableList);
    }
}
