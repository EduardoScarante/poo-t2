package Classes;
import Interfaces.Remunerada;

public class Poupanca extends Conta implements Remunerada{
    
    public Poupanca(Integer numeroConta, String Correntista, String cpf) {
        super(numeroConta, Correntista, cpf);
    }

    @Override
    public Double AplicaTxDeCorrecao() {
        return null;
    }

    @Override
    public String mostrarDetalhes() {
        return "Conta Poupança Nº: " + this.numeroConta + " - Correntista: " + this.Correntista + " - Cpf: " + this.cpf;
    }

}
