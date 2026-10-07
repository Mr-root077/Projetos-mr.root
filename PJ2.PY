import json
import os

ARQUIVO = "alunos.json"


def carregar_alunos():
    if os.path.exists(ARQUIVO):
        with open(ARQUIVO, "r", encoding="utf-8") as arquivo:
            return json.load(arquivo)

    return []


def salvar_alunos(alunos):
    with open(ARQUIVO, "w", encoding="utf-8") as arquivo:
        json.dump(alunos, arquivo, indent=4, ensure_ascii=False)


def cadastrar_aluno(alunos):
    print("\n===== CADASTRAR ALUNO =====")

    nome = input("Nome: ")
    idade = input("Idade: ")

    try:
        nota1 = float(input("Nota 1: "))
        nota2 = float(input("Nota 2: "))
        nota3 = float(input("Nota 3: "))
    except ValueError:
        print("Digite apenas números nas notas.")
        return

    media = (nota1 + nota2 + nota3) / 3

    if media >= 7:
        situacao = "Aprovado"
    elif media >= 5:
        situacao = "Recuperação"
    else:
        situacao = "Reprovado"

    aluno = {
        "nome": nome,
        "idade": idade,
        "nota1": nota1,
        "nota2": nota2,
        "nota3": nota3,
        "media": round(media, 2),
        "situacao": situacao
    }

    alunos.append(aluno)
    salvar_alunos(alunos)

    print("\nAluno cadastrado com sucesso!")
    print(f"Média: {media:.2f}")
    print(f"Situação: {situacao}")


def listar_alunos(alunos):
    print("\n===== LISTA DE ALUNOS =====")

    if not alunos:
        print("Nenhum aluno cadastrado.")
        return

    for i, aluno in enumerate(alunos, start=1):
        print(f"\nAluno {i}")
        print(f"Nome: {aluno['nome']}")
        print(f"Idade: {aluno['idade']}")
        print(f"Média: {aluno['media']}")
        print(f"Situação: {aluno['situacao']}")


def pesquisar_aluno(alunos):
    print("\n===== PESQUISAR ALUNO =====")

    nome_pesquisa = input("Digite o nome: ").lower()

    encontrados = []

    for aluno in alunos:
        if nome_pesquisa in aluno["nome"].lower():
            encontrados.append(aluno)

    if not encontrados:
        print("Aluno não encontrado.")
        return

    for aluno in encontrados:
        print("\nAluno encontrado:")
        print(f"Nome: {aluno['nome']}")
        print(f"Idade: {aluno['idade']}")
        print(f"Nota 1: {aluno['nota1']}")
        print(f"Nota 2: {aluno['nota2']}")
        print(f"Nota 3: {aluno['nota3']}")
        print(f"Média: {aluno['media']}")
        print(f"Situação: {aluno['situacao']}")


def remover_aluno(alunos):
    print("\n===== REMOVER ALUNO =====")

    nome = input("Digite o nome do aluno: ").lower()

    for aluno in alunos:
        if aluno["nome"].lower() == nome:
            alunos.remove(aluno)
            salvar_alunos(alunos)
            print("Aluno removido com sucesso!")
            return

    print("Aluno não encontrado.")


def menu():
    alunos = carregar_alunos()

    while True:
        print("\n")
        print("================================")
        print("     SISTEMA DE ALUNOS")
        print("================================")
        print("1 - Cadastrar aluno")
        print("2 - Listar alunos")
        print("3 - Pesquisar aluno")
        print("4 - Remover aluno")
        print("5 - Sair")
        print("================================")

        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_aluno(alunos)

        elif opcao == "2":
            listar_alunos(alunos)

        elif opcao == "3":
            pesquisar_aluno(alunos)

        elif opcao == "4":
            remover_aluno(alunos)

        elif opcao == "5":
            print("Programa encerrado.")
            break

        else:
            print("Opção inválida.")


if __name__ == "__main__":
    menu()