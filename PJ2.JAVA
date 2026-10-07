import java.util.ArrayList;
import java.util.Scanner;

class Jogo {
    String nome;
    String plataforma;
    int ano;

    Jogo(String nome, String plataforma, int ano) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.ano = ano;
    }

    void mostrarJogo() {
        System.out.println("-------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Ano: " + ano);
    }
}

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("     🎮 SISTEMA DE JOGOS");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar jogo");
            System.out.println("2 - Listar jogos");
            System.out.println("3 - Pesquisar jogo");
            System.out.println("4 - Remover jogo");
            System.out.println("5 - Sair");
            System.out.println("==============================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarJogo();
                    break;

                case 2:
                    listarJogos();
                    break;

                case 3:
                    pesquisarJogo();
                    break;

                case 4:
                    removerJogo();
                    break;

                case 5:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
    }

    // Cadastrar jogo
    static void cadastrarJogo() {

        System.out.println("\n--- CADASTRAR JOGO ---");

        System.out.print("Nome do jogo: ");
        String nome = scanner.nextLine();

        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();

        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        Jogo novoJogo = new Jogo(nome, plataforma, ano);

        jogos.add(novoJogo);

        System.out.println("✅ Jogo cadastrado com sucesso!");
    }

    // Listar jogos
    static void listarJogos() {

        System.out.println("\n--- LISTA DE JOGOS ---");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (int i = 0; i < jogos.size(); i++) {

            System.out.println("\nID: " + i);

            jogos.get(i).mostrarJogo();
        }
    }

    // Pesquisar jogo
    static void pesquisarJogo() {

        System.out.println("\n--- PESQUISAR JOGO ---");

        System.out.print("Digite o nome do jogo: ");
        String pesquisa = scanner.nextLine();

        boolean encontrado = false;

        for (Jogo jogo : jogos) {

            if (jogo.nome.toLowerCase().contains(pesquisa.toLowerCase())) {

                jogo.mostrarJogo();

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ Jogo não encontrado.");
        }
    }

    // Remover jogo
    static void removerJogo() {

        System.out.println("\n--- REMOVER JOGO ---");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        listarJogos();

        System.out.print("\nDigite o ID do jogo que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id >= 0 && id < jogos.size()) {

            String nome = jogos.get(id).nome;

            jogos.remove(id);

            System.out.println("🗑️ Jogo " + nome + " removido!");

        } else {

            System.out.println("❌ ID inválido.");
        }
    }
}