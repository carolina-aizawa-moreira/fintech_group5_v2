package br.com.fiap.fintechg5.dao.cliente;

import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;
import br.com.fiap.fintechg5.entities.cliente.Telefone;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class TelefoneDao {
    private Connection conn;

    public TelefoneDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void create(final Telefone telefone) throws SQLException {
        String query = "INSERT INTO tb_telefone (ddi, ddd, numero_telefone, tipo_contato, id_cliente) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1,telefone.getDdi());
            stm.setInt(2,telefone.getDdd());
            stm.setString(3, telefone.getNumeroTelefone());
            stm.setString(4, telefone.getTipoContato());
            stm.setLong(5, telefone.getIdCliente());

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

    public List<Telefone> getAll() throws SQLException {
        String query = "SELECT * FROM tb_telefone";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<Telefone> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id");
            Long idCliente = result.getLong("id_cliente");
            int ddi = result.getInt("ddi");
            int ddd = result.getInt("ddd");
            String numeroTelefone = result.getString("numeroTelefone");
            String tipoContato = result.getString("tipo_contato");
            Boolean active = result.getBoolean("active");
            list.add(new Telefone(id, idCliente, ddi, ddi, numeroTelefone, tipoContato, active));
        }
        return list;
    }

    public void update(Telefone telefone) throws SQLException {
        String query = "UPDATE tb_telefone SET ddi = ?, ddd = ?, numero_telefone = ?, tipo_contato = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setInt(1, telefone.getDdi());
        stm.setInt(2, telefone.getDdd());
        stm.setString(3, telefone.getNumeroTelefone());
        stm.setString(4, telefone.getTipoContato());
        stm.setLong(5, telefone.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_telefone WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
