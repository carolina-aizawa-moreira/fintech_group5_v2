package br.com.fiap.fintechg5.view.cliente.pessoajuridica;

import br.com.fiap.fintechg5.dao.cliente.PessoaJuridicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaJuridica;

public class UpdatePessoaJuridicaView {
    public static void main(String[] args) {
         try{
            PessoaJuridicaDao dao = new PessoaJuridicaDao();
            PessoaJuridica pj = dao.getById(1L);

            pj.setNomeFantasia("Supermercado Joana");
            pj.setCnpj("111222333000124");
            pj.setRamoAtividade("Varejo");

            dao.update(pj);
            dao.closeConnection();
            System.out.printf("Pessoa Juridica - id %d - atualizada!", pj.getId());
        } catch(Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
