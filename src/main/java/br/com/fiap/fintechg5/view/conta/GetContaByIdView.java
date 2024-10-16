package br.com.fiap.fintechg5.view.conta;

import br.com.fiap.fintechg5.dao.conta.ContaDao;
import br.com.fiap.fintechg5.entities.conta.Conta;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class GetContaByIdView {
    public static void main(String[] args) {
        try {
            ContaDao dao = new ContaDao();
            Conta conta = dao.getById(1L);

            System.out.println("ID: " + conta.getId());
            System.out.println("ID Cliente: " + conta.getIdCliente());
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("Número da Agência: " + conta.getNumeroAgencia());
            System.out.println("Tipo de Conta: " + conta.getTipoConta());
            System.out.println("Saldo: R$ " + conta.getSaldoConta());
            System.out.println("Data de Abertura: " + conta.getDataAbertura());
            System.out.println("Status: " + conta.getStatusConta());
            System.out.println("Ativo: " + (conta.getAtivo()));

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (NotFoundException e) {
            System.err.println("Conta não existe na tabela");
        }

    }
}
