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

        System.out.println("------------------------------------------------");
        System.out.println("Participantes:");
        for (int i = 0; i < tamParticipantes; i++) {
            System.out.println("- " + participantes.get(i).getNome());
        }
        System.out.println("------------------------------------------------");

    }
}
