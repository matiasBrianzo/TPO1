package usuario.example.tpo1.modelo;

import java.io.Serializable;

public class DTOPalabra implements Serializable{

    private String Esp;
    private String Eng;
    private int foto;

    public DTOPalabra(String esp, String eng, int foto) {
        Esp = esp;
        Eng = eng;
        this.foto = foto;
    }

    public String getEsp() {
        return Esp;
    }

    public void setEsp(String esp) {
        Esp = esp;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
