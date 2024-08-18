package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.ItemPedidoEntidade;

public class ItemPedidoDAO extends BaseDAO<ItemPedidoEntidade> {

    public ItemPedidoDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<ItemPedidoEntidade> getEntityClass() {
        return ItemPedidoEntidade.class;
    }
}
