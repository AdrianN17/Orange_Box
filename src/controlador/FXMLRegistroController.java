package controlador;
import interfaz.inter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelo.login;
import procesos.inicio;

public class FXMLRegistroController implements Initializable {
    @FXML Button registro;
    @FXML TextField txtusu;
    @FXML PasswordField txtpass, txtpass2, txtpass3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtusu.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txtusu.getText().length() >= 30) {
                        txtusu.setText(txtusu.getText().substring(0, 30));
                    }
                }
            }
        });
        
        txtpass.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txtpass.getText().length() >= 30) {
                        txtpass.setText(txtpass.getText().substring(0, 30));
                    }
                }
            }
        });
        
        txtpass2.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txtpass2.getText().length() >= 30) {
                        txtpass2.setText(txtpass2.getText().substring(0, 30));
                    }
                }
            }
        });
        
        txtpass3.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txtpass3.getText().length() >= 10) {
                        txtpass3.setText(txtpass3.getText().substring(0, 10));
                    }
                }
            }
        });
        UnaryOperator<Change> filter = change -> {
        String text = change.getText();

        if (text.matches("[0-9]*")) {
            return change;
        }

            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        txtpass3.setTextFormatter(textFormatter);
        
        
    }    
    
    @FXML
    private void onregistro(ActionEvent ev)
    {
        if(txtusu.getText().isEmpty()==false && txtpass.getText().isEmpty()==false && txtpass2.getText().isEmpty()==false && txtpass3.getText().isEmpty()==false)
        {
            if(txtpass.getText().equals(txtpass2.getText()))
            {
                inter in = new inicio();
                
                login lo = new login(txtusu.getText(), txtpass.getText(), txtpass3.getText());
                
                int val=in.registro(lo);
                
                if(val==0)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Error al registrarse", ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.setTitle("Ha ocurrido un error, intentelo nuevamente");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/imagen/icono.png"));
                    alert.showAndWait();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Registrado", ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.setTitle("Registro Realizado");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/imagen/icono.png"));
                    alert.showAndWait();
                    
                    
                    
                    Stage stage = (Stage) registro.getScene().getWindow();
                    stage.close();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Error Contraseñas", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.setTitle("Las contraseñas no son iguales");
                ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/imagen/icono.png"));
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Ingrese datos", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Campos Vacios");
            ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/imagen/icono.png"));
            alert.showAndWait();
        }
    }
    
}
