package padroesestruturais.composite;

import java.util.ArrayList;
import java.util.List;

public class Carteira extends ProdutoFinanceiro {

    private List<ProdutoFinanceiro> produtos;

    public Carteira(String descricao) {
        super(descricao);
        this.produtos = new ArrayList<>();
    }

    public void addProduto(ProdutoFinanceiro produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(ProdutoFinanceiro produto) {
        this.produtos.remove(produto);
    }

    @Override
    public double getSaldo() {
        double saldo = 0;
        for (ProdutoFinanceiro produto : produtos) {
            saldo += produto.getSaldo();
        }
        return saldo;
    }

    @Override
    public String getExtrato() {
        String saida = "Carteira: " + getDescricao() + " - Saldo: " + getSaldo() + "\n";
        for (ProdutoFinanceiro produto : produtos) {
            saida += produto.getExtrato();
        }
        return saida;
    }
}
