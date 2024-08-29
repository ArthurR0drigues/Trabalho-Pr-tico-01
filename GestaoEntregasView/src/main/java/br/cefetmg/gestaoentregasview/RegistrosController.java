package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.EntidadeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class RegistrosController<T> {

    @FXML
    private TableView<T> tableView;

    private final EntidadeController<T> controller;
    private final Class<T> entityClass;

    public RegistrosController(EntidadeController<T> controller, Class<T> entityClass) {
        this.controller = controller;
        this.entityClass = entityClass;
    }

    @FXML
    public void initialize() {
        configurarColunas();
        carregarDados();
    }

    private void configurarColunas() {
        
        for(Field field : entityClass.getDeclaredFields()) {

            if(Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) continue;
            if(field.isAnnotationPresent(javax.persistence.ManyToOne.class) || field.isAnnotationPresent(javax.persistence.OneToMany.class)) continue;

            TableColumn<T, String> coluna = new TableColumn<>(field.getName());
            coluna.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(coluna);
        }
    }

    private void carregarDados() {
        List<T> registros = controller.consultarTodos();
        System.out.println(registros.size());
        ObservableList<T> observableList = FXCollections.observableArrayList(registros);
        tableView.setItems(observableList);
    }
}
