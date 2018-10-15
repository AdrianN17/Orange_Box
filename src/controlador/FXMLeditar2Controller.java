package controlador;
import interfaz.inter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.prefs.Preferences;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import modelo.tele;
import procesos.inicio;
public class FXMLeditar2Controller implements Initializable {
    @FXML Button b1,b2,b3;
    @FXML ComboBox combolista;
    @FXML TextField txt1,txt2;
    @FXML TextArea txt3;
    ArrayList<tele> aldata;
    @FXML Label lb1;
    String user="";
    int idselected=0;
    
    String text[]={"Bloqueado","Desbloqueado"};
    int change[]={1,1,1};
    boolean chan[]={false,false,false};
    
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
    public void oncombolista(ActionEvent ev)
    {
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            tele next = (tele)iterator.next();
            if(combolista.getValue().equals("N° "+next.getCount()))
            {
                txt1.setText(next.getContacto());
                txt2.setText(next.getTelefono());
                txt3.setText(next.getDetalle());
                idselected=next.getId();
            }
        }
    }
    
    @FXML
    public void ondesbloquear(ActionEvent ev)
    {
        if(change[0]==0)
        {
            change[0]=1;
            b1.setText(text[change[0]]);
        }
        else
        {
            change[0]=0;
            b1.setText(text[change[0]]);
        }
        chan[0]=!chan[0];
        txt1.setEditable(chan[0]);
    }
    
    @FXML
    public void ondesbloquear2(ActionEvent ev)
    {
        if(change[1]==0)
        {
            change[1]=1;
            b2.setText(text[change[1]]);
        }
        else
        {
            change[1]=0;
            b2.setText(text[change[1]]);
        }
        chan[1]=!chan[1];
        txt2.setEditable(chan[1]);
    }
    
    @FXML
    public void ondesbloquear3(ActionEvent ev)
    {
        if(change[2]==0)
        {
            change[2]=1;
            b3.setText(text[change[2]]);
        }
        else
        {
            change[2]=0;
            b3.setText(text[change[2]]);
        }
        chan[2]=!chan[2];
        txt3.setEditable(chan[2]);
    }
    
    @FXML
    public void oneditar(ActionEvent ev)
    {
        if(txt1.getText().isEmpty()==false && txt2.getText().isEmpty()==false)
        {
            inter in = new inicio();
            
            tele te=new tele(idselected,user,txt1.getText(),txt3.getText(),txt2.getText(),0);
            
            int val=in.editartele(te);
            
            if(val==0)
            {
                lb1.setText("Ha ocurrido un error");
            }
            else
            {
                txt1.setEditable(false);
                txt2.setEditable(false);
                txt3.setEditable(false);
                b1.setText("Desbloqueado");
                b2.setText("Desbloqueado");
                b3.setText("Desbloqueado");
                
                lb1.setText("Editado");
                restart();
                txt1.clear();
                txt2.clear();
                txt3.clear();
            }
                    
        }
        else
        {
            lb1.setText("Campos Vacios o no editados");
        }
    }
    
    @FXML
    public void oneliminar(ActionEvent ev)
    {
        if(txt1.getText().isEmpty()==false && txt2.getText().isEmpty()==false)
        {
            inter in = new inicio();
            
            tele te=new tele(idselected,user,txt1.getText(),"",txt2.getText(),0);
            
            int val= in.eliminartele(te);
            
            if(val==0)
            {
                lb1.setText("Ha ocurrido un error");
            }
            else
            {
                txt1.setEditable(false);
                txt2.setEditable(false);
                txt3.setEditable(false);
                b1.setText("Desbloqueado");
                b2.setText("Desbloqueado");
                b3.setText("Desbloqueado");
                lb1.setText("Eliminado");
                restart();
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
    
    public void restart()
    {
        idselected=0;
        aldata.clear();
        combolista.getItems().clear();
        
        Preferences userPreferences = Preferences.userRoot();
        String user=userPreferences.get("user", "");
        
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
    
}
