package interfaz;

import java.util.ArrayList;
import modelo.datos;
import modelo.login;
import modelo.tele;

public interface inter {
    public login ingreso(login Login);
    public int registro(login Login);
    public ArrayList getdatos(datos daa);
    public int agregardato(datos da);
    public int agregardatoen(datos da);
    public ArrayList getdatosen(datos daa);
    public int eliminardato(datos da);
    public int editardatos(datos da);
    public login getusuariomain(login Login);
    public int cantidaddatos(login Login);
    public int cambiarlogin(login Login);
    public int borrartodo(login Login);
    public int eliminarcuenta(login Login);
    public ArrayList gettelefono(tele te);
    public int ingresartele(tele te);
    public int editartele(tele te);
    public int eliminartele(tele te);
    public int cantidadtele(login Login);
    public int borrarteletotal(login lo);
    public boolean validarusuario(String usu);
    public ArrayList estadisticas(String usu);
}
