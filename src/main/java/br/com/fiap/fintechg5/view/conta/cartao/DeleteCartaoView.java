package br.com.fiap.fintechg5.view.conta.cartao;

import br.com.fiap.fintechg5.dao.conta.CartaoDao;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class DeleteCartaoView {
    public static void main(String[] args) {
        try {
            CartaoDao dao = new CartaoDao(); // Instanciando o DAO de Conta (ou Cartão, se houver um DAO específico)
            dao.deleteById(1); // Removendo o cartão com id 1
            dao.closeConnection(); // Fechando a conexão com o banco de dados
            System.out.println("Cartão Removido!");
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Exibindo erro de SQL, se houver
        } catch (NotFoundException e) {
            System.err.println("Cartão não encontrado"); // Exibindo mensagem se o cartão não for encontrado
        }

    }
}
