package init;
import java.net.InetAddress;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Programa extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);

        /*InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());*/
        
        stage.setScene(scene);
        stage.setTitle("Orange Box ver 0.1");
        stage.setResizable(false);
        stage.getIcons().add(new Image("/imagen/icono.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
