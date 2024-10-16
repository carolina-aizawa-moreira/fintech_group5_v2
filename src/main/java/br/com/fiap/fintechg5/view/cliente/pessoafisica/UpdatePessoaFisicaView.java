package br.com.fiap.fintechg5.view.cliente.pessoafisica;

import br.com.fiap.fintechg5.dao.cliente.ClienteDao;
import br.com.fiap.fintechg5.dao.cliente.PessoaFisicaDao;
import br.com.fiap.fintechg5.entities.cliente.Cliente;
import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class UpdatePessoaFisicaView {
    public static void main(String[] args) {
        try {
            PessoaFisicaDao dao = new PessoaFisicaDao();

            PessoaFisica pf = dao.getById(1L);
            pf.setNome("Carmem Lucia");
            pf.setCpf("457987891");
            pf.setRg("485798200");

            dao.update(pf);
            System.out.printf("Pessoa Fisica - id: %d - atualizado\n", pf.getId());
            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
