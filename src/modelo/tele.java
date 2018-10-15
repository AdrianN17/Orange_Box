package modelo;
public class tele {
    private int id;
    private String usuario;
    private String contacto;
    private String detalle;
    private String telefono;
    private int count;

    public tele(int id, String usuario, String contacto, String detalle, String telefono, int count) {
        this.id = id;
        this.usuario = usuario;
        this.contacto = contacto;
        this.detalle = detalle;
        this.telefono = telefono;
        this.count = count;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
