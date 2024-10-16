package br.com.fiap.fintechg5.view.cliente.pessoafisica;

import br.com.fiap.fintechg5.dao.cliente.PessoaFisicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;

public class DeletePessoaFisicaView {
    public static void main(String[] args) {
        try {
            PessoaFisicaDao dao = new PessoaFisicaDao();
            PessoaFisica pf = dao.getById(1L);

            dao.deleteById(pf.getId());
            dao.closeConnection();
            System.out.println("Pessoa Fisica deletada!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
