package br.com.fiap.fintechg5.dao.despesa;

import br.com.fiap.fintechg5.entities.despesa.Despesa;
import br.com.fiap.fintechg5.factory.ConnectionFactory;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesaDao {

    private Connection conn;

    public DespesaDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void create(final Despesa despesa) throws SQLException {
        String query = "INSERT INTO tb_despesa (id_cliente, categoria, descricao, valor, emprestimo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setInt(1, despesa.getIdCliente());
            stm.setString(2, despesa.getCategoria());
            stm.setString(3, despesa.getDescricao());
            stm.setDouble(4, despesa.getValor());
            stm.setBoolean(5, despesa.isEmprestimo());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Despesa getById(final int id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_despesa WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setInt(1, id);

            ResultSet result = stm.executeQuery();

            if (!result.next()) {
                throw new NotFoundException("DESPESA NÃO ENCONTRADA!");
            }

            int idCliente = result.getInt("id_cliente");
            String categoria = result.getString("categoria");
            String descricao = result.getString("descricao");
            double valor = result.getDouble("valor");
            boolean emprestimo = result.getBoolean("emprestimo");

            return new Despesa(id, idCliente, categoria, descricao, valor, emprestimo);
        }
    }

    public List<Despesa> getAll() throws SQLException {
        String query = "SELECT * FROM tb_despesa";
        try (PreparedStatement stm = conn.prepareStatement(query)) {
            ResultSet result = stm.executeQuery();

            List<Despesa> list = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt("id");
                int idCliente = result.getInt("id_cliente");
                String categoria = result.getString("categoria");
                String descricao = result.getString("descricao");
                double valor = result.getDouble("valor");
                boolean emprestimo = result.getBoolean("emprestimo");

                list.add(new Despesa(id, idCliente, categoria, descricao, valor, emprestimo));
            }
            return list;
        }
    }

    public void update(Despesa despesa) throws SQLException {
        String query = "UPDATE tb_despesa SET categoria = ?, descricao = ?, valor = ?, emprestimo = ? WHERE id = ?";

        try (PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setString(1, despesa.getCategoria());
            stm.setString(2, despesa.getDescricao());
            stm.setDouble(3, despesa.getValor());
            stm.setBoolean(4, despesa.isEmprestimo());
            stm.setLong(5, despesa.getId());

            stm.executeUpdate();
        }
    }

    public void deleteById(final int id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_despesa WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setInt(1, id);
            int line = stm.executeUpdate();

            if (line == 0) {
                throw new NotFoundException("Registro não encontrado!");
            }
        }
    }
}

