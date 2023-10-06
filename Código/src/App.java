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
    ArrayList<Sala> salas;
    ArrayList<Trabalho> trabalhos;

    private LocalDate parseData(String data) {
        String auxData[];

        auxData = data.split("/");

        return LocalDate.of(Integer.parseInt(auxData[2]), Month.of(Integer.parseInt(auxData[1])), Integer.parseInt(auxData[0]));
    }

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

        for (int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if (auxPessoa instanceof Estudante && auxPessoa.getNome() == nome) {
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

    public Pessoa buscarPessoa(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;

        for (int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if (auxPessoa.getNome() == nome) {
                return auxPessoa;
            }
        }

        return null;
    }

    public Profissional buscarProfissional(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;

        for (int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if (auxPessoa instanceof Profissional && auxPessoa.getNome() == nome) {
                return (Profissional) auxPessoa;
            }
        }

        return null;
    }

    public Professor buscarProfessor(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;

        for (int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if (auxPessoa instanceof Professor && auxPessoa.getNome() == nome) {
                return (Professor) auxPessoa;
            }
        }

        return null;
    }

    public Estudante buscarEstudante(String nome) {
        int tamPessoas = pessoas.size();
        Pessoa auxPessoa;

        for (int i = 0; i < tamPessoas; i++) {
            auxPessoa = pessoas.get(i);
            if (auxPessoa instanceof Estudante && auxPessoa.getNome() == nome) {
                return (Estudante) auxPessoa;
            }
        }

        return null;
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public Sala buscarSala(int codigo) {
        int tamSalas = salas.size();
        Sala auxSala;

        for(int i = 0; i < tamSalas; i++) {
            auxSala = salas.get(i);
            if(auxSala.getCodigo() == codigo) {
                return auxSala;
            }
        }

        return null;
    }

    public void listarSalas() {
        int tamSalas = salas.size();
        Sala auxSala;

        System.out.println("Salas:");
        for (int i = 0; i < tamSalas; i++) {
            auxSala = salas.get(i);
            System.out.println("- " + auxSala.getCodigo());
        }
    }

    public void excluirSala(int codigo) {
        int tamSalas = salas.size();

        for (int i = 0; i < tamSalas; i++) {
            if (salas.get(i).getCodigo() == codigo) {
                salas.remove(i);
                System.out.println("Sala " + codigo + " removido com sucesso");
                return;
            }
        }

        System.out.println("Sala nao encontrada :/");
    }

    public Trabalho buscarTrabalho(int id) {
        int tamTrabalho = trabalhos.size();
        Trabalho auxTrabalho;

        for(int i = 0; i < tamTrabalho; i++) {
            auxTrabalho = trabalhos.get(i);
            if(auxTrabalho.getId() == id) {
                return auxTrabalho;
            }
        }

        return null;
    }

    public void listarTrabalhos() {
        int tamTrabalhos = trabalhos.size();
        Trabalho auxTrabalho;

        for(int i = 0; i < tamTrabalhos; i++) {
            auxTrabalho = trabalhos.get(i);

            System.out.println("-------------------------------------");
            System.out.println("ID: " + auxTrabalho.getId());
            System.out.println("Titulo: " + auxTrabalho.getTitulo());
            System.out.println("Resumo: " + auxTrabalho.getResumo());
            System.out.println("Orientador: " + auxTrabalho.getOrientador().getNome());
            auxTrabalho.listarIntegrantes();
            System.out.println("-------------------------------------");
        }
    }

    public void excluirTrabalho(int id) {
        int tamTrabalhos = trabalhos.size();
        Trabalho auxTrabalho;
        for(int i = 0; i < tamTrabalhos; i++) {
            auxTrabalho = trabalhos.get(i);
            if(auxTrabalho.getId() == id) {
                trabalhos.remove(i);
            }
        }
    }

    public void submenuMinicursos(Scanner scanner) {
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Mini Cursos");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarMinicursos();
                    break;
                case 2:
                    MiniCurso minicurso = new MiniCurso();
                    String auxParticipante = "";
                    Pessoa auxPessoa;

                    System.out.println("Cadastro de Mini Curso:\n");

                    System.out.println("Titulo: ");
                    minicurso.setTitulo(scanner.nextLine());

                    System.out.println("Data (01/01/2000): ");

                    minicurso.setData(parseData(scanner.nextLine()));

                    System.out.println("Hora de Inicio (13:00): ");
                    minicurso.setHoraInicio(Time.valueOf(scanner.nextLine().concat(":00")));

                    System.out.println("Hora de Fim (13:00): ");
                    minicurso.setHoraFim(Time.valueOf(scanner.nextLine().concat(":00")));

                    System.out.println("Profissional: ");
                    minicurso.setProfissional(buscarProfissional(scanner.nextLine()));

                    System.out.println("Entre com o nome de um participante (DIGITE 0 PARA PARAR): ");
                    auxParticipante = scanner.nextLine();
                    while (auxParticipante != "0") {
                        auxPessoa = buscarPessoa(auxParticipante);
                        if (auxPessoa != null) {
                            minicurso.adicionarParticipante(auxPessoa);
                        } else {
                            System.out.println("\nPessoa nao cadastrada no evento!\n");
                        }
                        System.out.println("Entre com o nome de um participante (DIGITE 0 PARA PARAR): ");
                        auxParticipante = scanner.nextLine();
                    }

                    miniCursos.add(minicurso);

                    System.out.println("\nMini Curso registrado com sucesso!\n");
                    break;
                case 3:
                    System.out.println("Entre com o titulo do Mini Curso a ser removido: ");
                    excluirMinicurso(scanner.nextLine());
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void submenuSessoesTecnicas(Scanner scanner) {                                                                                                                                                                   
        int opcao;
        Time auxHoraInicio, auxHoraApresentacao;
        String auxMediador;
        int auxIdTrabalho;
        Trabalho auxTrabalho;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Sessoes Tecnicas");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarSessoesTecnicas();
                    break;
                case 2:
                    SessaoTecnica sessaoTecnica = new SessaoTecnica();

                    System.out.println("Cadastro de Sessao Tecnica:\n");

                    System.out.println("Data (01/01/2000):"); sessaoTecnica.setData(parseData(scanner.nextLine()));
                    
                    System.out.println("Hora Inicio (13:00)"); sessaoTecnica.setHoraInicio(Time.valueOf(scanner.nextLine().concat(":00")));

                    System.out.println("Hora Fim (13:00):"); sessaoTecnica.setHoraFim(Time.valueOf(scanner.nextLine().concat(":00")));

                    System.out.println("Codigo da sala: "); sessaoTecnica.setLocal(buscarSala(scanner.nextInt()));

                    System.out.println("Mediador: "); sessaoTecnica.setMediador(buscarProfessor(scanner.nextLine()));

                    System.out.println("Entre com o id de um trabalho a ser apresentado (DIGITE 0 PARA PARAR): ");
                    auxIdTrabalho = scanner.nextInt();
                    while (auxIdTrabalho != 0) {
                        auxTrabalho = buscarTrabalho(auxIdTrabalho);
                        if (auxTrabalho != null) {
                            System.out.println("Entre com a hora da apresentacao: ");
                            auxHoraApresentacao = Time.valueOf(scanner.nextLine().concat(":00"));

                            sessaoTecnica.adicionarApresentacoes(new Apresentacao(auxHoraApresentacao, auxTrabalho));
                        } else {
                            System.out.println("\nTrabalho nao cadastrado no evento!\n");
                        }
                        System.out.println("Entre com o id de um trabalho a ser apresentado (DIGITE 0 PARA PARAR): ");
                        auxIdTrabalho = scanner.nextInt();
                    }

                    sessoesTecnicas.add(sessaoTecnica);

                    break;
                case 3:
                    LocalDate auxData;

                    System.out.println("Entre com a data da Sessao Tecnica a ser removida (01/01/2000): ");
                    auxData = parseData(scanner.nextLine());

                    System.out.println("Entre com a hora de Inicio da Sessao Tecnica a ser removida (13:00): ");
                    auxHoraInicio = Time.valueOf(scanner.nextLine().concat(":00"));
                    
                    System.out.println("Entre com o nome do mediador: "); auxMediador = scanner.nextLine();

                    excluirSessaoTecnica(auxData, auxHoraInicio, auxMediador);

                    System.out.println("\nSessao Tecnica excluida com sucesso!\n");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void submenuInstituicoes(Scanner scanner) {                                                                                                                                                                   
        int opcao, opcaoInstituicao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Instituicoes");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarInstituicoes();
                    break;
                case 2:
                    System.out.println("Cadastro de Instituicao:\n");

                    System.out.println("1. Empresa");
                    System.out.println("2. Universidade");
                    System.out.println("Escolha uma opcao: "); opcaoInstituicao = scanner.nextInt();

                    if(opcaoInstituicao == 1) {
                        Empresa empresa = new Empresa();

                        System.out.println("\nCadastro de Empresa:\n");
                        System.out.println("Nome: "); empresa.setNome(scanner.nextLine());
                        System.out.println("CNPJ: "); empresa.setCnpj(scanner.nextLine());
                        System.out.println("Ramo de atividade: "); empresa.setRamoAtividade(scanner.nextLine());
                        
                        instituicoes.add(empresa);
                    } else if(opcaoInstituicao == 2) {
                        Universidade universidade = new Universidade();

                        System.out.println("\nCadastro de Universiade:\n");
                        System.out.println("Nome: "); universidade.setNome(scanner.nextLine());
                        System.out.println("CNPJ: "); universidade.setCnpj(scanner.nextLine());
                        System.out.println("Quantidade de cursos: "); universidade.setQtdeCursos(scanner.nextInt());
                        
                        instituicoes.add(universidade);
                    }
                    break;
                case 3:
                    System.out.println("Entre com o nome da instituicao a ser removida: ");
                    
                    excluirInstituicao(scanner.nextLine());

                    System.out.println("\nSessao Tecnica excluida com sucesso!\n");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void submenuPessoas(Scanner scanner) {                                                                                                                                                                   
        int opcao, opcaoPessoa;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Instituicoes");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarPessoas();
                    break;
                case 2:
                    System.out.println("Cadastro de Pessoa:\n");

                    System.out.println("1. Estudante");
                    System.out.println("2. Professor");
                    System.out.println("3. Profissional");
                    System.out.println("Escolha uma opcao: "); opcaoPessoa = scanner.nextInt();

                    if(opcaoPessoa == 1) {
                        Estudante estudante = new Estudante();

                        System.out.println("\nCadastro de Estudante:\n");
                        System.out.println("Nome: "); estudante.setNome(scanner.nextLine());
                        System.out.println("CPF: "); estudante.setCpf(scanner.nextLine());
                        System.out.println("Data de nascimento (01/01/2000):"); estudante.setDataNasc(parseData(scanner.nextLine()));
                        System.out.println("Email: "); estudante.setEmail(scanner.nextLine());
                        System.out.println("Matricula: "); estudante.setMatricula(scanner.nextInt());
                        System.out.println("Curso: "); estudante.setCurso(scanner.nextLine());
                        
                        pessoas.add(estudante);
                    } else if(opcaoPessoa == 2) {
                        Professor professor = new Professor();

                        System.out.println("\nCadastro de Professor:\n");
                        System.out.println("Nome: "); professor.setNome(scanner.nextLine());
                        System.out.println("CPF: "); professor.setCpf(scanner.nextLine());
                        System.out.println("Data de nascimento (01/01/2000):"); professor.setDataNasc(parseData(scanner.nextLine()));
                        System.out.println("Email: "); professor.setEmail(scanner.nextLine());
                        System.out.println("Disciplina: "); professor.setDisciplina(scanner.nextLine());
                        
                        pessoas.add(professor);
                    }
                    else if(opcaoPessoa == 3) {
                        Profissional profissional = new Profissional();

                        System.out.println("\nCadastro de Profissional:\n");
                        System.out.println("Nome: "); profissional.setNome(scanner.nextLine());
                        System.out.println("CPF: "); profissional.setCpf(scanner.nextLine());
                        System.out.println("Data de nascimento (01/01/2000):"); profissional.setDataNasc(parseData(scanner.nextLine()));
                        System.out.println("Email: "); profissional.setEmail(scanner.nextLine());
                        System.out.println("Area de Atuação: "); profissional.setAreaAtuacao(scanner.nextLine());
                        
                        pessoas.add(profissional);
                    }
                    break;
                case 3:
                    System.out.println("Entre com o nome da Pessoa a ser removida: ");
                    
                    excluirPessoa(scanner.nextLine());

                    System.out.println("\nPessoa excluida com sucesso!\n");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void submenuSalas(Scanner scanner) {                                                                                                                                                                   
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Instituicoes");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarSalas();
                    break;
                case 2:
                    System.out.println("Cadastro de Sala:\n");

                        Sala sala = new Sala();

                        System.out.println("\nCadastro de Estudante:\n");
                        System.out.println("Codigo da sala: "); sala.setCodigo(scanner.nextInt());
                        System.out.println("Id do predio: "); sala.setIdPredio(scanner.nextInt());
                        System.out.println("Capacidade:"); sala.setCapacidade(scanner.nextInt());
                        
                        salas.add(sala);

                case 3:
                    System.out.println("Entre com o codigo da Sala a ser removida: ");
                    
                    excluirSala(scanner.nextInt());

                    System.out.println("\nSala excluida com sucesso!\n");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void submenuTrabalhos(Scanner scanner) {
        String auxIntegrante;
        Estudante auxEstudante;                                            
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0/Trabalhos");
            System.out.println("-------------------------------------");
            System.out.println("1- Listar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Remover");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarTrabalhos();
                    break;
                case 2:
                    Trabalho trabalho = new Trabalho();

                    System.out.println("Cadastro de Trabalho:\n");

                    System.out.println("ID: "); trabalho.setId(scanner.nextInt());

                    System.out.println("Titulo: "); trabalho.setTitulo(scanner.nextLine());

                    System.out.println("Resumo: "); trabalho.setResumo(scanner.nextLine());

                    System.out.println("Orientador: "); trabalho.setOrientador(buscarProfessor(scanner.nextLine()));

                    auxIntegrante = scanner.nextLine();
                    while (auxIntegrante != "0") {
                        auxEstudante = buscarEstudante(auxIntegrante);
                        if (auxEstudante != null) {
                            trabalho.adicionarIntegrante(auxEstudante);
                        } else {
                            System.out.println("\nPessoa nao cadastrada no evento!\n");
                        }
                        System.out.println("Entre com o nome de um participante (DIGITE 0 PARA PARAR): ");
                        auxIntegrante = scanner.nextLine();
                    }

                    break;
                case 3:
                    System.out.println("Entre com o ID do trabalho a ser excluido: ");
                    
                    excluirTrabalho(scanner.nextInt());

                    System.out.println("\nSessao Tecnica excluida com sucesso!\n");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\tSBBD v1.0");
            System.out.println("-------------------------------------");
            System.out.println("1- Mini Cursos");
            System.out.println("2- Sessoes Tecnicas");
            System.out.println("3- Instituicoes");
            System.out.println("4- Pessoas");
            System.out.println("5- Salas");
            System.out.println("6- Trabalhos");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    app.submenuMinicursos(scanner);
                    break;
                case 2:
                    app.submenuSessoesTecnicas(scanner);
                default:
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
