package Interfaces;

import Classes.Corrente;

public interface Pix {
    
    public Corrente CadastrarPix();
    public void EfetuarPix(String cpfDestino, Double valor);
    public void ReceberPix(String cpfOrigem, Double valor);
}
