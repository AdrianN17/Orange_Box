package controlador;
import interfaz.inter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import modelo.login;
import modelo.tele;
import procesos.inicio;
public class FXMLexportarteleController implements Initializable {
    @FXML CheckBox ch1;
    @FXML Label lb1;
    inter ini=new inicio();
    String user="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
    } 
    
    @FXML
    public void onexportar(ActionEvent ev)
    {
        directorio();
        devolvertele();
        
                
        if(ch1.isSelected())
        {
            login lo=new login(user,"","");
            ini.borrarteletotal(lo);
        }
    }
    
    public void devolvertele()
    {   
        tele te = new tele(0,user,"","","",0);
        ArrayList lista=ini.gettelefono(te);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("telefonos/"+user+"_Telefono.txt");
            pw = new PrintWriter(fichero);
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                tele next = (tele)iterator.next();
                pw.println(next.getContacto()+"---"+next.getTelefono()+"---"+next.getDetalle());
            }  
            lb1.setText("Archivo creado");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
           try 
           {
           if (null != fichero)
              fichero.close();
           } 
           catch (Exception e2) 
           {
              e2.printStackTrace();
           }
        }
    }
    
    public void directorio()
    {
        new File("telefonos").mkdir();
    }
}
