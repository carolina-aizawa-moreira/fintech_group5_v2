package br.com.fiap.fintechg5.view.conta;

import br.com.fiap.fintechg5.dao.conta.ContaDao;
import br.com.fiap.fintechg5.exceptions.NotFoundException;

import java.sql.SQLException;

public class DeleteContaView {
    public static void main(String[] args) {
        try {
            ContaDao dao = new ContaDao(); // Criando uma instância de ContaDao
            dao.deleteById(1); // Removendo a conta com ID 1
            dao.closeConnection(); // Fechando a conexão com o banco de dados
            System.out.println("Conta Removida!"); // Mensagem de confirmação
        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Tratamento de exceções SQL
        } catch (NotFoundException e) {
            System.err.println("Conta não encontrada"); // Mensagem de erro se a conta não for encontrada
        }

    }
}
