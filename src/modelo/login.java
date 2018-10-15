package modelo;
public class login {
    private String id;
    private String pass;
    private String pass2;

    public login(String id, String pass, String pass2) {
        this.id = id;
        this.pass = pass;
        this.pass2 = pass2;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
}
