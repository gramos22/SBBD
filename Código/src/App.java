import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
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

        for (int i = 0; i < tamMiniCursos; i++) {
            auxMiniCurso = miniCursos.get(i);
            System.out.println("-------------------------------------");
            System.out.println("Titulo: " + auxMiniCurso.getTitulo());
            System.out.println("Data: " + auxMiniCurso.getData());
            System.out.println("Hora Inicio: " + auxMiniCurso.getHoraInicio());
            System.out.println("Hora Fim: " + auxMiniCurso.getHoraFim());
            System.out.println("Profissional: " + auxMiniCurso.getProfissional().getNome());
            auxMiniCurso.listarParticipantes();
            System.out.println("Local: " + auxMiniCurso.getLocal());
            System.out.println("-------------------------------------");
        }
    }

    public void adicionarMinicurso(MiniCurso miniCurso) {
        miniCursos.add(miniCurso);
    }

    public void excluirMinicurso(String titulo) {
        int tamMiniCursos = miniCursos.size();

        for (int i = 0; i < tamMiniCursos; i++) {
            if (miniCursos.get(i).getTitulo() == titulo) {
                miniCursos.remove(i);
                System.out.println("MiniCurso " + titulo + " removido com sucesso");
                return;
            }
        }

        System.out.println("MiniCurso nao encontrado :/");
    }

    public void listarSessoesTecnicas() {
        int tamSessoesTecnicas = sessoesTecnicas.size();
        SessaoTecnica auxSessaoTecnica;

        for (int i = 0; i < tamSessoesTecnicas; i++) {
            auxSessaoTecnica = sessoesTecnicas.get(i);
            System.out.println("-------------------------------------");
            System.out.println("Data: " + auxSessaoTecnica.getData());
            System.out.println("Hora Inicio: " + auxSessaoTecnica.getHoraInicio());
            System.out.println("Hora Fim: " + auxSessaoTecnica.getHoraFim());
            System.out.println("Local: " + auxSessaoTecnica.getLocal());
            System.out.println("Mediador: " + auxSessaoTecnica.getMediador());
            auxSessaoTecnica.listarApresentacoes();
            System.out.println("-------------------------------------");
        }
    }

    public void excluirSessaoTecnica(LocalDate data, Time horaInicio, String mediador) {
        int tamSessoesTecnicas = sessoesTecnicas.size();
        SessaoTecnica auxSessaoTecnica;

        for (int i = 0; i < tamSessoesTecnicas; i++) {
            auxSessaoTecnica = sessoesTecnicas.get(i);
            if (auxSessaoTecnica.getData().equals(data) && auxSessaoTecnica.getHoraInicio().equals(horaInicio)
                    && auxSessaoTecnica.getMediador().getNome() == mediador) {
                miniCursos.remove(i);
                System.out
                        .println("Sessao Tecnica do dia " + data + "e horario " + horaInicio + " removida com sucesso");
                return;
            }
        }

        System.out.println("Sessao Tenica nao encontrada :/");
    }

    public void adicionarSessaoTecnica(SessaoTecnica sessaoTecnica) {
        sessoesTecnicas.add(sessaoTecnica);
    }

    public void listarInstituicoes() {
        int tamInstituicoes = instituicoes.size();
        Instituicao auxInstituicao;

        System.out.println("Instituicoes:");
        for (int i = 0; i < tamInstituicoes; i++) {
            auxInstituicao = instituicoes.get(i);
            System.out.println("- " + auxInstituicao.getNome());
        }
    }

    public void excluirInstituicao(String nome) {
        int tamInstituicoes = instituicoes.size();

        for (int i = 0; i < tamInstituicoes; i++) {
            if (instituicoes.get(i).getNome() == nome) {
                instituicoes.remove(i);
                System.out.println("Instituicao " + nome + " removida com sucesso");
                return;
            }
        }

        System.out.println("Instituicao nao encontrada :/");
    }

    public void adicionarInstituicao(Instituicao instituicao) {
        instituicoes.add(instituicao);
    }

    public Estudante buscar(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;
        
        for(int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if(auxPessoa instanceof Estudante && auxPessoa.getNome() == nome) {
                return (Estudante) auxPessoa;
            }
        }

        return null;
    }

    public void listarPessoas() {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;

        System.out.println("Pessoas:");
        for (int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            System.out.println("- " + auxPessoa.getNome());
        }
    }

    public void excluirPessoa(String nome) {
        int tamPessoas = pessoas.size();

        for (int i = 0; i < tamPessoas; i++) {
            if (pessoas.get(i).getNome() == nome) {
                pessoas.remove(i);
                System.out.println("Pessoa " + nome + " removida com sucesso");
                return;
            }
        }

        System.out.println("Pessoa nao encontrada :/");
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public Profissional buscarProfissional(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;
        
        for(int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if(auxPessoa instanceof Profissional && auxPessoa.getNome() == nome) {
                return (Profissional) auxPessoa;
            }
        }

        return null;
    }

    public Estudante buscarEstudante(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;
        
        for(int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if(auxPessoa instanceof Estudante && auxPessoa.getNome() == nome) {
                return (Estudante) auxPessoa;
            }
        }

        return null;
    }

    public void submenuMinicursos(Scanner scanner) {
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Mini Cursos");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Cadastrar participantes:");
            System.out.println("4- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: "); opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarMinicursos();
                    break;
                case 2:
                    MiniCurso minicurso = new MiniCurso();
                    String auxData[];
                    System.out.println("Cadastro de Mini Curso:\n");

                    System.out.println("Titulo: "); minicurso.setTitulo(scanner.nextLine());

                    System.out.println("Data (01/01/2000): "); auxData = scanner.nextLine().split("/");

                    minicurso.setData(LocalDate.of(Integer.parseInt(auxData[2]), Month.of(Integer.parseInt(auxData[1])), Integer.parseInt(auxData[0])));
                    
                    System.out.println("Hora de Inicio (13:00): "); 
                    minicurso.setHoraInicio(Time.valueOf(scanner.nextLine().concat(":00")));

                    System.out.println("Hora de Fim (13:00): ");
                    minicurso.setHoraFim(Time.valueOf(scanner.nextLine().concat(":00")));

                    System.out.println("Profissional: "); minicurso.setProfissional(buscarProfissional(scanner.nextLine()));
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0");
            System.out.println("-------------------------------------");
            System.out.println("1- Mini Cursos");
            System.out.println("2- Sessoes Tecnicas");
            System.out.println("4- Instituicoes");
            System.out.println("5- Pessoas");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: "); opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
