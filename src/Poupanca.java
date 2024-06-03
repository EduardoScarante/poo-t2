import Interfaces.Remunerada;

public class Poupanca extends Conta implements Remunerada{
    
    public Poupanca(String numeroConta, String Correntista, String cpf) {
        super(numeroConta, Correntista, cpf);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Double AplicaTxDeCorrecao() {
        return null;
    }

    @Override
    public void mostrarDetalhes() {
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDetalhes'");
    }
}
