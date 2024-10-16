package br.com.fiap.fintechg5.view.conta.cartao;

import br.com.fiap.fintechg5.commons.Bandeira;
import br.com.fiap.fintechg5.commons.TipoCartao;
import br.com.fiap.fintechg5.dao.conta.CartaoDao;
import br.com.fiap.fintechg5.entities.conta.Cartao;

import java.sql.SQLException;
import java.time.LocalDate;

public class CadastroCartaoView {
    public static void main(String[] args) {
        try {
            CartaoDao dao = new CartaoDao();
            Cartao cartao = new Cartao("João da Silva", TipoCartao.DEBITO.name(), "1234567812345", "123", LocalDate.parse("2024-01-02"), Bandeira.ELO.name());
            dao.create(cartao);
            dao.closeConnection();
            System.out.println("Cartão cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
