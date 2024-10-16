package br.com.fiap.fintechg5.view.conta;

import br.com.fiap.fintechg5.dao.conta.ContaDao;
import br.com.fiap.fintechg5.entities.conta.Conta;

import java.sql.SQLException;
import java.util.List;

public class GetAllContaView {
    public static void main(String[] args) {
        try {
            ContaDao dao = new ContaDao();
            List<Conta> contas = dao.getAll();

            for (Conta conta : contas) {
                System.out.println("ID: " + conta.getId() +
                        ", ID Cliente: " + conta.getIdCliente() +
                        ", Número da Conta: " + conta.getNumeroConta() +
                        ", Número da Agência: " + conta.getNumeroAgencia() +
                        ", Tipo de Conta: " + conta.getTipoConta() +
                        ", Saldo: R$ " + conta.getSaldoConta() +
                        ", Data de Abertura: " + conta.getDataAbertura() +
                        ", Status: " + conta.getStatusConta() +
                        ", Ativo: " + (conta.getAtivo() ? "Sim" : "Não"));
            }

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
