import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class MiniCurso {
    private String titulo;
    private LocalDate data;
    private Time horaInicio;
    private Time horaFim;
    private Profissional profissional;
    private ArrayList<Pessoa> participantes;
    private Sala local;

    public MiniCurso() {
        titulo = null;
        data = null;
        horaInicio = null;
        horaFim = null;
        profissional = null;
        participantes = new ArrayList<Pessoa>();
        local = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public ArrayList<Pessoa> getParticipantes() {
        return participantes;
    }

    public Sala getLocal() {
        return local;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setParticipantes(ArrayList<Pessoa> participantes) {
        this.participantes = participantes;
    }

    public void setLocal(Sala local) {
        this.local = local;
    }

    public void adicionarParticipante(Pessoa pessoa) {
        participantes.add(pessoa);
    }

    public void excluirParticipante(String nome) {
        int tamParticipantes = participantes.size();

        for (int i = 0; i < tamParticipantes; i++) {
            if (participantes.get(i).getNome() == nome) {
                participantes.remove(i);
                System.out.println("Participante " + nome + " removido com sucesso");
                return;
            }
        }

        System.out.println("Participante nao encontrado :/");
    }

    public void listarParticipantes() {
        int tamParticipantes = participantes.size();

        System.out.println("Participantes:");
        for (int i = 0; i < tamParticipantes; i++) {
            System.out.println("- " + participantes.get(i).getNome());
        }

    }
}
