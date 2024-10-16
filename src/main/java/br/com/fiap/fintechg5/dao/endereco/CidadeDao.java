package br.com.fiap.fintechg5.dao.endereco;

import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;
import br.com.fiap.fintechg5.entities.endereco.Cidade;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class CidadeDao {

    private Connection conn;

    public CidadeDao () throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    public void create(final Cidade cidade) throws SQLException {
        String query = "INSERT INTO tb_cidade(estado, cidade, cep) VALUES (?,?,?)";

        try(PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setString(1, cidade.getEstado());
            stm.setString(2, cidade.getCidade());
            stm.setString(3, cidade.getCep());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Cidade getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_cidade WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("CIDADE NAO ENCONTRADA!");
        }

        Long idCidade = result.getLong("id");
        String estado = result.getString("estado");
        String cep = result.getString("cep");
        String nomeCidade = result.getString("cidade");

        return new Cidade(idCidade, estado, cep, nomeCidade);
    }

    public List<Cidade> getAll() throws SQLException {
        String query = "SELECT * FROM tb_cidade";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<Cidade> list = new ArrayList<>();

        while (result.next()) {
            Long idCidade = result.getLong("id");
            String estado = result.getString("estado");
            String cep = result.getString("cep");
            String nomeCidade = result.getString("cidade");
            list.add(new Cidade(idCidade, estado, cep, nomeCidade));
        }
        return list;
    }

    public void update(Cidade cidade) throws SQLException {
        String query = "UPDATE tb_cidade SET estado = ?, cep = ?, nome_cidade = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, cidade.getEstado());
        stm.setString(2, cidade.getCep());
        stm.setString(3, cidade.getCidade());
        stm.setLong(4, cidade.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_cidade WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
