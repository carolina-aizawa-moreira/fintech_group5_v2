package br.com.fiap.fintechg5.view.endereco;

import br.com.fiap.fintechg5.dao.endereco.EnderecoDao;

public class DeleteEnderecoView {
    public static void main(String[] args) {
        try {
            EnderecoDao dao = new EnderecoDao();
            dao.deleteById(1L);
            dao.closeConnection();
            System.out.println("Endereco deletado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
