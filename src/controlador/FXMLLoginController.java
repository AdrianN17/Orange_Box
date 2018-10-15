package controlador;
import interfaz.inter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import java.util.stream.IntStream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelo.login;
import procesos.inicio;

public class FXMLLoginController implements Initializable {
    @FXML Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ingresar;
    @FXML TextField txtusuario;
    @FXML PasswordField txtcontraseña,txtcontraseña2;
    int[] numerosAleatorios;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        txtcontraseña2.setDisable(true);
        
        numerosAleatorios = IntStream.rangeClosed(0, 9).toArray();
        Random r = new Random();
        for (int i = numerosAleatorios.length; i > 0; i--) {
            int posicion = r.nextInt(i);
            int tmp = numerosAleatorios[i-1];
            numerosAleatorios[i - 1] = numerosAleatorios[posicion];
            numerosAleatorios[posicion] = tmp;
        }
        
        b1.setText(numerosAleatorios[1]+"");
        b2.setText(numerosAleatorios[2]+"");
        b3.setText(numerosAleatorios[3]+"");
        b4.setText(numerosAleatorios[4]+"");
        b5.setText(numerosAleatorios[5]+"");
        b6.setText(numerosAleatorios[6]+"");
        b7.setText(numerosAleatorios[7]+"");
        b8.setText(numerosAleatorios[8]+"");
        b9.setText(numerosAleatorios[9]+"");
        b0.setText(numerosAleatorios[0]+"");
        
        
        txtusuario.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txtusuario.getText().length() >= 30) {
                        txtusuario.setText(txtusuario.getText().substring(0, 30));
                    }
                }
            }
        });
        
        txtcontraseña.lengthProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    if (txtcontraseña.getText().length() >= 30) {
                        txtcontraseña.setText(txtcontraseña.getText().substring(0, 30));
                    }
                }
            }
        });
    }    
    
    @FXML
    private void onb1(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[1]);
        }
        
    }
    
    @FXML
    private void onb2(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[2]);
        }
    }
    
    @FXML
    private void onb3(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[3]);
        }
    }
    
    @FXML
    private void onb4(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[4]);
        }
    }
    
    @FXML
    private void onb5(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[5]);
        }
    }
    
    @FXML
    private void onb6(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[6]);
        }
    }
    
    @FXML
    private void onb7(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[7]);
        }
    }
    
    @FXML
    private void onb8(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[8]);
        }
    }
    
    @FXML
    private void onb9(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[9]);
        }
    }
    
    @FXML
    private void onb0(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()<10)
        {
            txtcontraseña2.setText(txtcontraseña2.getText()+numerosAleatorios[0]);
        }
    }
    
    @FXML
    private void oningresar(ActionEvent ev)
    {
        if(txtusuario.getText().isEmpty()==false && txtcontraseña.getText().isEmpty()==false && txtcontraseña2.getText().isEmpty()==false)
        {
            inter in = new inicio();

            login lo = new login(txtusuario.getText(),txtcontraseña.getText(),txtcontraseña2.getText());

            login lov=in.ingreso(lo);

            if(lov==null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Intente nuevamente", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.setTitle("Usuario no encontrado");
                ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/imagen/icono.png"));
                alert.showAndWait();
            }
            else
            {

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/vistas/FXMLAplicacion.fxml"));
                try
                {
                    Parent root1 = (Parent) Loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.setTitle("Orange_Box");
                    stage.getIcons().add(new Image("/imagen/icono.png"));
                    stage.sizeToScene();
                    stage.show();
                }
                catch(IOException ex)
                {
                    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Preferences userPreferences = Preferences.userRoot();
                userPreferences.put("user",lov.getId());


                Stage stage = (Stage) ingresar.getScene().getWindow();
                stage.close();


            }        
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Ingrese datos", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Campos Vacios");
            ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/imagen/icono.png"));
            alert.showAndWait();
        }
    }
    
    @FXML
    private void onregistro(ActionEvent ev)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vistas/FXMLRegistro.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.setTitle("Orange_Box");
            stage.getIcons().add(new Image("/imagen/icono.png"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    
    private void onborrar(ActionEvent ev)
    {
        if(txtcontraseña2.getText().length()!=0){
            txtcontraseña2.setText(txtcontraseña2.getText().substring(0, txtcontraseña2.getText().length()-1));
        }
    }
    
    
    
    
    
    
}
