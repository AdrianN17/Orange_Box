package controlador;

import interfaz.inter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import modelo.datos;
import procesos.inicio;

public class FXMLimportarcuentaController implements Initializable {
    @FXML CheckBox ch1,ch2;
    @FXML Label lb1,lb2;
    String user="";
    String url="";
    inter ini=new inicio();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
    }    
    
    @FXML
    public void onbuscar(ActionEvent e)
    {
        FileChooser fileChooser = new FileChooser();
        //extensiones
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //direccion preterminada
        File userDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(userDirectory);
        //abrir
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            lb1.setText("File seleccionado: " + selectedFile.getName());
            url=selectedFile.getPath();
        }
        else {
            lb1.setText("File no seleccionado.");
        }
    }
    
    @FXML
    public void oncargar(ActionEvent e)
    {
        if(url.isEmpty()==false)
        {
            if(ch1.isSelected())
            {
                cargartxtencriptado();
            }
            else
            {
                cargartxt();
            }
            
            if(ch2.isSelected())
            {
                borrartxt();
            }  
        }
        else
        {
            lb2.setText("Seleccione archivo");
        }
    }
    
    public void cargartxt()
    {
        FileReader leer=null;
	BufferedReader entrada=null;
        try
        {
            
            String dato;
            String[] cortes;
            leer=new  FileReader(url);
            entrada=new BufferedReader(leer);
            while((dato = entrada.readLine())!=null) 
            {
                cortes=dato.split("---");
                datos da=new datos(0,cortes[0],cortes[1],cortes[2],user,0);
                ini.agregardato(da);
            }
            lb2.setText("Datos agregados");
        } 
        catch (Exception e) 
        {
            lb2.setText("Error con el archivo");
        } 
        finally 
        {
           try 
           {
           if (null != leer)
              leer.close();
           } 
           catch (Exception e2) 
           {
              e2.printStackTrace();
           }
        }   	
    }
    
    public void cargartxtencriptado()
    {
        FileReader leer=null;
	BufferedReader entrada=null;
        try
        {
            
            String dato;
            String[] cortes;
            leer=new  FileReader(url);
            entrada=new BufferedReader(leer);
            while((dato = entrada.readLine())!=null) 
            {
                cortes=dato.split("---");
                datos da=new datos(0,cortes[0],cortes[1],cortes[2],user,0);
                ini.agregardatoen(da);
            }
            lb2.setText("Datos agregados");
        } 
        catch (Exception e) 
        {
            lb2.setText("Error con el archivo");
        } 
        finally 
        {
           try 
           {
           if (null != leer)
              leer.close();
           } 
           catch (Exception e2) 
           {
              e2.printStackTrace();
           }
        }   	
    }
    
    public void borrartxt()
    {
        File fichero = new File(url);
        if (fichero.delete())
        {
            lb1.setText(lb1.getText()+" y txt borrado");
        }
    }
    
    
    
}
