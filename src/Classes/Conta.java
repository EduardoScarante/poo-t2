package Classes;
import java.util.ArrayList;
import java.util.Date;

abstract public class Conta{
    protected Integer numeroConta;
    protected String Correntista;
    protected String cpf;
    protected ArrayList<Operacao> operacoes;

    public Conta(Integer numeroConta, String Correntista, String cpf) {
        this.numeroConta = numeroConta;
        this.Correntista = Correntista;
        this.cpf = cpf;
        this.operacoes = new ArrayList<>();
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public String getCorrentista() {
        return Correntista;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Operacao> getOperacoes() {
        return operacoes;
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

    public abstract String mostrarDetalhes();
}