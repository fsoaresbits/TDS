programa
{
	real desconto = 0.0, valorGasto[6], valorFinal = 0.0, valorTotal = 0.0
	cadeia nomeClientes[6]
	inteiro cliente, clientesDesconto = 0
	
	funcao inicio()
	{
		// Perguntar ao usuário qual é o valor do desconto que será aplicado no dia.
		faca {
			escreva("Qual o valor do desconto do dia? ")
			leia(desconto)

			se (desconto < 0.0) {
				escreva("O valor do desconto não pode ser negativo!\n\n")
			}
		} enquanto (desconto < 0.0)

		escreva("\n -----------------------\n\n")
		
		// Coletar os dados de seis clientes, registrando o nome de cada um e o valor gasto na loja.
		para (cliente = 0; cliente < 6; cliente++) {
			enquanto (nomeClientes[cliente] == "") {
				escreva("Qual o nome do cliente? ")
				leia(nomeClientes[cliente])

				se (nomeClientes[cliente] == "") {
					escreva("O cliente precisa ter um nome!\n\n")
				}
			}

			faca {
				escreva("Quanto " + nomeClientes[cliente] + " gastou na loja? ")
				leia(valorGasto[cliente])

				se (valorGasto[cliente] < 0.0) {
					escreva("O valor gasto não pode ser negativo!\n\n")
				}
			} enquanto (valorGasto[cliente] < 0.0)
			escreva("\n")
		}

		escreva("\n -----------------------\n\n")
		
		// verificar, para cada um deles, se o valor gasto é superior a R$ 100,00.
		para (cliente = 0; cliente < 6; cliente++) {
			// Se for, o desconto do dia deve ser subtraído do valor final.
			se (valorGasto[cliente] >= 100.00) {
				escreva("-> " + nomeClientes[cliente] + " recebeu desconto.\n")
				valorFinal = valorGasto[cliente] - desconto
				escreva("Valor total (com o desconto): " + valorFinal, "\n")

				clientesDesconto++
			}
			// Se o cliente não atingir o valor mínimo para o desconto, deverá pagar o valor total de sua compra sem desconto.
			senao {
				escreva(nomeClientes[cliente] + " NÃO recebeu desconto.\n")
				valorFinal = valorGasto[cliente]
				escreva("Valor total: " + valorFinal, "\n")
			}

			// Somar todos os valores pagos pelos clientes.
			valorTotal += valorFinal

			escreva("\n")
		}

		escreva("\n -----------------------\n\n")

		// Mostrar o total de dinheiro recebido pela loja no dia e quantos clientes receberam o desconto.
		escreva(" Valor total recebido pela loja: " + valorTotal, "\n")
		escreva(" Quantos usuários tiveram desconto: " + clientesDesconto)
	}
}
