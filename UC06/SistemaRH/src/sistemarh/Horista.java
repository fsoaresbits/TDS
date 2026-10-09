package sistemarh;

import java.text.DecimalFormat;

public class Horista extends Funcionario {
    private int horasTrabalhadas;
    private double valorHora;

    public Horista(String nome, String cpf, String endereco, String telefone,
            String setor, int horasTrabalhadas, double valorHora) {
        super(nome, cpf, endereco, telefone, setor);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public void aplicarAumento(double percentual) {
        valorHora = valorHora * (1 + percentual / 100);
    }

    @Override
    public void mostrarDados() {
        DecimalFormat dinheiro = new DecimalFormat("0.00");
        super.mostrarDados();
        System.out.println("   Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("   Valor da hora: R$ " + dinheiro.format(valorHora));
    }
}