programa
{
	
cadeia nomeCliente, vegetariano, dieta, pagamento
	funcao inicio()
	{
		//solicitar o nome do cliente.
		escreva("Nome do cliente: ")
		leia(nomeCliente)

		//Perguntar se o cliente é vegetariano.
		escreva("Cliente vegetariano? (sim/nao): ")
		leia(vegetariano)
		
		//Perguntar se o cliente está de dieta.
		escreva("Cliente de dieta? (sim/nao): ")
		leia(dieta)

		escreva(" -----------------------\n")
		
		// Verificar se as resposta são válidas:
		// Se resposta for inválida, encerra o programa
		se ((vegetariano != "sim" e vegetariano != "nao") ou (dieta != "sim" e dieta != "nao"))
		{
			escreva("\nResposta inválida!\n")
		}
		//Se a resposta for válida, continua o programa.
		senao 
		{
			// Escreve o nome do cliente na tela.
			escreva("\nCliente: ", nomeCliente, "\n")

			// Verifica as respostas do cliente e mostra uma sugestão de prato.
			se (dieta == "sim" e vegetariano == "sim")
			{
			escreva("Sugestão de prato: Salada")
			}
			senao se (dieta == "sim" e vegetariano == "nao")
			{
			escreva("Sugestão de prato: Frango Grelhado")
			}
			senao se (dieta == "nao" e vegetariano == "sim")
			{
			escreva("Sugestão de prato: Macarrão")
			}
			senao // Se restar apenas dieta == "nao" e vegetariano == "nao", recomenda a feijoada.
			{
			escreva("Sugestão de prato: Feijoada")
			}
			
			escreva("\n\n -----------------------\n")

			// Perguntar a forma de pagamento.
			escreva("Qual a forma de pagamento? (dinheiro/cartao): ")
			leia(pagamento)
			
			// Verificar se a forma de pagamento é válida:
			// Se forma de pagamento for inválida, encerra o programa.
			se (pagamento != "dinheiro" e pagamento != "cartao")
			{
				escreva("\nForma de pagamento inválida!\n")
			}
			//Se a forma de pagamento for válida, continua o programa.
			senao
			{
				se (pagamento == "dinheiro")
				{
					escreva("\n **O cliente possui 15% de desconto**")
				}
			}
		}
	}
}
