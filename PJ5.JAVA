import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            return true;
        }
        return false;
    }   

    public void mostrar() {
        System void mostrar() {
            System.out.println("_________________________________");
            System.out.println("ID: " + id);
            System.out.println("Nome: " + nome);
            System.out.printf("Preco: R$ %.2f%n", preco);
            System.out.println("Estoque: " + estoque);
            System.out.println("_________________________________");
        }

    }
}

class Cliente {
    private int id;
    private String nome;
    private String email;

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}

public void mostrar() {
    System.out.println("------------------------------------");
    System.out.println("ID: " + id);
    System.out.println("Nome: " + nome);
    System.out.println("Email: " + email);
    System.out.println("------------------------------------");
}

class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
}

