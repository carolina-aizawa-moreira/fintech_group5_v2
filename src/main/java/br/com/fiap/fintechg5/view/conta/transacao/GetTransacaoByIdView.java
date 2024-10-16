package br.com.fiap.fintechg5.view.conta.transacao;

import br.com.fiap.fintechg5.dao.conta.TransacaoFinanceiraDao;
import br.com.fiap.fintechg5.entities.conta.TransacaoFinanceira;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class GetTransacaoByIdView {
    public static void main(String[] args) {
        try {
            TransacaoFinanceiraDao dao = new TransacaoFinanceiraDao();
            TransacaoFinanceira transacao = dao.pesquisar(1);

            System.out.println("ID Transação: " + transacao.getId() +
                    ", Conta ID: " + transacao.getIdConta() +
                    ", Tipo de Transação: " + transacao.getTipoTransacao() +
                    ", Data: " + transacao.getDataTransacao() +
                    ", Valor: R$ " + transacao.getValorTransacao() +
                    ", Descrição: " + transacao.getDescricao() +
                    ", Status: " + transacao.getStatusTransacao());

            dao.closeConnection(); // Fechar a conexão com o banco de dados
            System.out.println("Transação pesquisada com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Tratamento de exceção SQL
        } catch (NotFoundException e) {
            System.err.println("Transação não encontrada");
        }
    }
}
