package padroesestruturais.composite;

public abstract class ProdutoFinanceiro {

    private String descricao;

    public ProdutoFinanceiro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double getSaldo();

    public abstract String getExtrato();
}
