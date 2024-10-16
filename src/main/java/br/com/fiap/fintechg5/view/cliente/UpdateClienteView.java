package br.com.fiap.fintechg5.view.cliente;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class UpdateClienteView {
    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();

            Cliente cliente = dao.getById(1L);
            cliente.setUsername("Mariazinha1234");
            cliente.setSenha("123456");
            cliente.setEmail("maria.517@email.com");
            cliente.setActive(true);

            dao.update(cliente);
            System.out.printf("id: %d, username: %s atualizado", cliente.getId(), cliente.getUsername());
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
