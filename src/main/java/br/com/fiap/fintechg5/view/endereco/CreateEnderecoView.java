package br.com.fiap.fintechg5.view.endereco;

import br.com.fiap.fintechg5.dao.endereco.EnderecoDao;
import br.com.fiap.fintechg5.entities.endereco.Endereco;

import java.sql.SQLException;

public class CreateEnderecoView {
    public static void main(String[] args) {
        try {
            EnderecoDao dao = new EnderecoDao();

            Endereco endereco = Endereco.builder()
                    .idCliente(23L)
                    .logradouro("Rua Ficticia")
                    .complemento("none")
                    .numero("661")
                    .idCidade(1L)
                    .bairro("Bairro Ficticio")
                    .build();

            dao.create(endereco);
            dao.closeConnection();
            System.out.println("Endereco cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
