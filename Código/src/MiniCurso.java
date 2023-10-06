import java.sql.Time;
import java.util.Date;
import java.util.List;

public class MiniCurso {
    private String titulo;
    private Date data;
    private Time horaInicio;
    private Time horaFim;
    private Profissional profissional;
    private List<Pessoa> participantes;
    private Sala local;

    public String getTitulo() {
        return titulo;
    }

    public Date getData() {
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

    public List<Pessoa> getParticipantes() {
        return participantes;
    }

    public Sala getLocal() {
        return local;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(Date data) {
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

    public void setParticipantes(List<Pessoa> participantes) {
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
