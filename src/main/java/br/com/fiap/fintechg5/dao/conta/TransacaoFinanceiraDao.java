package br.com.fiap.fintechg5.dao.conta;

import br.com.fiap.fintechg5.entities.conta.TransacaoFinanceira;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransacaoFinanceiraDao {
    private Connection conn;

    public TransacaoFinanceiraDao() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    public void create(TransacaoFinanceira transacao) throws SQLException {
        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO transacao_financeira (id_transacao_financeira, conta_id_conta, tipo_transacao, data_transacao, valor_transacao, descricao, status_transacao) " +
                        "VALUES (seq_transacao_financeira.nextval, ?, ?, ?, ?, ?, ?)"
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        stm.setLong(1, transacao.getIdConta()); // ID da conta relacionada
        stm.setString(2, transacao.getTipoTransacao()); // Tipo de transação (e.g., crédito, débito)
        stm.setDate(3, Date.valueOf(transacao.getDataTransacao().format(formatter))); // Data da transação
        stm.setBigDecimal(4, transacao.getValorTransacao()); // Valor da transação
        stm.setString(5, transacao.getDescricao()); // Descrição da transação
        stm.setString(6, transacao.getStatusTransacao()); // Status da transação (e.g., concluída, pendente)

        stm.executeUpdate(); // Executa a inserção
    }

    public TransacaoFinanceira pesquisar(long id) throws SQLException, NotFoundException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM transacao_financeira WHERE id_transacao_financeira = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("Transação não encontrada");
        }

        Long idTransacao = result.getLong("id_transacao_financeira");
        Long contaId = result.getLong("conta_id_conta");
        String tipoTransacao = result.getString("tipo_transacao");
        LocalDate dataTransacao = result.getDate("data_transacao").toLocalDate();
        BigDecimal valorTransacao = result.getBigDecimal("valor_transacao");
        String descricao = result.getString("descricao");
        String statusTransacao = result.getString("status_transacao");

        return new TransacaoFinanceira(idTransacao, contaId, tipoTransacao, dataTransacao, valorTransacao, descricao, statusTransacao);
    }


    public List<TransacaoFinanceira> getAll() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM transacao_financeira");
        ResultSet result = stm.executeQuery();
        List<TransacaoFinanceira> lista = new ArrayList<>();

        while (result.next()) {
            Long idTransacao = result.getLong("id_transacao_financeira");
            Long contaId = result.getLong("conta_id_conta");
            String tipoTransacao = result.getString("tipo_transacao");
            LocalDate dataTransacao = result.getDate("data_transacao").toLocalDate();
            BigDecimal valorTransacao = result.getBigDecimal("valor_transacao");
            String descricao = result.getString("descricao");
            String statusTransacao = result.getString("status_transacao");

            lista.add(new TransacaoFinanceira(idTransacao, contaId, tipoTransacao, dataTransacao, valorTransacao, descricao, statusTransacao));
        }
        return lista;
    }


}
