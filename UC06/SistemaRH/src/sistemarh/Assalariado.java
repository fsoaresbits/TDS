package sistemarh;

import java.text.DecimalFormat;

public class Assalariado extends Funcionario {
    private double salario;

    public Assalariado(String nome, String cpf, String endereco, String telefone,
            String setor, double salario) {
        super(nome, cpf, endereco, telefone, setor);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularPagamento() {
        return salario;
    }

    @Override
    public void aplicarAumento(double percentual) {
        salario = salario * (1 + percentual / 100);
    }

    @Override
    public void mostrarDados() {
        DecimalFormat dinheiro = new DecimalFormat("0.00");
        super.mostrarDados();
        System.out.println("   Salário mensal: R$ " + dinheiro.format(salario));
    }
}