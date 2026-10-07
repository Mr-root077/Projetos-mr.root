```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<>();

    // Classe Jogo
    static class Jogo {

        String nome;
        String plataforma;
        String genero;
        int ano;

        Jogo(String nome, String plataforma, String genero, int ano) {
            this.nome = nome;
            this.plataforma = plataforma;
            this.genero = genero;
            this.ano = ano;
        }

        void mostrarJogo(int id) {
            System.out.println("\n--------------------------------");
            System.out.println("ID: " + id);
            System.out.println("Nome: " + nome);
            System.out.println("Plataforma: " + plataforma);
            System.out.println("Gênero: " + genero);
            System.out.println("Ano: " + ano);
            System.out.println("--------------------------------");
        }
    }

    // Programa principal
    public static void main(String[] args) {

        // Jogos de exemplo
        jogos.add(new Jogo(
                "GTA V",
                "PC",
                "Ação",
                2013
        ));

        jogos.add(new Jogo(
                "Minecraft",
                "PC",
                "Sandbox",
                2011
        ));

        jogos.add(new Jogo(
                "FIFA 23",
                "PlayStation 4",
                "Esporte",
                2022
        ));

        int opcao;

        do {

            mostrarMenu();

            System.out.print("Digite uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Digite apenas números!");
                scanner.next();
                System.out.print("Digite uma opção: ");
            }

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
                    editarJogo();
                    break;

                case 6:
                    quantidadeJogos();
                    break;

                case 7:
                    System.out.println("\n================================");
                    System.out.println("     PROGRAMA ENCERRADO");
                    System.out.println("================================");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }

    // Menu
    static void mostrarMenu() {

        System.out.println("\n========================================");
        System.out.println("        🎮 SISTEMA DE JOGOS 🎮");
        System.out.println("========================================");
        System.out.println("1 - Cadastrar jogo");
        System.out.println("2 - Listar jogos");
        System.out.println("3 - Pesquisar jogo");
        System.out.println("4 - Remover jogo");
        System.out.println("5 - Editar jogo");
        System.out.println("6 - Quantidade de jogos");
        System.out.println("7 - Sair");
        System.out.println("========================================");
    }

    // Cadastrar
    static void cadastrarJogo() {

        System.out.println("\n========== CADASTRAR JOGO ==========");

        System.out.print("Nome do jogo: ");
        String nome = scanner.nextLine();

        if (nome.trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return;
        }

        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();

        if (plataforma.trim().isEmpty()) {
            System.out.println("Plataforma inválida!");
            return;
        }

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        if (genero.trim().isEmpty()) {
            System.out.println("Gênero inválido!");
            return;
        }

        System.out.print("Ano de lançamento: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Digite um ano válido!");
            scanner.next();
            System.out.print("Ano de lançamento: ");
        }

        int ano = scanner.nextInt();
        scanner.nextLine();

        if (ano < 1950 || ano > 2100) {
            System.out.println("Ano inválido!");
            return;
        }

        Jogo jogo = new Jogo(
                nome,
                plataforma,
                genero,
                ano
        );

        jogos.add(jogo);

        System.out.println("\n✅ Jogo cadastrado com sucesso!");
    }

    // Listar
    static void listarJogos() {

        System.out.println("\n========== LISTA DE JOGOS ==========");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (int i = 0; i < jogos.size(); i++) {

            jogos.get(i).mostrarJogo(i + 1);
        }
    }

    // Pesquisar
    static void pesquisarJogo() {

        System.out.println("\n========== PESQUISAR JOGO ==========");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        System.out.print("Digite o nome do jogo: ");

        String pesquisa = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < jogos.size(); i++) {

            Jogo jogo = jogos.get(i);

            if (jogo.nome
                    .toLowerCase()
                    .contains(pesquisa.toLowerCase())) {

                jogo.mostrarJogo(i + 1);

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\n❌ Jogo não encontrado.");
        }
    }

    // Remover
    static void removerJogo() {

        System.out.println("\n========== REMOVER JOGO ==========");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        listarJogos();

        System.out.print("\nDigite o ID do jogo para remover: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Digite um ID válido!");
            scanner.next();
            System.out.print("Digite o ID: ");
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if (id < 1 || id > jogos.size()) {

            System.out.println("❌ ID inválido!");

            return;
        }

        Jogo removido = jogos.remove(id - 1);

        System.out.println(
                "\n✅ O jogo \"" +
                removido.nome +
                "\" foi removido!"
        );
    }

    // Editar
    static void editarJogo() {

        System.out.println("\n========== EDITAR JOGO ==========");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        listarJogos();

        System.out.print("\nDigite o ID do jogo para editar: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Digite um ID válido!");
            scanner.next();
            System.out.print("Digite o ID: ");
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if (id < 1 || id > jogos.size()) {

            System.out.println("❌ ID inválido!");

            return;
        }

        Jogo jogo = jogos.get(id - 1);

        System.out.println("\nDeixe vazio para manter o valor atual.");

        System.out.print("Novo nome [" + jogo.nome + "]: ");
        String nome = scanner.nextLine();

        if (!nome.trim().isEmpty()) {
            jogo.nome = nome;
        }

        System.out.print(
                "Nova plataforma [" +
                jogo.plataforma +
                "]: "
        );

        String plataforma = scanner.nextLine();

        if (!plataforma.trim().isEmpty()) {
            jogo.plataforma = plataforma;
        }

        System.out.print(
                "Novo gênero [" +
                jogo.genero +
                "]: "
        );

        String genero = scanner.nextLine();

        if (!genero.trim().isEmpty()) {
            jogo.genero = genero;
        }

        System.out.print(
                "Novo ano [" +
                jogo.ano +
                "]: "
        );

        String anoTexto = scanner.nextLine();

        if (!anoTexto.trim().isEmpty()) {

            try {

                int novoAno = Integer.parseInt(anoTexto);

                if (novoAno >= 1950 && novoAno <= 2100) {

                    jogo.ano = novoAno;

                } else {

                    System.out.println("Ano inválido. Mantido o anterior.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ano inválido. Mantido o anterior."
                );
            }
        }

        System.out.println("\n✅ Jogo atualizado com sucesso!");
    }

    // Quantidade
    static void quantidadeJogos() {

        System.out.println("\n========== QUANTIDADE ==========");

        System.out.println(
                "Total de jogos cadastrados: " +
                jogos.size()
        );
    }
}
```
A