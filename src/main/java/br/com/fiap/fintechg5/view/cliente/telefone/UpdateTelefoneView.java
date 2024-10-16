package br.com.fiap.fintechg5.view.cliente.telefone;

import br.com.fiap.fintechg5.commons.TipoContato;
import br.com.fiap.fintechg5.dao.cliente.TelefoneDao;
import br.com.fiap.fintechg5.entities.cliente.Telefone;

public class UpdateTelefoneView {
    public static void main(String[] args) {
        try {
            TelefoneDao dao = new TelefoneDao();
            Telefone telefone = dao.getById(1L);
            telefone.setActive(false);
            telefone.setDdd(19);
            telefone.setDdi(55);
            telefone.setTipoContato(TipoContato.COMERCIAL.name());
            dao.update(telefone);

            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
