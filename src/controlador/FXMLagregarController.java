package controlador;
import interfaz.inter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modelo.datos;
import procesos.inicio;
public class FXMLagregarController implements Initializable {
    private static final String URL_REGEX ="^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    @FXML TextField txt1,txt2,txt4;
    @FXML PasswordField txt3;
    @FXML Label lb1;
    @FXML CheckBox ch1;
    String user="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
        txt4.managedProperty().bind(ch1.selectedProperty());
        txt4.visibleProperty().bind(ch1.selectedProperty());
        
        txt1.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txt1.getText().length() >= 100) {
                        txt1.setText(txt1.getText().substring(0, 100));
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
                    if (txt2.getText().length() >= 30) {
                        txt2.setText(txt2.getText().substring(0, 30));
                    }
                }
            }
        });
        
        txt3.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txt3.getText().length() >= 100) {
                        txt3.setText(txt3.getText().substring(0, 100));
                    }
                }
            }
        });
        
        txt4.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txt4.getText().length() >= 100) {
                        txt4.setText(txt4.getText().substring(0, 100));
                    }
                }
            }
        });
    
    }   
    @FXML
    public void onver(ActionEvent ev)
    {
        txt4.managedProperty().bind(ch1.selectedProperty());
        txt4.visibleProperty().bind(ch1.selectedProperty());

        txt3.managedProperty().bind(ch1.selectedProperty().not());
        txt3.visibleProperty().bind(ch1.selectedProperty().not());

        txt4.textProperty().bindBidirectional(txt3.textProperty());
    }
    @FXML
    public void onagregar(ActionEvent ev)
    {
        if(txt1.getText().isEmpty()==false && txt2.getText().isEmpty()==false && ((txt3.getText().isEmpty()==false && ch1.isSelected()==false) || (txt4.getText().isEmpty()==false && ch1.isSelected())))
        {
            if (urlValidator(txt1.getText()))
            {
                String tx="";
                if (ch1.isSelected())
                {
                    tx=txt4.getText();
                }
                else
                {
                    tx=txt3.getText();
                }
                
                inter in = new inicio();
                //int id, String nick, String contraseña, String url, String usuario, int count
                datos da = new datos(0,txt2.getText(),tx,txt1.getText(),user,0);
                int val=in.agregardato(da);

                if (val==0)
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
                lb1.setText("La url no es valida, se recomienda añadir al inicio http(s)");
            }
        }
        else
        {
            lb1.setText("Campos Vacios");
        }
    }
    
    public static boolean urlValidator(String url)
    {
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
}
