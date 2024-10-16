package br.com.fiap.fintechg5.view.conta.cartao;

import br.com.fiap.fintechg5.dao.conta.CartaoDao;
import br.com.fiap.fintechg5.entities.conta.Cartao;

import java.sql.SQLException;
import java.util.List;

public class GetAllCartaoView {
    public static void main(String[] args) {
        try {
            CartaoDao dao = new CartaoDao(); // Criando uma instância de CartaoDao
            List<Cartao> cartoes = dao.getAll(); // Chamando o método listar para obter os cartões

            for (Cartao cartao : cartoes) { // Iterando sobre a lista de cartões
                System.out.println("ID: " + cartao.getId() +
                        ", Conta ID: " + cartao.getIdConta() +
                        ", Nome Impresso: " + cartao.getNomeImpresso() +
                        ", Tipo de Cartão: " + cartao.getTipoCartao() +
                        ", Número do Cartão: " + cartao.getNumeroCartao() +
                        ", CVV: " + cartao.getCvv() +
                        ", Data de Validade: " + cartao.getDataValidade() +
                        ", Bandeira: " + cartao.getBandeira() +
                        ", Ativo: " + (cartao.getAtivo() ? "Sim" : "Não"));
            }

            dao.closeConnection(); // Fechando a conexão com o banco de dados
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Tratamento de exceções SQL
        }
    }
}
