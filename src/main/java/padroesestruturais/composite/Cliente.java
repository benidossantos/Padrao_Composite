package padroesestruturais.composite;

public class Cliente {

    private String nome;
    private ProdutoFinanceiro patrimonio;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void setPatrimonio(ProdutoFinanceiro patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getPatrimonio() {
        if (this.patrimonio == null) {
            throw new NullPointerException("Cliente sem patrimônio");
        }
        return "Cliente: " + nome + "\n" + this.patrimonio.getExtrato();
    }

    public double getSaldoTotal() {
        if (this.patrimonio == null) {
            throw new NullPointerException("Cliente sem patrimônio");
        }
        return this.patrimonio.getSaldo();
    }
}
