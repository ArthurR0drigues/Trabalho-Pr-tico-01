package br.cefetmg.gestaoentregasview;

import br.cefetmg.gestaoentregascontroller.EntidadeController;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class FormulariosController<T> {
    
    @FXML
    private VBox form;
    
    @FXML
    private Label mensagem;

    private final EntidadeController<T> controller;
    private final Class<T> entityClass;

    public FormulariosController(EntidadeController<T> controller, Class<T> entityClass) {
        this.controller = controller;
        this.entityClass = entityClass;
    }
    
    @FXML
    public void initialize() {
        this.configurarCampos();
        this.mensagem.setText(this.entityClass.getSimpleName());
    }
    
    @FXML
    public void handleAdicionar() {
        try {
            T entidade = entityClass.getDeclaredConstructor().newInstance();
            preencherEntidade(entidade);
            controller.salvar(entidade);
            System.out.println("Entidade adicionada com sucesso!");
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Erro ao adicionar entidade: " + e.getMessage());
        }
    }

    @FXML
    public void handleSalvar() {
        try {
            T entidade = entityClass.getDeclaredConstructor().newInstance();
            preencherEntidade(entidade);
            controller.atualizar(entidade);
            System.out.println("Entidade salva com sucesso!");
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Erro ao salvar entidade: " + e.getMessage());
        }
    }

    @FXML
    public void handleExcluir() {
        try {
            T entidade = entityClass.getDeclaredConstructor().newInstance();
            preencherEntidade(entidade);
            controller.deletar(entidade);
            System.out.println("Entidade excluída com sucesso!");
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Erro ao excluir entidade: " + e.getMessage());
        }
    }

    private void preencherEntidade(T entidade) {
        for (Node node : form.getChildren()) {
            if (node instanceof HBox) {
                HBox hbox = (HBox) node;
                Label label = (Label) hbox.getChildren().get(0);
                Node inputField = hbox.getChildren().get(1);
                String fieldName = label.getText();
                Field field;
                try {
                    field = entityClass.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    Object value = null;
                    if (inputField instanceof TextField) {
                        String text = ((TextField) inputField).getText();
                        if (field.getType().equals(String.class)) {
                            value = text;
                        } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                            value = Integer.parseInt(text);
                        } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                            value = Double.parseDouble(text);
                        }
                    } else if (inputField instanceof CheckBox) {
                        value = ((CheckBox) inputField).isSelected();
                    } else if (inputField instanceof ComboBox) {
                        value = ((ComboBox<?>) inputField).getValue();
                    }
                    
                    field.set(entidade, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void configurarCampos() {
        
        for(Field field : entityClass.getDeclaredFields()) {
            
            Label label = new Label(field.getName());
            Node inputField;

            if (field.getType().equals(String.class)) {
                inputField = new TextField();
            } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                inputField = new TextField();
                ((TextField) inputField).setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                inputField = new TextField();
                ((TextField) inputField).setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));
            } else if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
                inputField = new CheckBox();
            } else if (field.getType().isEnum()) {
                ComboBox<Enum<?>> comboBox = new ComboBox<>();
                comboBox.getItems().addAll((Enum<?>[]) field.getType().getEnumConstants());
                inputField = comboBox;
            } else {
                inputField = new TextField();  // Default para outros tipos
            }

            HBox fieldContainer = new HBox(10, label, inputField);
            form.getChildren().add(fieldContainer);
        }
    }
}
