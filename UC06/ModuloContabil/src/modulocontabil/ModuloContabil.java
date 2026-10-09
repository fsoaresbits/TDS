package modulocontabil;

import java.util.Scanner;

public class ModuloContabil {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o nome da empresa: ");
        String nomeEmpresa = entrada.nextLine();

        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        String opcao = "";
        do {
            System.out.println("");
            System.out.println("Tipos de imposto: 1 - PIS | 2 - IPI");
            System.out.print("Informe o tipo de imposto ou \"pare\" para encerrar: ");
            opcao = entrada.nextLine().trim();

            switch (opcao) {
                case "1":
                    System.out.print("Informe o valor total de debito: R$ ");
                    double debito = Double.parseDouble(entrada.nextLine().replace(",", "."));
                    System.out.print("Informe o valor total de credito: R$ ");
                    double credito = Double.parseDouble(entrada.nextLine().replace(",", "."));

                    Pis pis = new Pis(debito, credito);
                    pagamentos.adicionarImposto(pis);
                    break;

                case "2":
                    System.out.print("Informe o valor do produto: R$ ");
                    double valorProduto = Double.parseDouble(entrada.nextLine().replace(",", "."));
                    System.out.print("Informe o valor do frete: R$ ");
                    double valorFrete = Double.parseDouble(entrada.nextLine().replace(",", "."));
                    System.out.print("Informe o valor do seguro: R$ ");
                    double valorSeguro = Double.parseDouble(entrada.nextLine().replace(",", "."));
                    System.out.print("Informe o valor de outras despesas: R$ ");
                    double outrasDespesas = Double.parseDouble(entrada.nextLine().replace(",", "."));
                    System.out.print("Informe a aliquota (%): ");
                    double aliquota = Double.parseDouble(entrada.nextLine().replace(",", "."));

                    Ipi ipi = new Ipi(valorProduto, valorFrete, valorSeguro,
                            outrasDespesas, aliquota);
                    pagamentos.adicionarImposto(ipi);
                    break;

                case "pare":
                    System.out.println("Encerrando o cadastro de impostos.");
                    break;

                default:
                    System.out.println("Opcao invalida! Escolha 1, 2 ou \"pare\".");
            }
        } while (!opcao.equals("pare"));

        System.out.println("");
        System.out.println("Impostos a pagar - " + pagamentos.getNomeEmpresa() + ":");

        for (Imposto imposto : pagamentos.getImpostos()) {
            System.out.println(imposto.descricao() + ": R$ "
                    + String.format("%.2f", imposto.calculaImposto()));
        }

        entrada.close();
    }
}