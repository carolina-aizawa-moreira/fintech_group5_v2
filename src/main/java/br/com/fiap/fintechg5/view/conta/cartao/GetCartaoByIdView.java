package br.com.fiap.fintechg5.view.conta.cartao;

import br.com.fiap.fintechg5.dao.conta.CartaoDao;
import br.com.fiap.fintechg5.entities.conta.Cartao;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class GetCartaoByIdView {
    public static void main(String[] args) {
        try {
            CartaoDao dao = new CartaoDao(); // Criando uma instância de CartaoDao
            Cartao cartao = dao.getById(1L); // Chamando o método pesquisar para obter o cartão
            System.out.println("ID: " + cartao.getId() +
                    ", Conta ID: " + cartao.getIdConta() +
                    ", Nome Impresso: " + cartao.getNomeImpresso() +
                    ", Tipo de Cartão: " + cartao.getTipoCartao() +
                    ", Número do Cartão: " + cartao.getNumeroCartao() +
                    ", CVV: " + cartao.getCvv() +
                    ", Data de Validade: " + cartao.getDataValidade() +
                    ", Bandeira: " + cartao.getBandeira() +
                    ", Ativo: " + (cartao.getAtivo()));
            dao.closeConnection(); // Fechando a conexão com o banco de dados
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Tratamento de exceções SQL
        } catch (NotFoundException e) {
            System.err.println("Cartão não encontrado"); // Mensagem de cartão não encontrado
        }

    }
}
