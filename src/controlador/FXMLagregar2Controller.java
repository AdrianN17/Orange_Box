package controlador;
import interfaz.inter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.prefs.Preferences;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelo.tele;
import procesos.inicio;
public class FXMLagregar2Controller implements Initializable {
    @FXML TextField txt1,txt2;
    @FXML TextArea txt3;
    @FXML Label lb1;
    String user="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
        
        txt1.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txt1.getText().length() >= 50) {
                        txt1.setText(txt1.getText().substring(0, 50));
                    }
                }
            }
        });
        
        txt2.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txt2.getText().length() >= 20) {
                        txt2.setText(txt2.getText().substring(0, 20));
                    }
                }
            }
        });
        
        UnaryOperator<TextFormatter.Change> filter = change -> {
        String text = change.getText();

        if (text.matches("[0-9]*")) {
            return change;
        }

            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        txt2.setTextFormatter(textFormatter);
        
        txt3.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txt3.getText().length() >= 50) {
                        txt3.setText(txt3.getText().substring(0, 50));
                    }
                }
            }
        });
    }    
    
    @FXML
    public void onagregar(ActionEvent ev)
    {
        if(txt1.getText().isEmpty()==false && txt2.getText().isEmpty()==false && txt3.getText().isEmpty()==false)
        {
            inter in = new inicio();
            tele te= new tele(0,user,txt1.getText(),txt3.getText(),txt2.getText(),0);
            int val=in.ingresartele(te);
            
            if(val==0)
            {
                lb1.setText("Ha ocurrido un error");
            }
            else
            {
                lb1.setText("Ingresado");
                txt1.clear();
                txt2.clear();
                txt3.clear();
            }
            
            
        }
        else
        {
            lb1.setText("Campos Vacios");
        }
    }
    
}
