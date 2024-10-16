package br.com.fiap.fintechg5.view.cliente;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class GetClienteByIdView {
    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();
            Cliente cliente = dao.getById(1L);
            System.out.printf("id: %d, username: %s", cliente.getId(), cliente.getUsername());
            dao.closeConnection();

            System.out.println("\nCliente Encontrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
