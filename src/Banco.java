
// CLASSE MAIN

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Classes.Conta;
import Classes.Corrente;
import Classes.Operacao;
import Classes.Poupanca;

public class Banco {

    private static Scanner teclado = new Scanner(System.in);

    protected static ArrayList<Conta> contas = new ArrayList<>();
    protected static ArrayList<Corrente> contasComPix = new ArrayList<>();

    public static void main(String[] args) {
        /* ADICIONANDO INFOS DE INICIALIZAÇÂO DE APLICAÇÂO */
        Corrente a1 = new Corrente(11111, "Simba", "456");
        Corrente a2 = new Corrente(12345, "Mufasa", "789");
        contas.add(a1);
        contas.add(a2);
        
        contasComPix.add(a1);
        contasComPix.add(a2);
        
        contas.add(new Poupanca(54345, "Nala", "123"));
        contas.add(new Poupanca(90908, "Scar", "135"));
        contas.add(new Poupanca(45145, "Timon", "246"));
        contas.add(new Poupanca(65742, "Pumbaa", "357"));

        // CRIANDO OPERAÇÕES PARA INICIAR O SISTEMA
        contas.get(0).depositar(50);
        contas.get(0).depositar(100);
        contas.get(0).depositar(30);
        contas.get(0).sacar(130);

        contas.get(1).depositar(150);
        contas.get(1).sacar(70);
        contas.get(1).sacar(15);
        contas.get(1).depositar(100);

        contas.get(2).depositar(500);
        contas.get(2).depositar(750);
        contas.get(2).sacar(660);


        int opcao;
        System.out.println("Bem-vindo ao Banco Object! :)");
        System.out.println("\nEscolha a ação...");

        do {
            System.out.println("\n*** Menu principal ***\n");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupança");
            System.out.println("3 - Efetuar Depósito");
            System.out.println("4 - Efetuar Saque");
            System.out.println("5 - Aplicar Correção");
            System.out.println("6 - Cadastrar Pix");
            System.out.println("7 - Efetuar Pix");
            System.out.println("8 - Consultar Extrato");
            System.out.println("- - - - - - - - - - -");

            System.out.println("99 - Extra Ver contas");
            System.out.println("100 - Extra Ver contas com PIX");

            System.out.print("\n>> Opcao?  ");

            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1:
                    criarContaCorrente();
                    break;
                case 2:
                    criarContaPoupanca();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    saque();
                    break;
                case 5:
                    aplicaCorrecaoMonetaria();
                    break;
                case 6:
                    cadastraPix();
                    break;
                case 7:
                    fazerPix();
                    break;
                case 8:
                    extrato();
                    break;
                case 99:
                    utilVerTodasContas();
                    break;
                case 100:
                    verTodosPix();
                    break;
            }
        } while (opcao != 0);

    }

    public static void criarContaCorrente() {
        System.out.println("Informe NOME do Correntista");
        String nome = teclado.nextLine();
        System.out.println("Informe CPF do Correntista");
        String cpf = teclado.nextLine();

        Conta novaConta = new Corrente(utilGeradorDeNumeroDeconta(), nome, cpf);
        contas.add(novaConta);
        System.out.println("Nova conta Corrente cadastrada");
    }
    
    public static void criarContaPoupanca() {
        System.out.println("Informe NOME do Correntista");
        String nome = teclado.nextLine();
        System.out.println("Informe CPF do Correntista");
        String cpf = teclado.nextLine();
        System.out.println("\n");

        Conta novaConta = new Corrente(utilGeradorDeNumeroDeconta(), nome, cpf);
        contas.add(novaConta);
        System.out.println("Nova conta Poupança cadastrada");
    }

    public static void depositar() {
        System.out.println("Informe número da conta à depositar: ");
        String numeroConta = teclado.nextLine();
        System.out.println("Informe o valor a ser depositado: [Exemplo: 1.10 ] ");
        String valor = teclado.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(Integer.parseInt(numeroConta))) {
                conta.depositar(Double.parseDouble(valor));
                System.out.println("Realizado deposito de R$ " + valor + " na conta " + conta.getNumeroConta());
                System.out.println("Saldo total da conta: " + conta.getSaldo());
                break;
            }
        }
    }

    public static void saque() {
        System.out.println("Informe número da conta à sacar: ");
        String numeroConta = teclado.nextLine();
        System.out.println("Informe o valor a ser sacado: [Exemplo: 1.10 ] ");
        String valor = teclado.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(Integer.parseInt(numeroConta))) {
                conta.sacar(Double.parseDouble(valor));
                System.out.println("Realizado saque de R$ " + valor + " na conta " + conta.getNumeroConta());
                System.out.println("Saldo total da conta: " + conta.getSaldo());
                break;
            }
        }
    }

    public static void cadastraPix() {
        System.out.println("Informe número de conta para cadastrar PIX");
        String numeroConta = teclado.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(Integer.parseInt(numeroConta))) {
                if (conta instanceof Corrente) {
                    contasComPix.add(((Corrente) conta).CadastrarPix());
                    System.out.println("PIX criado para conta: " + conta.getNumeroConta());
                } else {
                    System.out.println("Essa conta é poupança, não pode ser criado PIX para a mesma");
                }
                break;
            }
        }
    }

    public static void extrato() {
        System.out.println("Informe número da conta à consultar extrato: ");
        String numeroConta = teclado.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(Integer.parseInt(numeroConta))) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                double saldo = 0.0;

        for (Operacao operacao : conta.getOperacoes()) {
            String data = sdf.format(operacao.getData());
            String tipo = operacao.getIdentificador();
            double valor = operacao.getValor();

            switch (tipo.toLowerCase()) {
                case "depósito":
                case "pix - entrada":
                    saldo += valor;
                    break;
                case "saque":
                case "pix - saída":
                case "pix out":
                    saldo += valor;
                    break;
                case "correção":
                    saldo *= (1 + valor);
                    break;
                default:
                    System.out.println("Tipo de operação desconhecido: " + tipo);
            }

            // Exibindo a operação e o saldo atualizado
            System.out.println(data + " " + tipo + " " + String.format("%.2f", valor));
            System.out.println("           Saldo " + String.format("%.2f", saldo));
        }
            }
        }
    }

    public static void aplicaCorrecaoMonetaria() {
        System.out.println("Informe a taxa da correção monetária: [Apenas números em %]");
        String taxa = teclado.next();
        System.out.println("Correção monetária de " + taxa + "aplicado a todas as contas poupanças!");
        for (Conta conta : contas) {
            if (conta instanceof Poupanca)
                ((Poupanca) conta).AplicaTxDeCorrecao(Double.parseDouble(taxa));
        }

    }

    public static void fazerPix() {
        System.out.println("Informe o CPF PIX da conta de origem:");
        String cpfOrigem = teclado.next();
        System.out.println("informe o cpf PIX da conta destino:");
        String cpfDestino = teclado.next();

        System.out.println("Informe o valor");
        String valor = teclado.next();

        for (Corrente contas : contasComPix) {
            if (contas.getCpf().equals(cpfOrigem)) {
                Corrente contaPixIn = contas;
                contaPixIn.ReceberPix(cpfOrigem, Double.parseDouble(valor));
            }

            if (contas.getCpf().equals(cpfDestino)) {
                Corrente contaPixOut = contas;
                contaPixOut.EfetuarPix(cpfDestino, Double.parseDouble(valor));
            }
        }
    }

    /* FUNÇÔES DE UTILIDADE GERAL */

    public static Integer utilGeradorDeNumeroDeconta() {
        Random random = new Random();
        int min = 10000;
        int max = 99999;
        return random.nextInt((max - min) + 1) + min;
    }

    public static void utilVerTodasContas() {
        for (Conta conta : contas) {
            System.out.println(conta.mostrarDetalhes());
        }
    }

    public static void verTodosPix() {
        for (Corrente conta : contasComPix) {
            System.out.println("Numero da conta: " + conta.getNumeroConta() + " Cpf: " + conta.getCpf());
        }
    }

}