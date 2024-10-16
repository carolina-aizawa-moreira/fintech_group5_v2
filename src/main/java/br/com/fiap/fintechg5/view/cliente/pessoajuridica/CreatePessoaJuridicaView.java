package br.com.fiap.fintechg5.view.cliente.pessoajuridica;

import br.com.fiap.fintechg5.dao.cliente.PessoaJuridicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaJuridica;

import java.sql.SQLException;

public class CreatePessoaJuridicaView {
    public static void main(String[] args) {
        try {
            PessoaJuridicaDao dao = new PessoaJuridicaDao();

            PessoaJuridica pj = PessoaJuridica.builder()
                    .nomeFantasia("Supermercado Joana")
                    .cnpj("111222333000124")
                    .inscricaoEstadual("123456")
                    .ramoAtividade("Varejo")
                    .idCliente(23L)
                    .build();

            dao.create(pj);
            dao.closeConnection();
            System.out.printf("Pessoa Fisica cadastrado para o cliente_id %d!", pj.getIdCliente());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
