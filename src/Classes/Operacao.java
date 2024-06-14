package Classes;
import java.util.Date;

public class Operacao {
    private Date data;
    private Double valor;
    private String Identificador;

    public Operacao(Date data, Double valor, String identificador) {
        this.data = data;
        this.valor = valor;
        Identificador = identificador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String identificador) {
        Identificador = identificador;
    }
}
