package br.com.fiap.fintechg5.dao.cliente;

import br.com.fiap.fintechg5.entities.cliente.PessoaJuridica;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class PessoaJuridicaDao {
    private Connection conn;

    public PessoaJuridicaDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void create(final PessoaJuridica pj) throws SQLException {
        String query = "INSERT INTO tb_pessoa_juridica (nome_fantasia, cnpj, ramo_atividade, inscricao_estadual, " +
                "id_cliente) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1,pj.getNomeFantasia());
            stm.setString(2,pj.getCnpj());
            stm.setString(3, pj.getRamoAtividade());
            stm.setString(4, pj.getInscricaoEstadual());
            stm.setLong(5, pj.getIdCliente());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public PessoaJuridica getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_pessoa_juridica WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("PESSOA JURIDICA NAO ENCONTRADA!");
        }

        Long pjId = result.getLong("id");
        String nomeFantasia = result.getString("nome_fantasia");
        String cnpj = result.getString("cnpj");
        String ramoAtividade = result.getString("ramo_atividade");
        String inscricaoEstadual = result.getString("inscricao_estadual");
        Long idCliente = result.getLong("id_cliente");

        return new PessoaJuridica(pjId,nomeFantasia, cnpj, ramoAtividade, inscricaoEstadual,idCliente);
    }

    public List<PessoaJuridica> getAll() throws SQLException {
        String query = "SELECT * FROM tb_pessoa_juridica";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<PessoaJuridica> list = new ArrayList<>();

        while (result.next()) {
            Long pjId = result.getLong("id");
            String nomeFantasia = result.getString("nome_fantasia");
            String cnpj = result.getString("cnpj");
            String ramoAtividade = result.getString("ramo_atividade");
            String inscricaoEstadual = result.getString("inscricaoEstadual");
            Long idCliente = result.getLong("id_cliente");
            list.add(new PessoaJuridica(pjId, nomeFantasia, cnpj, ramoAtividade, inscricaoEstadual, idCliente));
        }
        return list;
    }

    public void update(PessoaJuridica pj) throws SQLException {
        String query = "UPDATE tb_pessoa_juridica SET nome_fantasia = ?, cnpj = ?, ramo_atividade = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, pj.getNomeFantasia());
        stm.setString(2, pj.getCnpj());
        stm.setString(3, pj.getRamoAtividade());
        stm.setLong(4, pj.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_pessoa_juridica WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
