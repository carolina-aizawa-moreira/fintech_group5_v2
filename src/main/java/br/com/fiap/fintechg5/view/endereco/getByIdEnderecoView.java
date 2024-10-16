package br.com.fiap.fintechg5.view.endereco;

import br.com.fiap.fintechg5.dao.endereco.EnderecoDao;
import br.com.fiap.fintechg5.entities.endereco.Endereco;

import java.sql.SQLException;

public class getByIdEnderecoView {
    public static void main(String[] args) {
        try {
            EnderecoDao dao = new EnderecoDao();
            Endereco endereco = dao.getById(1L);
            dao.closeConnection();
            System.out.printf("id: %d, id_cidade: %d, id_cliente: %d, logradouro: %s, numero: %s," +
                    "bairro: %s, complemento: %s", endereco.getId(), endereco.getIdCidade(), endereco.getIdCliente(),
                    endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getComplemento());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
