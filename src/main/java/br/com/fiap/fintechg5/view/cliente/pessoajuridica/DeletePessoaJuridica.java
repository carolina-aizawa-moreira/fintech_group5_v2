package br.com.fiap.fintechg5.view.cliente.pessoajuridica;

import br.com.fiap.fintechg5.dao.cliente.PessoaJuridicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaJuridica;

public class DeletePessoaJuridica {
    public static void main(String[] args) {
        try{
            PessoaJuridicaDao dao = new PessoaJuridicaDao();
            PessoaJuridica pj = dao.getById(1L);
            dao.deleteById(pj.getId());
            dao.closeConnection();
            System.out.printf("Pessoa Juridica deletada\n!");
        } catch(Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
