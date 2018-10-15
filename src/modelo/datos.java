package modelo;
public class datos 
{
    private int id;
    private String nick;
    private String contraseña;
    private String url;
    private String usuario;
    private int count;

    public datos(int id, String nick, String contraseña, String url, String usuario, int count) {
        this.id = id;
        this.nick = nick;
        this.contraseña = contraseña;
        this.url = url;
        this.usuario = usuario;
        this.count = count;
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
