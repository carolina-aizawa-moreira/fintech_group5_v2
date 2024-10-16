package br.com.fiap.fintechg5.dao.investimento;

import br.com.fiap.fintechg5.entities.investimento.ProdutoFinanceiro;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class ProdutoFinanceiroDao {
    private Connection conn;

    public ProdutoFinanceiroDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void create(final ProdutoFinanceiro produto) throws SQLException {
        String query = "INSERT INTO tb_produto_financeiro (investimento_id, tipo_produto_financeiro, " +
                "descricao, nome_instituicao_financeira, data_final) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setLong(1, produto.getInvestimentoId());
            stm.setString(2, produto.getTipoProdutoFinanceiro());
            stm.setString(3, produto.getDescricao());
            stm.setString(4, produto.getNomeInstituicaoFinanceira());
            stm.setObject(5, produto.getDataFinal());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProdutoFinanceiro getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_produto_financeiro WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("PRODUTO FINANCEIRO NAO ENCONTRADO!");
        }

        Long produtoId = result.getLong("id");
        Long investimentoId = result.getLong("investimento_id");
        String tipoProdutoFinanceiro = result.getString("tipo_produto_financeiro");
        String descricao = result.getString("descricao");
        String nomeInstituicaoFinanceira = result.getString("nome_instituicao_financeira");
        LocalDate dataFinal = result.getDate("data_final").toLocalDate(); // Converte para LocalDate

        return new ProdutoFinanceiro(produtoId, investimentoId, tipoProdutoFinanceiro, descricao,
                nomeInstituicaoFinanceira, dataFinal.toString());
    }

    public List<ProdutoFinanceiro> getAll() throws SQLException {
        String query = "SELECT * FROM tb_produto_financeiro";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<ProdutoFinanceiro> list = new ArrayList<>();

        while (result.next()) {
            Long produtoId = result.getLong("id");
            Long investimentoId = result.getLong("investimento_id");
            String tipoProdutoFinanceiro = result.getString("tipo_produto_financeiro");
            String descricao = result.getString("descricao");
            String nomeInstituicaoFinanceira = result.getString("nome_instituicao_financeira");
            LocalDate dataFinal = result.getDate("data_final").toLocalDate();
            list.add(new ProdutoFinanceiro(produtoId, investimentoId, tipoProdutoFinanceiro, descricao,
                    nomeInstituicaoFinanceira, dataFinal.toString()));
        }
        return list;
    }

    public void update(ProdutoFinanceiro produto) throws SQLException {
        String query = "UPDATE tb_produto_financeiro SET tipo_produto_financeiro = ?, descricao = ?, nome_instituicao_financeira = ?, data_final = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, produto.getTipoProdutoFinanceiro());
        stm.setString(2, produto.getDescricao());
        stm.setString(3, produto.getNomeInstituicaoFinanceira());
        stm.setObject(4, produto.getDataFinal());
        stm.setLong(5, produto.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_produto_financeiro WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
