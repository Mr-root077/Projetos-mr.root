import math


def calculadora():
    while True:
        print("\n==============================")
        print("       CALCULADORA PYTHON")
        print("==============================")
        print("1 - Soma")
        print("2 - Subtração")
        print("3 - Multiplicação")
        print("4 - Divisão")
        print("5 - Potência")
        print("6 - Raiz quadrada")
        print("7 - Sair")
        print("==============================")

        opcao = input("Escolha uma opção: ")

        if opcao == "7":
            print("\nCalculadora encerrada!")
            break

        if opcao == "6":
            try:
                numero = float(input("Digite o número: "))

                if numero < 0:
                    print("Não é possível calcular raiz de número negativo.")
                else:
                    resultado = math.sqrt(numero)
                    print(f"\nResultado: {resultado}")

            except ValueError:
                print("Digite um número válido.")

        elif opcao in ["1", "2", "3", "4", "5"]:
            try:
                numero1 = float(input("Digite o primeiro número: "))
                numero2 = float(input("Digite o segundo número: "))

                if opcao == "1":
                    resultado = numero1 + numero2
                    operador = "+"

                elif opcao == "2":
                    resultado = numero1 - numero2
                    operador = "-"

                elif opcao == "3":
                    resultado = numero1 * numero2
                    operador = "×"

                elif opcao == "4":
                    if numero2 == 0:
                        print("Erro: não é possível dividir por zero.")
                        continue

                    resultado = numero1 / numero2
                    operador = "÷"

                elif opcao == "5":
                    resultado = numero1 ** numero2
                    operador = "^"

                print("\n==============================")
                print(f"{numero1} {operador} {numero2} = {resultado}")
                print("==============================")

            except ValueError:
                print("Digite apenas números.")

        else:
            print("Opção inválida!")


calculadora()