package br.com.fiap.fintechg5.view.endereco;

import br.com.fiap.fintechg5.dao.endereco.EnderecoDao;
import br.com.fiap.fintechg5.entities.endereco.Endereco;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class UpdateEnderecoView {
    public static void main(String[] args) {
        try {
            EnderecoDao dao = new EnderecoDao();

            Endereco end = dao.getById(1L);
            end.setBairro("Morumbi");

            dao.update(end);
            System.out.println("Endereco atualizado");
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
