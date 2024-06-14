package Classes;
import Interfaces.Pix;

public class Corrente extends Conta implements Pix{

    public Corrente(Integer numeroConta, String Correntista, String cpf) {
        super(numeroConta, Correntista, cpf);
    }

    @Override
    public String mostrarDetalhes() {
        return "Conta Corrente Nº: " + this.numeroConta + " - Correntista: " + this.Correntista + " - Cpf: " + this.cpf;
    }

    @Override
    public String CadastrarPix(String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CadastrarPix'");
    }

    @Override
    public Double EfetuarPix(String cpfDestino, Double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'EfetuarPix'");
    }

    @Override
    public Double ReceberPix(String cpfOrigem, Double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ReceberPix'");
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
