package br.com.fiap.fintechg5.dao.endereco;

import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;
import br.com.fiap.fintechg5.entities.endereco.Endereco;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class EnderecoDao {

    private Connection conn;

    public EnderecoDao () throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    public void create(final Endereco endereco) throws SQLException {
        String query = "INSERT INTO tb_endereco(id_cliente, id_cidade, logradouro, numero, bairro, complemento) " +
                "VALUES (?,?,?,?,?,?)";

        try(PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setLong(1, endereco.getIdCliente());
            stm.setLong(2, endereco.getIdCidade());
            stm.setString(3, endereco.getLogradouro());
            stm.setString(4, endereco.getNumero());
            stm.setString(5, endereco.getBairro());
            stm.setString(6, endereco.getComplemento());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Endereco getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_endereco WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("ENDERECO NAO ENCONTRADO!");
        }

        Long idEndereco = result.getLong("id");
        Long idCidade = result.getLong("id_cidade");
        Long idCliente = result.getLong("id_cliente");
        String logradouro = result.getString("logradouro");
        String numero = result.getString("numero");
        String complemento = result.getString("complemento");
        String bairro = result.getString("bairro");
        return new Endereco(idEndereco,idCidade, idCliente, logradouro, numero, complemento, bairro);
    }

    public List<Endereco> getAll() throws SQLException {
        String query = "SELECT * FROM tb_endereco";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<Endereco> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id");
            Long idCidade = result.getLong("id_cidade");
            Long idCliente = result.getLong("id_cliente");
            String logradouro = result.getString("logradouro");
            String numero = result.getString("numero");
            String complemento = result.getString("complemento");
            String bairro = result.getString("bairro");
            list.add(new Endereco(id,idCidade, idCliente, logradouro, numero, complemento, bairro));
        }
        return list;
    }

    public void update(Endereco endereco) throws SQLException {
        String query = "UPDATE tb_endereco SET logradouro = ?, numero = ?, complemento = ?, bairro = ? " +
                "WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, endereco.getLogradouro());
        stm.setString(2, endereco.getNumero());
        stm.setString(3, endereco.getComplemento());
        stm.setString(4, endereco.getBairro());
        stm.setLong(5, endereco.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_endereco WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }

}
