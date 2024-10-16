package br.com.fiap.fintechg5.view.cliente.telefone;

import br.com.fiap.fintechg5.dao.cliente.TelefoneDao;

public class GetByIdTelefoneView {
    public static void main(String[] args) {
        try {
            TelefoneDao dao = new TelefoneDao();
            dao.getById(1L);
            dao.closeConnection();
            System.out.println("Telefone Encontrado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
