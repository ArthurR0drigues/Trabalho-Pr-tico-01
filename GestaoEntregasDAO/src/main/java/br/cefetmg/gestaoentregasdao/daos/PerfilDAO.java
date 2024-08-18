package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.PerfilEntidade;

public class PerfilDAO extends BaseDAO<PerfilEntidade> {

    public PerfilDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<PerfilEntidade> getEntityClass() {
        return PerfilEntidade.class;
    }
}