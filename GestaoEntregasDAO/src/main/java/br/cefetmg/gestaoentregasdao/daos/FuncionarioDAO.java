package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.FuncionarioEntidade;

public class FuncionarioDAO extends BaseDAO<FuncionarioEntidade> {

    public FuncionarioDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<FuncionarioEntidade> getEntityClass() {
        return FuncionarioEntidade.class;
    }
}
