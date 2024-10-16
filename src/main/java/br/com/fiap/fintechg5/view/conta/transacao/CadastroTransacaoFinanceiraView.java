package br.com.fiap.fintechg5.view.conta.transacao;

import br.com.fiap.fintechg5.commons.StatusTransacao;
import br.com.fiap.fintechg5.commons.TipoTransacao;
import br.com.fiap.fintechg5.dao.conta.TransacaoFinanceiraDao;
import br.com.fiap.fintechg5.entities.conta.TransacaoFinanceira;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class CadastroTransacaoFinanceiraView {
    public static void main(String[] args) {
        try {
            TransacaoFinanceiraDao dao = new TransacaoFinanceiraDao();
            TransacaoFinanceira transacao = new TransacaoFinanceira(TipoTransacao.PAGAMENTO.name(), LocalDate.now(), new BigDecimal("500.00"), "Pagamento de fatura", StatusTransacao.CONCLUIDA.name()
            );

            dao.create(transacao); // Cadastra a transação
            dao.closeConnection();
            System.out.println("Transação cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
