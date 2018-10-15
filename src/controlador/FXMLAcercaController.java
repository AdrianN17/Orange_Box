package controlador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
public class FXMLAcercaController implements Initializable {
    @FXML TextArea txt1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt1.appendText("Sobre el aplicativo : \nEl aplicativo se encarga de guardar las cuentas utilizadas y telefonos con una cuenta maestra para acceder a ellas de manera rapida "+
                "lo cual le facilita un orden en la gestion de almacenamiento para el usuario, ademas de seguridad, ya que el sistema encripta las contraseñas para que solo pueda ser utilizados usando este software."+
                "Ademas de poder exportar la data almacenada y posteriormente importarla, de ser necesario."
        );
    }    
    
}
