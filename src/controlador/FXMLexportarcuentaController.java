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
import modelo.datos;
import modelo.login;
import procesos.inicio;

public class FXMLexportarcuentaController implements Initializable {
    @FXML CheckBox ch1,ch2;
    @FXML Label lb1;
    
    inter ini=new inicio();
    String user="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
    }    
    
    @FXML
    public void onexportar(ActionEvent e)
    {
        directorio();
        
        if(ch2.isSelected())// datos encriptados
        {
            getedata();
        }
        else
        {
            getdata();
        }
        
        if(ch1.isSelected())//eliminar datos
        {
            login lo=new login(user,"","");
            ini.borrartodo(lo);
        }
        
        
    }
    
    public void getdata()
    {
        datos da=new datos(0,"","","",user,0);
        ArrayList lista=ini.getdatos(da);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(user+"_data.txt");
            pw = new PrintWriter(fichero);
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                datos next = (datos)iterator.next();
                pw.println(next.getNick()+"---"+next.getContraseña()+"---"+next.getUrl());
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
    
    public void getedata()
    {
        datos da=new datos(0,"","","",user,0);
        ArrayList lista=ini.getdatosen(da);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("cuentas/"+user+"_data_encriptado.txt");
            pw = new PrintWriter(fichero);
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                datos next = (datos)iterator.next();
                pw.println(next.getNick()+"---"+next.getContraseña()+"---"+next.getUrl());
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
        new File("cuentas").mkdir();
    }
    
}
