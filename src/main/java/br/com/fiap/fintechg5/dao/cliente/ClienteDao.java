package br.com.fiap.fintechg5.dao.cliente;

import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class ClienteDao {
    private Connection conn;

    public ClienteDao() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    //CREATE
    public void create(final Cliente cliente) throws SQLException {
        String query = "INSERT INTO tb_cliente (username, data_nascimento, email, senha, tipo_cliente) " +
                "VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?,?,?)";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1,cliente.getUsername());
            stm.setString(2,cliente.getDataNascimento().format(formatter));
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getSenha());
            stm.setString(5, cliente.getTipoCliente());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //READ
    public Cliente getById(final long id) throws SQLException, NotFoundException {
        String query = "SELECT * FROM tb_cliente WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        ResultSet result = stm.executeQuery();

        if(!result.next()) {
            throw new NotFoundException("CLIENTE NAO ENCONTRADO!");
        }

        Long clienteId = result.getLong("id");
        String username = result.getString("username");
        String email = result.getString("email");
        String senha = result.getString("senha");
        String tipoCliente = result.getString("tipo_cliente");
        String dataNascimento = result.getString("data_nascimento");
        String dataCadastro = result.getString("data_cadastro");
        Boolean active = result.getBoolean("active");

        return new Cliente(clienteId, username, dataNascimento, email, senha, tipoCliente,
                dataCadastro, active);
    }

    public List<Cliente> getAll() throws SQLException {
        String query = "SELECT * FROM tb_cliente";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet result = stm.executeQuery();

        List<Cliente> list = new ArrayList<>();

        while(result.next()) {
            Long clienteId = result.getLong("id");
            String username = result.getString("username");
            String email = result.getString("email");
            String senha = result.getString("senha");
            String tipoCliente = result.getString("tipo_cliente");
            String dataNascimento = result.getString("data_nascimento");
            String dataCadastro = result.getString("data_cadastro");
            Boolean active = result.getBoolean("active");
            list.add(new Cliente(clienteId, username, dataNascimento, email, senha, tipoCliente,
                    dataCadastro, active));
        }
        return list;
    }

    //UPDATE
    public void update(Cliente cliente) throws SQLException {
        String query = "UPDATE tb_cliente SET username = ?, senha = ?, email = ?, active = ? WHERE id = ?";

        PreparedStatement stm = conn.prepareStatement(query);

        stm.setString(1, cliente.getUsername());
        stm.setString(2, cliente.getSenha());
        stm.setString(3, cliente.getEmail());
        stm.setBoolean(4, cliente.getActive());
        stm.setLong(5, cliente.getId());
        stm.executeUpdate();
    }

    //DELETE
    public void deleteById(final long id) throws SQLException, NotFoundException {
        String query = "DELETE FROM tb_cliente WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setLong(1, id);

        int line = stm.executeUpdate();

        if(line == ZERO.intValue()) {
            throw new NotFoundException("Registro nao encontrado!");
        }
    }
}
