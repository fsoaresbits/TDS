package agenciadeviagens;

public class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantDias;
    private double taxaAdicional;
    private double porcentagem;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantDias, double taxaAdicional) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantDias = quantDias;
        this.taxaAdicional = taxaAdicional;
    }
    
    public double totalHospedagem() {
        return (this.getQuantDias() * this.hospedagem.getValorDiaria());
    }
    
    public static double valorLucro(double valor, double margem) {
        return valor + (valor * (margem / 100));
    }
    
    public double totalPacote() {
        return valorLucro((this.getTransporte().getValor() + this.totalHospedagem()), this.getPorcentagem()) + this.taxaAdicional;
    }
    
    public String infoPacote() {
        double valorViagem = (this.getTransporte().getValor() + this.totalHospedagem());
        double lucro = valorViagem * (this.getPorcentagem() / 100);
        
        return "Tipo de transporte: " + this.getTransporte().getTipo()
                + "\nHospedagem: " + this.getHospedagem().getDescricao()
                + "\nQuantidade de dias: " + this.getQuantDias() + " dias"
                + "\nValor do transporte + hospedagem: " + "USD$%.2f".formatted(valorViagem)
                + "\nDestino: " + this.getDestino()
                + "\n--------------------------------------------------"
                + "\nSua porcentagem de lucro: " + this.getPorcentagem()+ "%" + " (USD$%.2f".formatted(lucro) + ")"
                + "\nTaxa adicional: " + "USD$%.2f".formatted(this.getTaxaAdicional())
                + "\nValor total do pacote: " + "USD$%.2f".formatted(this.totalPacote());
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getQuantDias() {
        return quantDias;
    }

    public void setQuantDias(int quantDias) {
        this.quantDias = quantDias;
    }
    
    public double getTaxaAdicional() {
        return taxaAdicional;
    }

    public void setTaxaAdicional(double taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }

    public double getPorcentagem() {
        return porcentagem;
    }
    
    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
