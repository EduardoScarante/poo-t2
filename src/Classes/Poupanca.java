package Classes;
import java.util.Date;

import Interfaces.Remunerada;

public class Poupanca extends Conta implements Remunerada{
    
    public Poupanca(Integer numeroConta, String Correntista, String cpf) {
        super(numeroConta, Correntista, cpf);
    }

    @Override
    public Double AplicaTxDeCorrecao(Double tx) {
        super.operacoes.add(new Operacao(new Date(), tx/100, "Correção"));
        return tx;
    }

    @Override
    public String mostrarDetalhes() {
        return "Conta Poupança Nº: " + this.numeroConta + " - Correntista: " + this.Correntista + " - Cpf: " + this.cpf;
    }

}
