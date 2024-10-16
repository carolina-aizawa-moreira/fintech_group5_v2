package br.com.fiap.fintechg5.view.conta.transacao;

import br.com.fiap.fintechg5.dao.conta.TransacaoFinanceiraDao;
import br.com.fiap.fintechg5.entities.conta.TransacaoFinanceira;

import java.sql.SQLException;
import java.util.List;

public class GetAllTransacaoView {
    public static void main(String[] args) {
        try {
            TransacaoFinanceiraDao dao = new TransacaoFinanceiraDao(); // Cria uma instância do DAO
            List<TransacaoFinanceira> transacoes = dao.getAll(); // Obtém todas as transações financeiras

            for (TransacaoFinanceira transacao : transacoes) { // Itera sobre a lista de transações
                System.out.println("ID Transação: " + transacao.getId() +
                        ", ID Conta: " + transacao.getIdConta() +
                        ", Tipo de Transação: " + transacao.getTipoTransacao() +
                        ", Data: " + transacao.getDataTransacao() +
                        ", Valor: R$ " + transacao.getValorTransacao() +
                        ", Descrição: " + transacao.getDescricao() +
                        ", Status: " + transacao.getStatusTransacao());
            }

            dao.closeConnection(); // Fecha a conexão
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Captura e exibe erros de SQL
        }
    }
}
