import java.sql.Time;

public class Apresentacao {
    private Time horaApresentacao;
    private Trabalho trabalho;

    public Apresentacao(Time horaApresentacao, Trabalho trabalho) {
        this.horaApresentacao = horaApresentacao;
        this.trabalho = trabalho;
    }

    public Time getHoraApresentacao() {
        return horaApresentacao;
    }
    public Trabalho getTrabalho() {
        return trabalho;
    }

}
