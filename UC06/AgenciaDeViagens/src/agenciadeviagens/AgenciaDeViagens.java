package agenciadeviagens;

import java.util.Scanner;

public class AgenciaDeViagens {

    public static void main(String[] args) {
        String nomeCliente = null, transporteCliente = null, hospedagemCliente = null, destinoCliente = null, formaPag = null;
        int opcaoTransporte = 0, opcaoHospedagem = 0, opcaoDestino = 0, quantDias = 0, opcaoTaxa, opcaoPagamento = 0;
        double valorTransporteCliente = 0, valorHospedagemCliente = 0, taxaAdicional = 0, cotacao = 0;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("====================== Agência de Viagens =========================");
        System.out.println("Qual é o nome do cliente?");
        nomeCliente = entrada.nextLine();
        
        while (opcaoTransporte != 1 && opcaoTransporte != 2 && opcaoTransporte != 3) {
        System.out.println("""
                           
                           Agora vamos preparar o pacote de viagem do seu cliente.
                           Qual transporte o cliente deseja viajar? (Digite um número para selecionar.)
                           |1. | Aéreo      | US$ 450,00|
                           |2. | Rodoviário | US$ 180,00|
                           |3. | Marítimo   | US$ 600,00|""");
        opcaoTransporte = entrada.nextInt();
            switch (opcaoTransporte) {
                case 1 -> {
                    transporteCliente = "Aéreo";
                    valorTransporteCliente = 450;
                }
                case 2 -> {
                    transporteCliente = "Rodoviário";
                    valorTransporteCliente = 180;
                }
                case 3 -> {
                    transporteCliente = "Marítimo";
                    valorTransporteCliente = 600;
                }
            }
        }
        
        while (opcaoHospedagem != 1 && opcaoHospedagem != 2 && opcaoHospedagem != 3) {
            System.out.println("""
                               
                               Qual hospedagem o cliente deseja ficar? (Digite um número para selecionar.
                               |1. |Hotel 3 estrelas (quarto standard) | US$  80,00/dia|
                               |2. |Hotel 4 estrelas (quarto luxo)     | US$ 120,00/dia|
                               |3. |Resort 5 estrelas (quarto premium) | US$ 180,00/dia|""");
            opcaoHospedagem = entrada.nextInt();
            switch (opcaoHospedagem) {
                case 1 -> {
                    hospedagemCliente = "Hotel 3 estrelas (quarto standard)";
                    valorHospedagemCliente = 80;
                }
                case 2 -> {
                    hospedagemCliente = "Hotel 4 estrelas (quarto luxo)";
                    valorHospedagemCliente = 120;
                }
                case 3 -> {
                    hospedagemCliente = "Resort 5 estrelas (quarto premium)";
                    valorHospedagemCliente = 180;
                }
            }
        }

        while (opcaoDestino != 1 && opcaoDestino != 2 && opcaoDestino != 3) {
            System.out.println("""
                               
                               Qual hospedagem o cliente deseja ficar? (Digite um número para selecionar).
                               |1. |Buenos Aires |
                               |2. |Santiago     |
                               |3. |Cancún       |""");
            opcaoDestino = entrada.nextInt();
            switch (opcaoDestino) {
                case 1 -> {
                destinoCliente = "Buenos Aires";
                }
                case 2 -> {
                destinoCliente = "Santiago";
                }
                case 3 -> {
                destinoCliente = "Cancún";
                }
            }
        }

        do {
            System.out.println("\nQuantos dias o cliente deseja ficar em " + destinoCliente + "?");
            quantDias = entrada.nextInt();
        } while (quantDias <= 0);

        do {
            System.out.println("\nO seu cliente deseja adicionar o \"Seguro Viagem\" por uma taxa adicional de +US$ 40,00? (1 = Sim ou 2 = Não)");
            opcaoTaxa = entrada.nextInt();
        } while (opcaoTaxa != 1 && opcaoTaxa != 2);
        
        
        if (opcaoTaxa == 1) {
            taxaAdicional = 40;
        }        
        
        Transporte transporte = new Transporte(transporteCliente, valorTransporteCliente);
        Hospedagem hospedagem = new Hospedagem(hospedagemCliente, valorHospedagemCliente);
        PacoteViagem pacoteViagem = new PacoteViagem(transporte, hospedagem, destinoCliente, quantDias, taxaAdicional);
        
        int porcentagem;
        do {
            System.out.println("\nDigite a sua porcentagem de lucro de \"1\" à \"100\" ");
            porcentagem = entrada.nextInt();
        }
        while (porcentagem > 100 && porcentagem < 0);
        
        pacoteViagem.setPorcentagem(porcentagem);
        
        System.out.println("\n===== Informações do pacote =====");
        System.out.println(pacoteViagem.infoPacote() + "\n");
        
        Venda venda = new Venda(nomeCliente, pacoteViagem);
        
        System.out.println("Agora, finalize a venda do pacote de viagem.");
        while (opcaoPagamento != 1 && opcaoPagamento != 2 && opcaoPagamento != 3 && opcaoPagamento != 4) {
            System.out.println("Selecione a forma de pagamento:"
                    + "\n|1. |Dinheiro |"
                    + "\n|2. |Pix      |"
                    + "\n|3. |Débito   |"
                    + "\n|4. |Crédito  |"
            );
            opcaoPagamento = entrada.nextInt();
            switch (opcaoPagamento) {
                case 1 -> {
                    formaPag = "Dinheiro";
                }
                case 2 -> {
                    formaPag = "Pix";
                }
                case 3 -> {
                    formaPag = "Débito";
                }
                case 4 -> {
                    formaPag = "Crédito";
                }
            }
        }
        
        venda.setFormaPag(formaPag);
        
        System.out.println("\nDigite a cotação atual do dólar: (Utilize vírgular para separar as casas decimais)");
        cotacao = entrada.nextDouble();
        venda.setCotacao(cotacao);
        
        
        System.out.println("\n===== Informações da venda =====");
        System.out.println(
                "Nome do Cliente: " + venda.getNomeCliente()
                + "\nForma de pagamento: " + venda.getFormaPag()
                + "\n" + venda.getPacote().infoPacote()
                + "\n========================================================="
                + "\nCotação do dólar: " + venda.getCotacao()
        );
        venda.mostrarTotal();
        System.out.println("=========================================================");
    }
    
}
