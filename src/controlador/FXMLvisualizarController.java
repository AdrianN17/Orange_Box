package controlador;
import interfaz.inter;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.datos;
import procesos.inicio;

public class FXMLvisualizarController implements Initializable {

    @FXML ComboBox combolista;
    @FXML TextField txt1,txt2;
    @FXML PasswordField txt3;
    @FXML Label lb1;
    ArrayList<datos> aldata;
    String user="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
        
        inter in = new inicio();
        
        datos daa = new datos(0,"","","",user,0);
        
        aldata=in.getdatos(daa);
        
        ArrayList<String> ocombo=new ArrayList();
        
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            datos next = (datos)iterator.next();
                ocombo.add("N° "+next.getCount());
            }

        combolista.setItems(FXCollections.observableArrayList(ocombo));  
    }
    
    @FXML
    public void oncombolista(ActionEvent ev)
    {
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            datos next = (datos)iterator.next();
            if(combolista.getValue().equals("N° "+next.getCount()))
            {
                txt1.setText(next.getUrl());
                txt2.setText(next.getNick());
                txt3.setText(next.getContraseña());
            }
        }
    }
    
    @FXML
    public void onabrir(ActionEvent ev)
    {
        try
        {
            Desktop.getDesktop().browse(new URI(txt1.getText()));
        }
        catch(Exception e)
        {
            lb1.setText("Ha ocurrido un error");
        }
    }
    
    @FXML
    public void oncopiar(ActionEvent ev)
    {
        StringSelection stringSelection = new StringSelection (txt2.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
        lb1.setText("Usuario copiado");
    }
    
    @FXML
    public void oncopiar2(ActionEvent ev)
    {
        StringSelection stringSelection = new StringSelection (txt3.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
        lb1.setText("Contraseña copiada");
    }
    

    
}
