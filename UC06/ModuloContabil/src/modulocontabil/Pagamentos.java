package modulocontabil;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {

    private String nomeEmpresa;
    private List<Imposto> impostos = new ArrayList<Imposto>();

    public Pagamentos() {
    }

    public Pagamentos(String _nomeEmpresa) {
        this.nomeEmpresa = _nomeEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Imposto> getImpostos() {
        return impostos;
    }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }
}