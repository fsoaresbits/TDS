package modulocontabil;

public class Pis implements Imposto {

    private double valorDebito;
    private double valorCredito;

    public Pis() {
    }

    public Pis(double _valorDebito, double _valorCredito) {
        this.valorDebito = _valorDebito;
        this.valorCredito = _valorCredito;
    }

    public double getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    @Override
    public String descricao() {
        return "PIS";
    }

    @Override
    public double calculaImposto() {
        return (valorDebito - valorCredito) * 0.0165;
    }
}