package br.com.fiap.fintechg5.dao.conta;

import br.com.fiap.fintechg5.entities.conta.Conta;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {
    private Connection conn;

    public ContaDao() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    public void create(final Conta conta) throws SQLException {

        PreparedStatement stm = conn.prepareStatement(
                "INSERT INTO conta (id_conta, saldo_conta, numero_conta, numero_agencia, tipo_conta, data_abertura, status_conta) " +
                        "VALUES (seq_conta.nextval, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)"
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        stm.setDouble(1, conta.getSaldoConta().doubleValue());
        stm.setString(2, conta.getNumeroConta());
        stm.setString(3, conta.getNumeroAgencia());
        stm.setString(4, conta.getTipoConta());
        stm.setDate(5, Date.valueOf(conta.getDataAbertura().format(formatter)));
        stm.setString(6, conta.getStatusConta());
        stm.executeUpdate();
    }

    public Conta getById(Long idConta) throws SQLException, NotFoundException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM tb_conta WHERE id = ?");
        stm.setLong(1, idConta);
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("Conta não encontrada");
        }

        Long contaId = result.getLong("id_conta");
        Long idCliente = result.getLong("id_cliente");
        BigDecimal saldo = result.getBigDecimal("saldo_conta");
        String numeroConta = result.getString("numero_conta");
        String numeroAgencia = result.getString("numero_agencia");
        String tipoConta = result.getString("tipo_conta");
        LocalDate dataAbertura = result.getDate("data_abertura").toLocalDate();
        String statusConta = result.getString("status_conta");
        Boolean ativo = result.getInt("ativo") == 1;


        return new Conta(contaId, idCliente, saldo, numeroConta, numeroAgencia, tipoConta, dataAbertura, statusConta, ativo);
    }

    public List<Conta> getAll() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM tb_conta");
        ResultSet result = stm.executeQuery();
        List<Conta> lista = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id_conta");
            Long idCliente = result.getLong("id_cliente");
            BigDecimal saldo = result.getBigDecimal("saldo_conta");
            String numeroConta = result.getString("numero_conta");
            String numeroAgencia = result.getString("numero_agencia");
            String tipoConta = result.getString("tipo_conta");
            LocalDate dataAbertura = result.getDate("data_abertura").toLocalDate();
            String statusConta = result.getString("status_conta");
            Boolean ativo = result.getInt("ativo") == 1; // Assume que 1 representa ativo

            lista.add(new Conta(id, idCliente, saldo, numeroConta, numeroAgencia, tipoConta, dataAbertura, statusConta, ativo));
        }

        return lista;
    }

    public void update(Conta conta) throws SQLException {
        PreparedStatement stm = conn.prepareStatement(
                "UPDATE tb_conta SET saldo_conta = ?, numero_conta = ?, numero_agencia = ?, tipo_conta = ?, data_abertura = ?, status_conta = ?, ativo = ? WHERE id_conta = ?"
        );
        stm.setBigDecimal(1, conta.getSaldoConta());
        stm.setString(2, conta.getNumeroConta());
        stm.setString(3, conta.getNumeroAgencia());
        stm.setString(4, conta.getTipoConta());
        stm.setDate(5, Date.valueOf(conta.getDataAbertura()));
        stm.setString(6, conta.getStatusConta());
        stm.setInt(7, conta.getAtivo() ? 1 : 0);
        stm.setLong(8, conta.getId());

        stm.executeUpdate();
    }

    public void deleteById(long id) throws SQLException, NotFoundException {
        PreparedStatement stm = conn.prepareStatement("DELETE FROM tb_conta WHERE id_conta = ?");
        stm.setLong(1, id);
        int linhasAfetadas = stm.executeUpdate(); // Executa a atualização
        if (linhasAfetadas == 0) {
            throw new NotFoundException("Conta não encontrada para ser removida");
        }
    }


}
