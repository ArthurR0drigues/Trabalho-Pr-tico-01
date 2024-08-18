package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.ProdutoEntidade;

public class ProdutoDAO extends BaseDAO<ProdutoEntidade> {

    public ProdutoDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<ProdutoEntidade> getEntityClass() {
        return ProdutoEntidade.class;
    }
}
