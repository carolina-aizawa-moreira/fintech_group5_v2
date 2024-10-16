package br.com.fiap.fintechg5.dao.metafinanceira;

import br.com.fiap.fintechg5.commons.StatusMetaFinanceira;
import br.com.fiap.fintechg5.entities.metafinanceira.MetaFinanceira;
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
public class MetaFinanceiraDao {

    private Connection conn;

    public MetaFinanceiraDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void create(final MetaFinanceira meta) throws SQLException {
        String query = "INSERT INTO tb_meta_financeira (id_cliente, meta_financeira, valor_meta_financeira, " +
                "data_meta_criada, data_meta_conclusao, status, descricao) VALUES (?, ?, ?, ?, ?,?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setLong(1, meta.getIdCliente());
            stm.setString(2, meta.getMetaFinanceira());
            stm.setDouble(3, meta.getValorMetaFinanceira());
            stm.setObject(4, meta.getDataMetaCriada());
            stm.setObject(5, meta.getDataMetaConclusao());
            stm.setString(6, meta.getStatus());
            stm.setString(7, meta.getDescricao());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MetaFinanceira getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_meta_financeira WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("META FINANCEIRA NÃO ENCONTRADA!");
        }

        Long metaId = result.getLong("id");
        Long idCliente = result.getLong("id_cliente");
        String metaFinanceira = result.getString("meta_financeira");
        Double valorMetaFinanceira = result.getDouble("valor_meta_financeira");
        LocalDate dataMetaCriada = result.getDate("data_meta_criada").toLocalDate();
        LocalDate dataMetaConclusao = result.getDate("data_meta_conclusao").toLocalDate();
        String status = result.getString("status");
        String descricao = result.getString("descricao");

        return new MetaFinanceira(metaId, idCliente, metaFinanceira, valorMetaFinanceira, dataMetaCriada,
                dataMetaConclusao, status, descricao);
    }

    public List<MetaFinanceira> getAll() throws SQLException {
        String query = "SELECT * FROM tb_meta_financeira";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<MetaFinanceira> list = new ArrayList<>();

        while (result.next()) {
            Long metaId = result.getLong("id");
            Long idCliente = result.getLong("id_cliente");
            String metaFinanceira = result.getString("meta_financeira");
            Double valorMetaFinanceira = result.getDouble("valor_meta_financeira");
            LocalDate dataMetaCriada = result.getDate("data_meta_criada").toLocalDate();
            LocalDate dataMetaConclusao = result.getDate("data_meta_conclusao").toLocalDate();
            String status = result.getString("status");
            String descricao = result.getString("descricao");
            list.add(new MetaFinanceira(metaId, idCliente, metaFinanceira, valorMetaFinanceira, dataMetaCriada,
                    dataMetaConclusao, status, descricao));
        }
        return list;
    }

    public void update(MetaFinanceira meta) throws SQLException {
        String query = "UPDATE tb_meta_financeira SET meta_financeira = ?, valor_meta_financeira = ?" +
                ", data_meta_criada = ?, data_meta_conclusao = ?, status = ?, descricao = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, meta.getMetaFinanceira());
        stm.setDouble(2, meta.getValorMetaFinanceira());
        stm.setObject(3, meta.getDataMetaCriada());
        stm.setObject(4, meta.getDataMetaConclusao());
        stm.setString(5, meta.getStatus());
        stm.setString(6, meta.getDescricao());
        stm.setLong(7, meta.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_meta_financeira WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}

