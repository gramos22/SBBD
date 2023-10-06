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

    public void setId(int id) {
        this.id = id;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }
    public void setIntegrantes(ArrayList<Estudante> integrantes) {
        this.integrantes = integrantes;
    }
    public void listarIntegrantes() {
        int tamIntegrantes = integrantes.size();

        System.out.println("Integrantes:");
        for (int i = 0; i < tamIntegrantes; i++) {
            System.out.println("- " + integrantes.get(i).getNome());
        }

    }

    public void adicionarIntegrante(Estudante estudante) {
        integrantes.add(estudante);
    }

    
}
