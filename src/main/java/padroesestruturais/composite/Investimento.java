package padroesestruturais.composite;

public class Investimento extends ProdutoFinanceiro {

    private double saldo;

    public Investimento(String descricao, double saldo) {
        super(descricao);
        this.saldo = saldo;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public String getExtrato() {
        return "Investimento: " + getDescricao() + " - Saldo: " + saldo + "\n";
    }
}
