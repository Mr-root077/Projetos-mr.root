import java.util.Scanner;

class Conta {

    String titular;
    double saldo;

    Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("Valor invalido!");
        }
    }

    void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido!");
        } 
        else if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } 
        else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    void consultarSaldo() {
        System.out.println("-------------------------");
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.println("-------------------------");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("       BANCO JAVA");
        System.out.println("==============================");

        System.out.print("Digite o nome do titular: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o saldo inicial: R$ ");
        double saldoInicial = scanner.nextDouble();

        Conta conta = new Conta(nome, saldoInicial);

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("          MENU");
            System.out.println("==============================");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Mostrar titular");
            System.out.println("5 - Sair");
            System.out.println("==============================");

            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:

                    System.out.print("Digite o valor do deposito: R$ ");
                    double deposito = scanner.nextDouble();

                    conta.depositar(deposito);
                    break;

                case 3:

                    System.out.print("Digite o valor do saque: R$ ");
                    double saque = scanner.nextDouble();

                    conta.sacar(saque);
                    break;

                case 4:

                    System.out.println("Titular da conta: " + conta.titular);
                    break;

                case 5:

                    System.out.println("Obrigado por usar o Banco Java!");
                    break;

                default:

                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 5);

        scanner.close();
    }
}