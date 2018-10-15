package controlador;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class FXMLContrasenaController implements Initializable 
{
    @FXML WebView wb1;
    @FXML ComboBox c1;
    ArrayList<String> pag=new ArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //añadir paginas
        pag.add("http://www.passwordmeter.com/");
        pag.add("https://password.kaspersky.com/");
        pag.add("https://www.my1login.com/resources/password-strength-test/");
        pag.add("https://howsecureismypassword.net/");
        
        c1.setItems(FXCollections.observableArrayList("paswwordmeter","password.kaspersky","my1login.com","howsecureismypassword"));
    }    
    
    @FXML
    public void oncambiar(ActionEvent ev)
    {
        WebEngine we1 = wb1.getEngine();
        we1.load(pag.get(c1.getSelectionModel().getSelectedIndex()));
    }
    
}
