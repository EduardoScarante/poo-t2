import java.util.ArrayList;
import java.util.Date;

abstract class Conta{
    protected String numeroConta;
    protected String Correntista;
    protected String cpf;
    protected ArrayList<Operacao> operacoes;

    public Conta(String numeroConta, String Correntista, String cpf) {
        this.numeroConta = numeroConta;
        this.Correntista = Correntista;
        this.cpf = cpf;
        this.operacoes = new ArrayList<>();
    }

    public void depositar(double valor) {
        if (valor > 0) {
            operacoes.add(new Operacao(new Date(), valor, "Depósito"));
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            operacoes.add(new Operacao(new Date(), -valor, "Saque"));
            return true;
        }
        return false;
    }

    public double getSaldo() {
        double saldo = 0;
        for (Operacao op : operacoes) {
            saldo += op.getValor();
        }
        return saldo;
    }

    // Método abstrato para ser implementado nas subclasses
    public abstract void mostrarDetalhes();
}