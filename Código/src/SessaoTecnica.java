import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class SessaoTecnica {
    private Date data;
    private Time horaInicio;
    private Time horaFim;
    private Sala local;
    private Professor mediador;
    private ArrayList<Apresentacao> apresentacoes = new ArrayList<>();

    public Date getData() {
        return data;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public Sala getLocal() {
        return local;
    }

    public Professor getMediador() {
        return mediador;
    }

    public ArrayList<Apresentacao> getApresentacoes() {
        return apresentacoes;
    }

    public void adicionarApresentacoes(Apresentacao apresentacao){
        apresentacoes.add(apresentacao);
    }

    public void listarApresentacoes(){
        Apresentacao auxApresentacao;
        ArrayList<Estudante> auxIntegrantes;
        int tamApresentacoes, tamIntegrantes;

        tamApresentacoes = apresentacoes.size();

        System.out.println("-Apresentacoes-");
        for(int i=0; i < tamApresentacoes; i++){
            auxApresentacao = apresentacoes.get(i);
            System.out.println("Id do trabalho: "+auxApresentacao.getTrabalho().getId()+"\n");
            System.out.println("Titulo: "+auxApresentacao.getTrabalho().getTitulo());
            System.out.println("Resumo: "+auxApresentacao.getTrabalho().getResumo());
            System.out.println("Prof. Orientador: "+auxApresentacao.getTrabalho().getOrientador().getNome());
            System.out.println("Integrantes:");
            auxIntegrantes = auxApresentacao.getTrabalho().getIntegrantes();
            tamIntegrantes = auxIntegrantes.size();
            for(int j = 0; j < tamIntegrantes; j++) {
                System.out.println("- "+auxIntegrantes.get(i).getNome());
            }
        }

    }

    public void excluirApresentacao(int codigoTrabalho){
        int tamApresentacoes = apresentacoes.size();

        for(int i = 0; i < tamApresentacoes; i++) {
            if(apresentacoes.get(i).getTrabalho().getId() == codigoTrabalho) {
                apresentacoes.remove(i);
                System.out.println("Apresentacao com trabalho "+codigoTrabalho+" removido com sucesso");
                return;
            }
        }

        System.out.println("Apresentacao nao encontrada :/");
    }
}
