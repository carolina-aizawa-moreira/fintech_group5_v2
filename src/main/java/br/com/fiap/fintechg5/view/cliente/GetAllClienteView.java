package br.com.fiap.fintechg5.view.cliente;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;

import java.sql.SQLException;
import java.util.List;

public class GetAllClienteView {
    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();
            List<Cliente> list = dao.getAll();

            int i = 0;
            while (i < list.size()) {
                System.out.printf("id: %d, username: %s\n", list.get(i).getId(), list.get(i).getUsername());
                i++;
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
