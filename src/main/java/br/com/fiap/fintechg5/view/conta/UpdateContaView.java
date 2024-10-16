package br.com.fiap.fintechg5.view.conta;

import br.com.fiap.fintechg5.dao.conta.ContaDao;
import br.com.fiap.fintechg5.entities.conta.Conta;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class UpdateContaView {
    public static void main(String[] args) {
        try {
            ContaDao dao = new ContaDao(); // Criando uma instância de ContaDao
            Conta conta = dao.getById(1L); // Pesquisando a conta com o ID 1

            // Atualizando os atributos da conta
            conta.setNumeroConta("12345678");
            conta.setNumeroAgencia("0001");
            conta.setTipoConta("Corrente");
            conta.setSaldoConta(new BigDecimal("1500.00"));
            conta.setDataAbertura(LocalDate.now());
            conta.setStatusConta("Ativa");
            conta.setAtivo(true);

            dao.update(conta);
            dao.closeConnection();
            System.out.println("Conta atualizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (NotFoundException e) {
            System.err.println("Conta não encontrada");
        }

    }
}
