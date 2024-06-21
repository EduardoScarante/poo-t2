package Interfaces;

public interface Pix {
    
    public String CadastrarPix();
    public void EfetuarPix(String cpfDestino, Double valor);
    public void ReceberPix(String cpfOrigem, Double valor);
}
