package br.com.fiap.fintechg5.view.cliente.pessoajuridica;

import br.com.fiap.fintechg5.dao.cliente.PessoaJuridicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaJuridica;

import java.util.List;

public class GetAllPessoaJuridicaView {
    public static void main(String[] args) {
        try {
            PessoaJuridicaDao dao = new PessoaJuridicaDao();
            List<PessoaJuridica> list = dao.getAll();

            for(PessoaJuridica pj: list) {
                System.out.printf("id : %d, id_cliente : %d, nome_fantasia: %s, cnpj: %s, inscricao_estadual: %s, " +
                                "ramo_atividade: %s", pj.getId(), pj.getIdCliente(), pj.getNomeFantasia(), pj.getCnpj(),
                        pj.getInscricaoEstadual(), pj.getRamoAtividade());
            }
            dao.closeConnection();
            System.out.println("\nListado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
