package br.com.fiap.fintechg5.dao.conta;

import br.com.fiap.fintechg5.entities.conta.Cartao;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CartaoDao {
    private Connection conn;

    public CartaoDao() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    public void create(Cartao cartao) throws SQLException {
        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO cartao (id_cartao, conta_id_conta, nome_impresso, tipo_cartao, numero_cartao, cvv, data_validade, bandeira, ativo) " +
                        "VALUES (seq_cartao.nextval, ?, ?, ?, ?, ?, ?, ?, ?)"
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        stm.setLong(1, cartao.getIdConta()); // ID da conta associada ao cartão
        stm.setString(2, cartao.getNomeImpresso()); // Nome impresso no cartão
        stm.setString(3, cartao.getTipoCartao()); // Tipo do cartão (Crédito, Débito, etc.)
        stm.setString(4, cartao.getNumeroCartao()); // Número do cartão
        stm.setString(5, cartao.getCvv()); // CVV do cartão
        stm.setDate(6, Date.valueOf(cartao.getDataValidade().format(formatter))); // Data de validade do cartão
        stm.setString(7, cartao.getBandeira()); // Bandeira do cartão (Visa, MasterCard, etc.)
        stm.setInt(8, cartao.getAtivo() ? 1 : 0); // Ativo (1) ou Inativo (0)
        stm.executeUpdate();
    }

    public Cartao getById(long id) throws SQLException, NotFoundException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM cartao WHERE id_cartao = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("Cartão não encontrado");
        }

        Long idCartao = result.getLong("id_cartao");
        Long contaId = result.getLong("conta_id_conta");
        String nomeImpresso = result.getString("nome_impresso");
        String tipoCartao = result.getString("tipo_cartao");
        String numeroCartao = result.getString("numero_cartao");
        String cvv = result.getString("cvv");
        LocalDate dataValidade = result.getDate("data_validade").toLocalDate();
        String bandeira = result.getString("bandeira");
        Boolean ativo = result.getInt("ativo") == 1;

        return new Cartao(idCartao, contaId, nomeImpresso, tipoCartao, numeroCartao, cvv, dataValidade, bandeira, ativo);
    }

    public List<Cartao> getAll() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM tb_cartao");
        ResultSet result = stm.executeQuery();
        List<Cartao> lista = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id_cartao");
            Long contaId = result.getLong("conta_id_conta");
            String nomeImpresso = result.getString("nome_impresso");
            String tipoCartao = result.getString("tipo_cartao");
            String numeroCartao = result.getString("numero_cartao");
            String cvv = result.getString("cvv");
            LocalDate dataValidade = result.getDate("data_validade").toLocalDate();
            String bandeira = result.getString("bandeira");
            Boolean ativo = result.getInt("ativo") == 1; // Supondo que 1 significa ativo

            lista.add(new Cartao(id, contaId, nomeImpresso, tipoCartao, numeroCartao, cvv, dataValidade, bandeira, ativo));
        }
        return lista;
    }

    public void deleteById(long id) throws SQLException, NotFoundException {
        PreparedStatement stm = conn.prepareStatement("DELETE FROM cartao WHERE id_cartao = ?");
        stm.setLong(1, id);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new NotFoundException("Cartão não encontrado para ser removido");
        }
    }



}
