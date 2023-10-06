import java.util.ArrayList;

public class Trabalho {
    private int id;
    private String resumo;
    private String titulo;
    private Professor orientador;
    private ArrayList<Estudante> integrantes =  new ArrayList<>();
    
    public int getId() {
        return id;
    }
    public String getResumo() {
        return resumo;
    }
    public String getTitulo() {
        return titulo;
    }
    public Professor getOrientador() {
        return orientador;
    }
    public ArrayList<Estudante> getIntegrantes() {
        return integrantes;
    }

    
}
