package br.com.fiap.fintechg5.view.cliente.pessoafisica;

import br.com.fiap.fintechg5.dao.cliente.PessoaFisicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;

public class GetByIdPessoaFisicaView {
    public static void main(String[] args) {
        try {
            PessoaFisicaDao dao = new PessoaFisicaDao();
            PessoaFisica pf = dao.getById(1L);

            dao.closeConnection();

            System.out.printf("id : %d, id_cliente : %d, nome: %s, genero: %s, cpf: %s, rg: %s",
                    pf.getId(), pf.getIdCliente(), pf.getNome(), pf.getGenero(), pf.getCpf(), pf.getRg());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
