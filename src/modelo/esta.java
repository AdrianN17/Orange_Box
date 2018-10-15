package modelo;

public class esta {
    private String text;
    private int data;

    public esta(String text, int data) {
        this.text = text;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
