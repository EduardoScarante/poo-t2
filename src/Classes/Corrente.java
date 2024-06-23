package Classes;

import java.util.Date;

import Interfaces.Pix;

public class Corrente extends Conta implements Pix {

    public Corrente(Integer numeroConta, String Correntista, String cpf) {
        super(numeroConta, Correntista, cpf);
    }

    @Override
    public String mostrarDetalhes() {
        return "Conta Corrente Nº: " + this.numeroConta + " - Correntista: " + this.Correntista + " - Cpf: " + this.cpf;
    }

    @Override
    public Corrente CadastrarPix() {
        return new Corrente(numeroConta, Correntista, cpf);
    }

    @Override
    public void EfetuarPix(String cpfDestino, Double valor) {
        super.operacoes.add(new Operacao(new Date(), valor, "Pix - Saída"));
    }
    
    @Override
    public void ReceberPix(String cpfOrigem, Double valor) {
        super.operacoes.add(new Operacao(new Date(), valor, "Pix - Entrada"));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
