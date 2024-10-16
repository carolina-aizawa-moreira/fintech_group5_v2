package br.com.fiap.fintechg5.view.cliente;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.commons.TipoCliente;

import java.sql.SQLException;
import java.time.LocalDate;

public class CreateClienteView {
    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();

            Cliente cliente = Cliente.builder()
                    .username("JoanaTest4")
                    .email("joana.teste4@email.com")
                    .senha("123456")
                    .dataNascimento(LocalDate.parse("1995-01-02"))
                    .tipoCliente(TipoCliente.PESSOA_JURIDICA.name())
                    .build();

            dao.create(cliente);
            dao.closeConnection();
            System.out.println("Cliente cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
