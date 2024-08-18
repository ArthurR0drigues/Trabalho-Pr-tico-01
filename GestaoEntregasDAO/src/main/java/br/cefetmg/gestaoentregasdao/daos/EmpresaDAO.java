package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.EmpresaEntidade;

public class EmpresaDAO extends BaseDAO<EmpresaEntidade> {

    public EmpresaDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<EmpresaEntidade> getEntityClass() {
        return EmpresaEntidade.class;
    }
}