package br.com.fiap.fintechg5.view.cliente;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class DeleteClienteView {
    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();
            dao.deleteById(1L);
            dao.closeConnection();
            System.out.println("\nCliente deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
