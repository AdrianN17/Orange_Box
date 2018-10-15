package controlador;
import interfaz.inter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import modelo.esta;
import modelo.login;
import procesos.inicio;
public class FXMLEstadisticaController implements Initializable {
    @FXML Label lb1,lb2;
    @FXML PieChart chart1;
    inter ini=new inicio();
    String user="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
        login lo=new login(user,"","");
        lb1.setText(lb1.getText()+ini.cantidaddatos(lo));
        lb2.setText(lb2.getText()+ini.cantidadtele(lo)); 
        
        ArrayList<esta> aldata =ini.estadisticas(user);
        
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            esta next = (esta)iterator.next();
            PieChart.Data pd = new PieChart.Data (next.getText(), next.getData());
            chart1.getData().add(pd);
        }
        
  
        
        
        
        
    }    
    
}
