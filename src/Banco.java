
// CLASSE MAIN

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    private static Scanner teclado = new Scanner(System.in);

    protected ArrayList<Conta> contas;
    protected ArrayList<String> contasComPix;

    public static void main(String[] args) {
        int opcao;
        System.out.println("Bem-vindo ao Banco Object! :)");
        System.out.println("\nEscolha a ação...");

        do {
            System.out.println("\n*** Menu principal ***\n");
            System.out.println("0 - Criar Conta Corrente");
            System.out.println("1 - Criar Conta Poupança");
            System.out.println("2 - Efetuar Depósito");
            System.out.println("3 - Efetuar Saque");
            System.out.println("4 - Aplicar Correção");
            System.out.println("5 - Cadastrar Pix");
            System.out.println("6 - Efetuar Pix");
            System.out.println("7 - Consultar Extrato");
            System.out.print("\n>> Opcao?  ");

            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1:
                criarContaCorrente();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    break;
            }
        } while (opcao != 0);

    }

    public static void criarContaCorrente(){
        System.out.println("Informe NOME do Correntista");
        String nome = teclado.nextLine();
        System.out.println("Informe CPF do Correntista");
        String cpf = teclado.nextLine();

        Conta novaConta = new Corrente("1234", nome, cpf);
        System.out.println(novaConta);
    }


}