package br.com.fiap.fintechg5.dao.investimento;

import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;
import br.com.fiap.fintechg5.entities.investimento.Investimento;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.math.BigInteger.ZERO;

public class InvestimentoDao {
    private Connection conn;

    public InvestimentoDao() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void create(final Investimento investimento) throws SQLException {
        String query = "INSERT INTO tb_investimento (id_cliente, tipo_investimento, valor_investido, " +
                "data_inicial, data_final) " +
                "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setLong(1, investimento.getIdCliente());
            stm.setString(2, investimento.getTipoInvestimento());
            stm.setDouble(3, investimento.getValorInvestido());
            stm.setString(4, investimento.getDataInicial().format(formatter));
            stm.setString(5, investimento.getDataFinal().format(formatter));

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Investimento getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_investimento WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new NotFoundException("INVESTIMENTO NAO ENCONTRADO!");
        }

        Long investimentoId = result.getLong("id");
        Long idCliente = result.getLong("id_cliente");
        String tipoInvestimento = result.getString("tipo_investimento");
        double valor = result.getDouble("valor_investido");
        LocalDate dataInicial = result.getDate("data_inicial").toLocalDate();
        LocalDate dataFinal = result.getDate("data_final").toLocalDate();

        return new Investimento(investimentoId, idCliente, tipoInvestimento, valor, dataInicial, dataFinal);
    }

    public List<Investimento> getAll() throws SQLException {
        String query = "SELECT * FROM tb_investimento";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<Investimento> list = new ArrayList<>();

        while (result.next()) {
            Long investimentoId = result.getLong("id");
            Long idCliente = result.getLong("id_cliente");
            String tipoInvestimento = result.getString("tipo_investimento");
            double valor = result.getDouble("valor_investido");
            LocalDate dataInicial = result.getDate("data_inicial").toLocalDate();
            LocalDate dataFinal = result.getDate("data_final").toLocalDate();

            list.add(new Investimento(investimentoId, idCliente, tipoInvestimento, valor, dataInicial, dataFinal));
        }
        return list;
    }

    public void update(Investimento investimento) throws SQLException {
        String query = "UPDATE tb_investimento SET valor_investido = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setDouble(1, investimento.getValorInvestido());
        stm.setLong(2, investimento.getId());
        stm.executeUpdate();
    }

    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_investimento WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if (line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
