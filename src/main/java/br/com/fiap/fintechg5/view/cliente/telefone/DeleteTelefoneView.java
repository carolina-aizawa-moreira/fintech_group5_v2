package br.com.fiap.fintechg5.view.cliente.telefone;

import br.com.fiap.fintechg5.dao.cliente.TelefoneDao;

public class DeleteTelefoneView {
    public static void main(String[] args) {
        try {
            TelefoneDao dao = new TelefoneDao();
            dao.deleteById(1L);

            System.out.println("Telefone deletado!");
            dao.closeConnection();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
