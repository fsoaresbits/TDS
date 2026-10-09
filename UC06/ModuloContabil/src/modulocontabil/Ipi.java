package modulocontabil;

public class Ipi implements Imposto {

    private double valorProduto;
    private double valorFrete;
    private double valorSeguro;
    private double valorOutrasDespesas;
    private double aliquota;

    public Ipi() {
    }

    public Ipi(double _valorProduto, double _valorFrete, double _valorSeguro,
            double _valorOutrasDespesas, double _aliquota) {
        this.valorProduto = _valorProduto;
        this.valorFrete = _valorFrete;
        this.valorSeguro = _valorSeguro;
        this.valorOutrasDespesas = _valorOutrasDespesas;
        this.aliquota = _aliquota;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(double valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    @Override
    public String descricao() {
        return "IPI";
    }

    @Override
    public double calculaImposto() {
        return (valorProduto + valorFrete + valorSeguro + valorOutrasDespesas)
                * (aliquota / 100);
    }
}