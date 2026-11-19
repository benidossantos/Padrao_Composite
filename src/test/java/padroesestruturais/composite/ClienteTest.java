package padroesestruturais.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveRetornarPatrimonioComCarteirasAninhadas() {
        Carteira rendaFixa = new Carteira("Renda Fixa");
        rendaFixa.addProduto(new Investimento("CDB", 1000.0));
        rendaFixa.addProduto(new Investimento("Tesouro Selic", 2000.0));

        Carteira rendaVariavel = new Carteira("Renda Variável");
        rendaVariavel.addProduto(new Investimento("Ações", 1500.0));

        Carteira principal = new Carteira("Patrimônio");
        principal.addProduto(rendaFixa);
        principal.addProduto(rendaVariavel);
        principal.addProduto(new Investimento("Poupança", 500.0));

        Cliente cliente = new Cliente("Maria");
        cliente.setPatrimonio(principal);

        assertEquals("Cliente: Maria\n" +
                "Carteira: Patrimônio - Saldo: 5000.0\n" +
                "Carteira: Renda Fixa - Saldo: 3000.0\n" +
                "Investimento: CDB - Saldo: 1000.0\n" +
                "Investimento: Tesouro Selic - Saldo: 2000.0\n" +
                "Carteira: Renda Variável - Saldo: 1500.0\n" +
                "Investimento: Ações - Saldo: 1500.0\n" +
                "Investimento: Poupança - Saldo: 500.0\n", cliente.getPatrimonio());
        assertEquals(5000.0, cliente.getSaldoTotal());
    }

    @Test
    void deveRetornarPatrimonioComUmInvestimento() {
        Cliente cliente = new Cliente("João");
        cliente.setPatrimonio(new Investimento("CDB", 1000.0));

        assertEquals("Cliente: João\nInvestimento: CDB - Saldo: 1000.0\n", cliente.getPatrimonio());
        assertEquals(1000.0, cliente.getSaldoTotal());
    }

    @Test
    void deveAtualizarSaldoAoRemoverProduto() {
        Investimento cdb = new Investimento("CDB", 1000.0);
        Carteira carteira = new Carteira("Renda Fixa");
        carteira.addProduto(cdb);
        carteira.addProduto(new Investimento("LCI", 700.0));

        carteira.removerProduto(cdb);

        assertEquals(700.0, carteira.getSaldo());
    }

    @Test
    void deveRetornarCarteiraVaziaComSaldoZero() {
        assertEquals(0.0, new Carteira("Vazia").getSaldo());
    }

    @Test
    void deveRetornarExcecaoClienteSemPatrimonio() {
        Cliente cliente = new Cliente("Ana");
        try {
            cliente.getPatrimonio();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Cliente sem patrimônio", e.getMessage());
        }
    }
}
