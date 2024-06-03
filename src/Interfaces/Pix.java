package Interfaces;

public interface Pix {
    
    public String CadastrarPix(String cpf);
    public Double EfetuarPix(String cpfDestino, Double valor);
    public Double ReceberPix(String cpfOrigem, Double valor);
}
