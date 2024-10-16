package br.com.fiap.fintechg5.dao.cliente;

import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class PessoaFisicaDao {
    private Connection conn;

    public PessoaFisicaDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void create(final PessoaFisica pf) throws SQLException {
        String query = "INSERT INTO tb_pessoa_fisica (nome, cpf, rg, genero, id_cliente) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, pf.getNome());
            stm.setString(2, pf.getCpf());
            stm.setString(3, pf.getRg());
            stm.setString(4, pf.getGenero());
            stm.setLong(5, pf.getIdCliente());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PessoaFisica getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_pessoa_fisica WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("PESSOA FISICA NAO ENCONTRADA!");
        }

        Long pfId = result.getLong("id");
        String nome = result.getString("nome");
        String cpf = result.getString("cpf");
        String rg = result.getString("rg");
        String genero = result.getString("genero");
        Long idCliente = result.getLong("id_cliente");

        return new PessoaFisica(pfId, nome, cpf, rg, genero, idCliente);
    }

    public List<PessoaFisica> getAll() throws SQLException {
        String query = "SELECT * FROM tb_pessoa_fisica";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<PessoaFisica> list = new ArrayList<>();

        while (result.next()) {
            Long pfId = result.getLong("id");
            String nome = result.getString("nome");
            String cpf = result.getString("cpf");
            String rg = result.getString("rg");
            String genero = result.getString("genero");
            Long idCliente = result.getLong("id_cliente");
            list.add(new PessoaFisica(pfId, nome, cpf, rg, genero, idCliente));
        }
        return list;
    }

    public void update(PessoaFisica pf) throws SQLException {
        String query = "UPDATE tb_pessoa_fisica SET nome = ?, cpf = ?, rg = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, pf.getNome());
        stm.setString(2, pf.getCpf());
        stm.setString(3, pf.getRg());
        stm.setLong(4, pf.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_pessoa_fisica WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
