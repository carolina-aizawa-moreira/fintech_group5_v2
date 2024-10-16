package br.com.fiap.fintechg5.view.cliente.pessoafisica;

import br.com.fiap.fintechg5.dao.cliente.PessoaFisicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;

import java.util.List;

public class GetAllPessoaFisicaView {
    public static void main(String[] args) {
        try {
            PessoaFisicaDao dao = new PessoaFisicaDao();
            List<PessoaFisica> list = dao.getAll();

            for(PessoaFisica pf: list) {
                System.out.printf(
                        "id : %d, id_cliente : %d, nome: %s, genero: %s, cpf: %s, rg: %s",
                        pf.getId(), pf.getIdCliente(), pf.getNome(), pf.getGenero(), pf.getCpf(), pf.getRg()
                );
            }
            dao.closeConnection();
            System.out.println("\nListado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
