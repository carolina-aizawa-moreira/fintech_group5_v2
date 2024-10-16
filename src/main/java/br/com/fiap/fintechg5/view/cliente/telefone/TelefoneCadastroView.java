package br.com.fiap.fintechg5.view.cliente.telefone;

import br.com.fiap.fintechg5.dao.cliente.TelefoneDao;
import br.com.fiap.fintechg5.entities.cliente.Telefone;
import br.com.fiap.fintechg5.commons.TipoContato;

import java.sql.SQLException;

public class TelefoneCadastroView {
    public static void main(String[] args) {
        try {
            TelefoneDao dao = new TelefoneDao();

            Telefone telefone = Telefone.builder()
                    .ddi(55)
                    .ddd(11)
                    .numeroTelefone("998450919")
                    .tipoContato(TipoContato.CELULAR)
                    .idCliente(22L)
                    .build();

            dao.create(telefone);
            dao.closeConnection();
            System.out.printf("Telefone do cliente_id %d cadastrado!", telefone.getIdCliente());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
