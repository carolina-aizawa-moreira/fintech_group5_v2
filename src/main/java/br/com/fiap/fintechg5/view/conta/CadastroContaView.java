package br.com.fiap.fintechg5.view.conta;

import br.com.fiap.fintechg5.commons.StatusConta;
import br.com.fiap.fintechg5.commons.TipoConta;
import br.com.fiap.fintechg5.dao.conta.ContaDao;
import br.com.fiap.fintechg5.entities.conta.Conta;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class CadastroContaView {
    public static void main(String[] args) {
        try {
            ContaDao contaDao = new ContaDao();
            Conta conta = new Conta(BigDecimal.valueOf(1000.50), "12345678", "9876",TipoConta.CORRENTE.name(), LocalDate.parse("2024-01-02"), StatusConta.ATIVA.name());
            contaDao.create(conta);
            contaDao.closeConnection();
            System.out.println("Conta cadastrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
