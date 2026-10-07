import java.util.ArrayList;
import java.util.Scanner;

class Jogo {

    String nome;
    double preco;
    int estoque;

    Jogo(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    void mostrar() {
        System.out.println("----------------------------");
        System.out.println("🎮 Jogo: " + nome);
        System.out.printf("💰 Preço: R$ %.2f%n", preco);
        System.out.println("📦 Estoque: " + estoque);
    }
}

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {

            mostrarMenu();

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
                    comprarJogo();
                    break;

                case 5:
                    adicionarEstoque();
                    break;

                case 6:
                    removerJogo();
                    break;

                case 7:
                    System.out.println("\n👋 Sistema encerrado!");
                    break;

                default:
                    System.out.println("\n❌ Opção inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }

    // =========================
    // MENU
    // =========================

    static void mostrarMenu() {

        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("       🎮 GAME STORE JAVA");
        System.out.println("====================================");
        System.out.println("1 - Cadastrar jogo");
        System.out.println("2 - Listar jogos");
        System.out.println("3 - Pesquisar jogo");
        System.out.println("4 - Comprar jogo");
        System.out.println("5 - Adicionar estoque");
        System.out.println("6 - Remover jogo");
        System.out.println("7 - Sair");
        System.out.println("====================================");
    }

    // =========================
    // CADASTRAR
    // =========================

    static void cadastrarJogo() {

        System.out.println("\n===== CADASTRAR JOGO =====");

        System.out.print("Nome do jogo: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: R$ ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em estoque: ");
        int estoque = scanner.nextInt();
        scanner.nextLine();

        Jogo jogo = new Jogo(nome, preco, estoque);

        jogos.add(jogo);

        System.out.println("\n✅ Jogo cadastrado!");
    }

    // =========================
    // LISTAR
    // =========================

    static void listarJogos() {

        System.out.println("\n===== ESTOQUE =====");

        if (jogos.isEmpty()) {

            System.out.println("📦 Estoque vazio.");
            return;
        }

        for (int i = 0; i < jogos.size(); i++) {

            System.out.println("\nID: " + i);

            jogos.get(i).mostrar();
        }
    }

    // =========================
    // PESQUISAR
    // =========================

    static void pesquisarJogo() {

        System.out.println("\n===== PESQUISAR =====");

        System.out.print("Digite o nome do jogo: ");
        String pesquisa = scanner.nextLine();

        boolean encontrou = false;

        for (Jogo jogo : jogos) {

            if (jogo.nome.toLowerCase()
                    .contains(pesquisa.toLowerCase())) {

                jogo.mostrar();

                encontrou = true;
            }
        }

        if (!encontrou) {

            System.out.println("❌ Jogo não encontrado.");
        }
    }

    // =========================
    // COMPRAR
    // =========================

    static void comprarJogo() {

        System.out.println("\n===== COMPRAR JOGO =====");

        listarJogos();

        if (jogos.isEmpty()) {
            return;
        }

        System.out.print("\nDigite o ID do jogo: ");
        int id = scanner.nextInt();

        if (id < 0 || id >= jogos.size()) {

            System.out.println("❌ ID inválido.");
            return;
        }

        Jogo jogo = jogos.get(id);

        if (jogo.estoque <= 0) {

            System.out.println("❌ Jogo sem estoque.");
            return;
        }

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        if (quantidade <= 0) {

            System.out.println("❌ Quantidade inválida.");
            return;
        }

        if (quantidade > jogo.estoque) {

            System.out.println("❌ Não temos essa quantidade em estoque.");
            return;
        }

        double total = jogo.preco * quantidade;

        jogo.estoque -= quantidade;

        System.out.println("\n================================");
        System.out.println("        🧾 COMPRA");
        System.out.println("================================");
        System.out.println("Jogo: " + jogo.nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Preço unitário: R$ %.2f%n", jogo.preco);
        System.out.printf("TOTAL: R$ %.2f%n", total);
        System.out.println("================================");

        System.out.println("✅ Compra realizada!");
    }

    // =========================
    // ADICIONAR ESTOQUE
    // =========================

    static void adicionarEstoque() {

        System.out.println("\n===== ADICIONAR ESTOQUE =====");

        listarJogos();

        if (jogos.isEmpty()) {
            return;
        }

        System.out.print("\nDigite o ID do jogo: ");
        int id = scanner.nextInt();

        if (id < 0 || id >= jogos.size()) {

            System.out.println("❌ ID inválido.");
            return;
        }

        System.out.print("Quantidade para adicionar: ");
        int quantidade = scanner.nextInt();

        if (quantidade <= 0) {

            System.out.println("❌ Quantidade inválida.");
            return;
        }

        jogos.get(id).estoque += quantidade;

        System.out.println("✅ Estoque atualizado!");
    }

    // =========================
    // REMOVER
    // =========================

    static void removerJogo() {

        System.out.println("\n===== REMOVER JOGO =====");

        listarJogos();

        if (jogos.isEmpty()) {
            return;
        }

        System.out.print("\nDigite o ID do jogo: ");
        int id = scanner.nextInt();

        if (id < 0 || id >= jogos.size()) {

            System.out.println("❌ ID inválido.");
            return;
        }

        String nome = jogos.get(id).nome;

        jogos.remove(id);

        System.out.println("🗑️ " + nome + " foi removido.");
    }
}