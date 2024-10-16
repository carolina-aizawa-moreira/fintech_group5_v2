package br.com.fiap.fintechg5.view.cliente.pessoafisica;

import br.com.fiap.fintechg5.dao.cliente.PessoaFisicaDao;
import br.com.fiap.fintechg5.entities.cliente.PessoaFisica;

import java.sql.SQLException;

public class CadastroPessoaFisicaView {
    public static void main(String[] args) {
        try {
            PessoaFisicaDao dao = new PessoaFisicaDao();
            PessoaFisica pf = PessoaFisica.builder()
                    .nome("Francisco da Silva")
                    .cpf("12345678922")
                    .rg("556669998")
                    .genero("Masculino")
                    .idCliente(22L)
                    .build();

            dao.create(pf);
            dao.closeConnection();
            System.out.println("Pessoa Fisica cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
