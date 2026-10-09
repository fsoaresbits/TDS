package sistemarh;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaRH {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        DecimalFormat dinheiro = new DecimalFormat("0.00");

        Funcionario funcionarios[] = new Funcionario[10];
        int maximo = 10;
        int quantidade = 0;

        System.out.println("===============================================");
        System.out.println(" SISTEMA DE RH E FOLHA DE PAGAMENTO");
        System.out.println("===============================================");

        for (int i = 0; i < maximo; i++) {

            System.out.println();
            System.out.println("--- Cadastro do funcionário " + (i + 1) + " de " + maximo + " ---");

            System.out.print("Tipo (1 - Assalariado, 2 - Horista, 0 - Encerrar cadastros): ");
            int tipo = entrada.nextInt();
            entrada.nextLine();

            if (tipo == 0) {
                System.out.println("Cadastro encerrado.");
                break;
            }

            if (tipo != 1 && tipo != 2) {
                System.out.println("Tipo inválido! Este cadastro foi descartado.");
                continue;
            }

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("CPF: ");
            String cpf = entrada.nextLine();

            System.out.print("Endereço: ");
            String endereco = entrada.nextLine();

            System.out.print("Telefone: ");
            String telefone = entrada.nextLine();

            System.out.print("Setor: ");
            String setor = entrada.nextLine();

            if (tipo == 1) {

                double salario = 0;
                do {
                    System.out.print("Salário mensal (R$): ");
                    salario = entrada.nextDouble();
                    if (salario <= 0) {
                        System.out.print("Salário inválido! Digite novamente (R$): ");
                    }
                } while (salario <= 0);

                funcionarios[quantidade] = new Assalariado(nome, cpf, endereco, telefone, setor, salario);
                quantidade = quantidade + 1;

            } else {

                int horas = 0;
                do {
                    System.out.print("Horas trabalhadas no mês: ");
                    horas = entrada.nextInt();
                    if (horas <= 0) {
                        System.out.print("Horas inválidas! Digite um número inteiro maior que zero: ");
                    }
                } while (horas <= 0);

                double valorHora = 0;
                do {
                    System.out.print("Valor da hora (R$): ");
                    valorHora = entrada.nextDouble();
                    if (valorHora <= 0) {
                        System.out.print("Valor da hora inválido! Digite novamente (R$): ");
                    }
                } while (valorHora <= 0);

                funcionarios[quantidade] = new Horista(nome, cpf, endereco, telefone, setor, horas, valorHora);
                quantidade = quantidade + 1;
            }

            System.out.println("Funcionário cadastrado com sucesso!");
        }

        for (int etapa = 1; etapa <= 2; etapa++) {

            System.out.println();
            System.out.println("===============================================");
            if (etapa == 1) {
                System.out.println(" PAGAMENTOS ANTES DO AUMENTO");
            } else {
                System.out.println(" PAGAMENTOS DEPOIS DO AUMENTO");
            }
            System.out.println("===============================================");

            if (quantidade == 0) {
                System.out.println("Nenhum funcionário cadastrado.");
                System.out.println();
                System.out.println("Nenhum funcionário cadastrado. Sistema encerrado.");
                entrada.close();
                return;
            }

            double total = 0;
            for (int i = 0; i < quantidade; i++) {
                System.out.println();
                System.out.println("Funcionário " + (i + 1) + ":");
                funcionarios[i].mostrarDados();
                System.out.println("   Pagamento: R$ " + dinheiro.format(funcionarios[i].calcularPagamento()));
                total = total + funcionarios[i].calcularPagamento();
            }

            System.out.println();
            System.out.println("Quantidade de funcionários: " + quantidade);
            System.out.println("Total da folha de pagamento: R$ " + dinheiro.format(total));

            if (etapa == 1) {

                double percentual = 0;
                do {
                    System.out.println();
                    System.out.print("Informe o percentual do aumento geral (ex.: 10 para 10%): ");
                    percentual = entrada.nextDouble();
                    if (percentual < 0) {
                        System.out.print("Percentual inválido! Digite novamente (ex.: 10): ");
                    }
                } while (percentual < 0);

                for (int i = 0; i < quantidade; i++) {
                    funcionarios[i].aplicarAumento(percentual);
                }

                System.out.println("Aumento de " + percentual + "% aplicado a todos os funcionários.");
            }
        }

        entrada.close();
    }
}