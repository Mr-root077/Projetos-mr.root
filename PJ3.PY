import json
import os

ARQUIVO = "estoque.json"


def carregar_produtos():
    if os.path.exists(ARQUIVO):
        with open(ARQUIVO, "r", encoding="utf-8") as arquivo:
            return json.load(arquivo)

    return []


def salvar_produtos(produtos):
    with open(ARQUIVO, "w", encoding="utf-8") as arquivo:
        json.dump(produtos, arquivo, indent=4, ensure_ascii=False)


def cadastrar_produto(produtos):
    print("\n===== CADASTRAR PRODUTO =====")

    nome = input("Nome do produto: ")

    try:
        preco = float(input("Preço: R$ "))
        quantidade = int(input("Quantidade: "))
    except ValueError:
        print("Digite valores válidos.")
        return

    produto = {
        "nome": nome,
        "preco": preco,
        "quantidade": quantidade
    }

    produtos.append(produto)
    salvar_produtos(produtos)

    print("\nProduto cadastrado com sucesso!")


def listar_produtos(produtos):
    print("\n===== ESTOQUE =====")

    if not produtos:
        print("Nenhum produto cadastrado.")
        return

    for i, produto in enumerate(produtos, start=1):
        valor_total = produto["preco"] * produto["quantidade"]

        print(f"\nProduto {i}")
        print(f"Nome: {produto['nome']}")
        print(f"Preço: R$ {produto['preco']:.2f}")
        print(f"Quantidade: {produto['quantidade']}")
        print(f"Valor em estoque: R$ {valor_total:.2f}")


def pesquisar_produto(produtos):
    print("\n===== PESQUISAR PRODUTO =====")

    pesquisa = input("Digite o nome: ").lower()

    encontrados = []

    for produto in produtos:
        if pesquisa in produto["nome"].lower():
            encontrados.append(produto)

    if not encontrados:
        print("Produto não encontrado.")
        return

    for produto in encontrados:
        print("\nProduto encontrado!")
        print(f"Nome: {produto['nome']}")
        print(f"Preço: R$ {produto['preco']:.2f}")
        print(f"Quantidade: {produto['quantidade']}")


def adicionar_estoque(produtos):
    print("\n===== ADICIONAR ESTOQUE =====")

    nome = input("Nome do produto: ").lower()

    for produto in produtos:
        if produto["nome"].lower() == nome:

            try:
                quantidade = int(input("Quantidade para adicionar: "))
            except ValueError:
                print("Digite um número válido.")
                return

            produto["quantidade"] += quantidade
            salvar_produtos(produtos)

            print("Estoque atualizado!")
            print(f"Nova quantidade: {produto['quantidade']}")
            return

    print("Produto não encontrado.")


def remover_estoque(produtos):
    print("\n===== REMOVER ESTOQUE =====")

    nome = input("Nome do produto: ").lower()

    for produto in produtos:
        if produto["nome"].lower() == nome:

            try:
                quantidade = int(input("Quantidade para remover: "))
            except ValueError:
                print("Digite um número válido.")
                return

            if quantidade > produto["quantidade"]:
                print("Não existe essa quantidade no estoque.")
                return

            produto["quantidade"] -= quantidade
            salvar_produtos(produtos)

            print("Estoque atualizado!")
            print(f"Quantidade restante: {produto['quantidade']}")
            return

    print("Produto não encontrado.")


def excluir_produto(produtos):
    print("\n===== EXCLUIR PRODUTO =====")

    nome = input("Nome do produto: ").lower()

    for produto in produtos:
        if produto["nome"].lower() == nome:

            produtos.remove(produto)
            salvar_produtos(produtos)

            print("Produto excluído com sucesso!")
            return

    print("Produto não encontrado.")


def menu():
    produtos = carregar_produtos()

    while True:

        print("\n")
        print("======================================")
        print("       SISTEMA DE ESTOQUE")
        print("======================================")
        print("1 - Cadastrar produto")
        print("2 - Listar produtos")
        print("3 - Pesquisar produto")
        print("4 - Adicionar estoque")
        print("5 - Remover estoque")
        print("6 - Excluir produto")
        print("7 - Sair")
        print("======================================")

        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_produto(produtos)

        elif opcao == "2":
            listar_produtos(produtos)

        elif opcao == "3":
            pesquisar_produto(produtos)

        elif opcao == "4":
            adicionar_estoque(produtos)

        elif opcao == "5":
            remover_estoque(produtos)

        elif opcao == "6":
            excluir_produto(produtos)

        elif opcao == "7":
            print("\nSistema encerrado.")
            break

        else:
            print("Opção inválida!")


if __name__ == "__main__":
    menu()