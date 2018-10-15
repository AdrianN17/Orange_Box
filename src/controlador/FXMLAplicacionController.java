package controlador;
import interfaz.inter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import modelo.login;
import procesos.inicio;

public class FXMLAplicacionController implements Initializable {
    @FXML Label lbid;
    @FXML Pane main, actualpane;
    inter in=new inicio();
    String user="";
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        Preferences userPreferences = Preferences.userRoot();
        user=userPreferences.get("user", "");
    }    
    
    public void onvaciar(ActionEvent ev)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION); alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Vaciar datos");
        alert.setHeaderText("Desea eliminar datos almacenados?");
        alert.setContentText("Elija opcion a eliminar");

        ButtonType b1 = new ButtonType("Eliminar cuentas almacenadas");
        ButtonType b2 = new ButtonType("Eliminar telefonos almacenados");
        ButtonType b3 = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(b1, b2, b3);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == b1){
            login lo=new login(user,"","");
            in.borrartodo(lo);
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Hecho");
            alert1.setHeaderText(null);
            alert1.setContentText("Se ha realizado con exito el borrado de cuenta");

            alert1.showAndWait();
        } else if (result.get() == b2){
            login lo=new login(user,"","");
            in.borrarteletotal(lo);
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Hecho");
            alert1.setHeaderText(null);
            alert1.setContentText("Se ha realizado con exito el borrado de telefonos");

            alert1.showAndWait();
        }
    }
    
    public void onbaja(ActionEvent ev)
    {
        Alert alert = new     Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");

        alert.setHeaderText("Borrar usuario y datos almacenados");
        alert.setContentText("Desea eliminar sus datos actuales?");

        Optional<ButtonType> result =     alert.showAndWait();
        if (result.get() == ButtonType.OK){
            login lo=new login(user,"","");
            in.borrartodo(lo);
            in.borrarteletotal(lo);
            in.eliminarcuenta(lo);
            
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Hecho");
            alert1.setHeaderText(null);
            alert1.setContentText("Se ha realizado con exito el borrado de usuario");

            alert1.showAndWait();
            
            Platform.exit();
        } else {
        
        }
    }
    
    public void onvisualizar(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLvisualizar.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void onañadir(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLagregar.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }    
            
    }
    
    
    public void onmodificar(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLeditar.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void onvisualizar2(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLvisualizar2.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void onañadir2(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLagregar2.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    
    public void onmodificar2(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLeditar2.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    
    public void onexportar(ActionEvent ev)     
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLexportarcuenta.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    
    public void onimportar(ActionEvent ev)     
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLimportarcuenta.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void onexportar2(ActionEvent ev)     
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLexportartele.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    
    public void onimportar2(ActionEvent ev)     
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLimportartele.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void onestadistica(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLEstadistica.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void onacerca(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLAcerca.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    
    public void oncontraseña(ActionEvent ev)
    {
        try
        {
            actualpane=null;
            actualpane = FXMLLoader.load(getClass().getResource("/vistas/FXMLContrasena.fxml"));
            actualpane.setLayoutX(0);
            actualpane.setLayoutY(25);
            main.getChildren().add(actualpane);
        } catch (IOException ex) {
            System.out.println(""+ex.getLocalizedMessage());
        }
    }
    public void onsalir(ActionEvent ev)
    {
        Platform.exit();
    }
    
    
    
}
