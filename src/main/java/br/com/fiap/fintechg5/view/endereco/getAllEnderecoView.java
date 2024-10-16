package br.com.fiap.fintechg5.view.endereco;

import br.com.fiap.fintechg5.dao.endereco.EnderecoDao;
import br.com.fiap.fintechg5.entities.endereco.Endereco;

import java.sql.SQLException;
import java.util.List;

public class getAllEnderecoView {
    public static void main(String[] args) {
        try {
            EnderecoDao dao = new EnderecoDao();

            List<Endereco> list = dao.getAll();

            list.forEach(end ->
                    System.out.printf("id: %d, id_cidade: %d, id_cliente: %d, logradouro: %s, numero: %s," +
                            "bairro: %s, complemento: %s", end.getId(), end.getIdCidade(), end.getIdCliente(),
                            end.getLogradouro(), end.getNumero(), end.getBairro(), end.getComplemento()));

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
