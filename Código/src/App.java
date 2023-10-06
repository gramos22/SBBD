import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<MiniCurso> miniCursos;
    ArrayList<SessaoTecnica> sessoesTecnicas;
    ArrayList<Instituicao> instituicoes;
    ArrayList<Pessoa> pessoas;

    public void listarMinicursos() {
        int tamMiniCursos = miniCursos.size();
        MiniCurso auxMiniCurso;

        for(int i = 0; i < tamMiniCursos; i++) {
            auxMiniCurso = miniCursos.get(i);
            System.out.println("-------------------------------------");
            System.out.println("Titulo: "+auxMiniCurso.getTitulo());
            System.out.println("Data: "+auxMiniCurso.getData());
            System.out.println("Hora Inicio: "+auxMiniCurso.getHoraInicio());
            System.out.println("Hora Fim: "+auxMiniCurso.getHoraFim());
            System.out.println("Profissional: "+auxMiniCurso.getProfissional().getNome());
            auxMiniCurso.listarParticipantes();
            System.out.println("Local: "+auxMiniCurso.getLocal());
            System.out.println("-------------------------------------");
        }
    }

    public void adicionarMinicurso(MiniCurso miniCurso) {
        miniCursos.add(miniCurso);
    }

    public void listarSessoesTecnicas() {
        int tamSessoesTecnicas = sessoesTecnicas.size();
        SessaoTecnica auxSessaoTecnica;

        for(int i = 0; i < tamSessoesTecnicas; i++) {
            auxSessaoTecnica = sessoesTecnicas.get(i);
            System.out.println("-------------------------------------");
            System.out.println("Data: "+auxSessaoTecnica.getData());
            System.out.println("Hora Inicio: "+auxSessaoTecnica.getHoraInicio());
            System.out.println("Hora Fim: "+auxSessaoTecnica.getHoraFim());
            System.out.println("Local: "+auxSessaoTecnica.getLocal());
            System.out.println("Mediador: "+auxSessaoTecnica.getMediador());
            auxSessaoTecnica.listarApresentacoes();
            System.out.println("-------------------------------------");
        }
    }

    public void adicionarSessaoTecnica(SessaoTecnica sessaoTecnica) {
        sessoesTecnicas.add(sessaoTecnica);
    }

    public void listarInstituicoes() {
        int tamInstituicoes = instituicoes.size();
        Instituicao auxInstituicao;

        System.out.println("Instituicoes:");
        for(int i = 0; i < tamInstituicoes; i++) {
            auxInstituicao = instituicoes.get(i);
            System.out.println("- "+auxInstituicao.getNome());
        }
    }

    public void adicionarInstituicao(Instituicao instituicao) {
        instituicoes.add(instituicao);
    }

    public void listarPessoas() {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;

        System.out.println("Pessoas:");
        for(int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            System.out.println("- "+auxPessoa.getNome());
        }
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public static void main(String[] args) throws Exception {

        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("\tSBBD v1.0");
        System.out.println("-------------------------------------");
        System.out.println("1- Mini-Cursos");
        System.out.println("2- Sessoes Tecnicas");
        System.out.println("4- Instituicoes");
        System.out.println("5- Pessoas");


        scanner.close();
    }
}
