package controlador;
import interfaz.inter;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.tele;
import procesos.inicio;
public class FXMLvisualizar2Controller implements Initializable {
    @FXML ComboBox combolista;
    @FXML TextField txt1,txt2;
    @FXML TextArea txt3;
    @FXML Label lb1;
    ArrayList<tele> aldata;
    String user="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
        
        inter in = new inicio();
        tele te= new tele(0,user,"","","",0);
        aldata=in.gettelefono(te);
        
        ArrayList<String> ocombo=new ArrayList();
        
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            tele next = (tele)iterator.next();
                ocombo.add("N° "+next.getCount());
            }

        combolista.setItems(FXCollections.observableArrayList(ocombo));
    }    
    
    @FXML
    public void oncambiar(ActionEvent ev)
    {
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            tele next = (tele)iterator.next();
            if(combolista.getValue().equals("N° "+next.getCount()))
            {
                txt1.setText(next.getContacto());
                txt2.setText(next.getTelefono());
                txt3.setText(next.getDetalle());
            }
        }
    }
    
    @FXML
    public void oncopiar(ActionEvent ev)
    {
        StringSelection stringSelection = new StringSelection (txt1.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
        lb1.setText("Contacto copiado");
    }
    
    @FXML
    public void oncopiar2(ActionEvent ev)
    {
        StringSelection stringSelection = new StringSelection (txt2.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
        lb1.setText("Telefono copiado");
    }
    
}
