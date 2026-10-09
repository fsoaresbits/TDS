package agenciadeviagens;

public class Venda {
    private String nomeCliente;
    private String formaPag;
    private PacoteViagem pacote;
    private double cotacao;

    public Venda(String nomeCliente, PacoteViagem pacote) {
        this.nomeCliente = nomeCliente;
        this.pacote = pacote;
    }

    public double converterParaReal(double dollar) {
        return dollar * this.cotacao; 
    }
    
    public void mostrarTotal() {
        
        System.out.println("Total final em dólar: " + "$%.2f".formatted(this.pacote.totalPacote())
                + "\nTotal final em reais: " + "R$%.2f".formatted(this.converterParaReal(this.pacote.totalPacote())));
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public PacoteViagem getPacote() {
        return pacote;
    }

    public void setPacote(PacoteViagem pacote) {
        this.pacote = pacote;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

}
