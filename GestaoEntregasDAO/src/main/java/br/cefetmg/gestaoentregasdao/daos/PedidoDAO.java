package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.PedidoEntidade;

public class PedidoDAO extends BaseDAO<PedidoEntidade> {

    public PedidoDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<PedidoEntidade> getEntityClass() {
        return PedidoEntidade.class;
    }
}
