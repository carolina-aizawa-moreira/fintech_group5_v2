package br.com.fiap.fintechg5.view.metafinanceira;

import br.com.fiap.fintechg5.dao.metafinanceira.MetaFinanceiraDao;
import br.com.fiap.fintechg5.entities.metafinanceira.MetaFinanceira;

import java.sql.SQLException;
import java.util.List;

public class GetAllMetaFinanceiraView {

    public static void main(String[] args) {
        try {
            MetaFinanceiraDao dao = new MetaFinanceiraDao();
            List<MetaFinanceira> list = dao.getAll();
            list.forEach(meta ->
                    System.out.printf("ID: %d, ID Cliente: %d, Meta Financeira: %s, Valor Meta Financeira: %.2f, " +
                                    "Data Meta Criada: %s, Data Meta Conclusao: %s, Status: %s, Descricao: %s%n",
                            meta.getId(), meta.getIdCliente(), meta.getMetaFinanceira(),
                            meta.getValorMetaFinanceira(), meta.getDataMetaCriada(),
                            meta.getDataMetaConclusao(), meta.getStatus(), meta.getDescricao()
                    )
            );
            dao.closeConnection();
        } catch (Exception e) {
            System.err.println("Erro ao buscar as metas financeiras: " + e.getMessage());
        }
    }
}
