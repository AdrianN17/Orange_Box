package controlador;
import interfaz.inter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.datos;
import procesos.inicio;
public class FXMLeditarController implements Initializable {
    private static final String URL_REGEX ="^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    @FXML Button b1,b2,b3;
    @FXML ComboBox combolista;
    @FXML TextField txt1,txt2,txt4;
    @FXML PasswordField txt3;
    ArrayList<datos> aldata;
    @FXML CheckBox ch1;
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
        
        datos daa = new datos(0,"","","",user,0);
        
        aldata=in.getdatos(daa);
        
        ArrayList<String> ocombo=new ArrayList();
        
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            datos next = (datos)iterator.next();
                ocombo.add("N° "+next.getCount());
            }

        combolista.setItems(FXCollections.observableArrayList(ocombo));
        
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
    public void oncombolista(ActionEvent ev)
    {
        for(Iterator iterator = aldata.iterator(); iterator.hasNext();){
            datos next = (datos)iterator.next();
            if(combolista.getValue().equals("N° "+next.getCount()))
            {
                txt1.setText(next.getUrl());
                txt2.setText(next.getNick());
                txt3.setText(next.getContraseña());
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
        txt4.setEditable(chan[2]);
    }
 
    
    @FXML 
    public void oneditar(ActionEvent ev)
    {
        if( txt1.getText().isEmpty()==false && txt2.getText().isEmpty()==false && ((txt3.getText().isEmpty()==false && ch1.isSelected()==false) || (txt4.getText().isEmpty()==false && ch1.isSelected())))
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
                datos daa = new datos(idselected,txt2.getText(),tx,txt1.getText(),user,0);

                int val=in.editardatos(daa);

                if(val==0)
                {
                    lb1.setText("Ha ocurrido un error");
                }
                else
                {
                    
                    lb1.setText("Editado");
                    txt1.setEditable(false);
                    txt2.setEditable(false);
                    txt3.setEditable(false);
                    txt4.setEditable(false);
                    b1.setText("Desbloqueado");
                    b2.setText("Desbloqueado");
                    b3.setText("Desbloqueado");
                    
                    restart();
                    txt1.clear();
                    txt2.clear();
                    txt3.clear();
                    txt4.clear();
                }   
            }
            else
            {
                lb1.setText("La url no es valida, se recomienda añadir al inicio http(s)");
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
        if( txt1.getText().isEmpty()==false && txt2.getText().isEmpty()==false)
        {
            inter in = new inicio();
            
            datos daa = new datos(idselected,txt2.getText(),"",txt1.getText(),user,0);
            
            int val=in.eliminardato(daa);
            
            if(val==0)
            {
                lb1.setText("Ha ocurrido un error");              
            }
            else
            {
                lb1.setText("Eliminado");
                txt1.setEditable(false);
                txt2.setEditable(false);
                txt3.setEditable(false);
                txt4.setEditable(false);
                b1.setText("Desbloqueado");
                b2.setText("Desbloqueado");
                b3.setText("Desbloqueado");
                restart();
                txt1.clear();
                txt2.clear();
                txt3.clear();
                txt4.clear();
                ch1.selectedProperty().not();
                
            }
        }
        else
        {
            lb1.setText("Campos Vacios");
        }
    }
    
    @FXML 
    public void onver(ActionEvent ev)
    {
        txt4.managedProperty().bind(ch1.selectedProperty());
        txt4.visibleProperty().bind(ch1.selectedProperty());

        txt3.managedProperty().bind(ch1.selectedProperty().not());
        txt3.visibleProperty().bind(ch1.selectedProperty().not());

        // Bind the textField and passwordField text values bidirectionally.
        txt4.textProperty().bindBidirectional(txt3.textProperty());
        
        //System.out.println(""+ch1.isSelected());
    }
    
    public void restart()
    {
        idselected=0;
        aldata.clear();
        combolista.getItems().clear();
        
        Preferences userPreferences = Preferences.userRoot();
        String user=userPreferences.get("user", "");
        
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
    
    public static boolean urlValidator(String url)
    {
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
}
