package br.com.fiap.fintechg5.view.metafinanceira;

import br.com.fiap.fintechg5.commons.StatusMetaFinanceira;
import br.com.fiap.fintechg5.dao.metafinanceira.MetaFinanceiraDao;
import br.com.fiap.fintechg5.entities.metafinanceira.MetaFinanceira;

import java.time.LocalDate;

public class UpdateMetaFinanceiraView {
    public static void main(String[] args) {
        try {
            MetaFinanceiraDao dao = new MetaFinanceiraDao();

            MetaFinanceira metaAtualizada = new MetaFinanceira();
            metaAtualizada.setMetaFinanceira("Nova Meta Atualizada");
            metaAtualizada.setValorMetaFinanceira(1500.00);
            metaAtualizada.setDataMetaCriada(LocalDate.of(2024, 10, 1));
            metaAtualizada.setDataMetaConclusao(LocalDate.of(2024, 12, 31));
            metaAtualizada.setStatus(StatusMetaFinanceira.EM_ANDAMENTO.name());
            metaAtualizada.setDescricao("Descrição atualizada da meta financeira.");

            dao.update(metaAtualizada);
            System.out.println("Meta financeira atualizada com sucesso!");

            dao.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
