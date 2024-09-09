package br.cefetmg.gestaoentregasview;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import br.cefetmg.gestaoentregascontroller.*;
import br.cefetmg.gestaoentregasentidades.entidades.*;

public class FormulariosController<T> {
    
    @FXML
    private VBox form;
    
    @FXML
    private Label mensagem;

    private final EntidadeController<T> controller;
    private final Class<T> entityClass;
    
    public FormulariosController() {
        this.controller = null;
        this.entityClass = null;
    }
     
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
    public void handleSalvar() {
        try {
            T entidade = entityClass.getDeclaredConstructor().newInstance();
            preencherEntidade(entidade);
            controller.atualizar(entidade);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void handleExcluir() {
        try {
            Field idField = entityClass.getDeclaredField("id");
            idField.setAccessible(true);

            for (Node node : form.getChildren()) {
                if (node instanceof HBox) {    
                    HBox hbox = (HBox) node;
                    if (hbox.getChildren().size() < 2) {
                        continue;
                    }
                    Node firstChild = hbox.getChildren().get(0);
                    if (firstChild instanceof Label) {
                        Label label = (Label) firstChild;
                        if ("id".equals(label.getText())) { 
                            Node inputField = hbox.getChildren().get(1);
                            if (inputField instanceof TextField) {
                                TextField idFieldInput = (TextField) inputField;
                                String idText = idFieldInput.getText();
                                if (!idText.isEmpty()) {
                                    Integer id = Integer.parseInt(idText);
                                    controller.deletar(controller.consultar(id));
                                } 
                                break;
                            }
                        }
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void sairParaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");  
    }
    
    private EntidadeController<?> getControllerForEntity(Class<?> entityClass) {
        if (entityClass.equals(Cliente.class)) {
            return new ClienteController();
        } else if (entityClass.equals(Empresa.class)) {
            return new EmpresaController();   
        } else if (entityClass.equals(Funcionario.class)) {
            return new FuncionarioController();   
        } else if (entityClass.equals(ItemPedido.class)) {
            return new ItemPedidoController();   
        } else if (entityClass.equals(Pedido.class)) {
            return new PedidoController();   
        } else if (entityClass.equals(Perfil.class)) {
            return new PerfilController();   
        } else if (entityClass.equals(Produto.class)) {
            return new PedidoController();   
        }
        
        return null;  
    }

    
    private void preencherEntidade(T entidade) {
        for (Node node : form.getChildren()) {
            if (node instanceof HBox) {
                HBox hbox = (HBox) node;
                if (hbox.getChildren().size() < 2) {
                    continue;
                }

                Node firstChild = hbox.getChildren().get(0);
                if (!(firstChild instanceof Label)) {
                    continue;
                }

                Label label = (Label) firstChild;
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
                        } else if (!field.getType().isPrimitive()) {
                            int id = Integer.parseInt(text);
                            EntidadeController<?> relatedController = getControllerForEntity(field.getType());
                            if (relatedController != null) {
                                value = relatedController.consultar(id);
                            } 
                        }
                    } else if (inputField instanceof CheckBox) {
                        value = ((CheckBox) inputField).isSelected();
                    } else if (inputField instanceof ComboBox) {
                        value = ((ComboBox<?>) inputField).getValue();
                    } else if (inputField instanceof DatePicker) {
                        value = Date.from(((DatePicker) inputField).getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
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
            
            if (field.getType().equals(List.class)) {
                continue;
            }
            
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
            } else if (field.getType().equals(Date.class)) {
                DatePicker datePicker = new DatePicker();
                inputField = datePicker;
            } else {
                inputField = new TextField();
            }

            HBox fieldContainer = new HBox(10, label, inputField);
            form.getChildren().add(fieldContainer);
        }
    }
}
