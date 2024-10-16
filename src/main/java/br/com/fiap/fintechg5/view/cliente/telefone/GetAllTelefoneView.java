package br.com.fiap.fintechg5.view.cliente.telefone;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.dao.cliente.TelefoneDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.entities.cliente.Telefone;

import java.sql.SQLException;
import java.util.List;

public class GetAllTelefoneView {
    public static void main(String[] args) {
        try {
            TelefoneDao dao = new TelefoneDao();
            List<Telefone> list = dao.getAll();

            list.forEach(tel -> System.out.printf("id: %d, numero_telefone: %s\n",
                    tel.getId(), tel.getNumeroTelefone()));

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
