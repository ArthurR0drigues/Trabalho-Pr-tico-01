package br.cefetmg.gestaoentregasdao.daos;

import br.cefetmg.gestaoentregasdao.daos.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.ClienteEntidade;

public class ClienteDAO extends BaseDAO<ClienteEntidade> {

    public ClienteDAO() throws DAOException {
        super("persistence");
    }

    @Override
    protected Class<ClienteEntidade> getEntityClass() {
        return ClienteEntidade.class;
    }
}
