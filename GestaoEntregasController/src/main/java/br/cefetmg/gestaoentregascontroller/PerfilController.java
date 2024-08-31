package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Perfil;

import java.util.List;

public class PerfilController implements EntidadeController<Perfil> {
    
    private Class<Perfil> perfilEntidade;
    private DAO<Perfil> perfilDAO;

    public PerfilController() {
        try {
            this.perfilEntidade = Perfil.class;
            this.perfilDAO = new DAO<>(Perfil.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Perfil perfil) {
        try {
            perfilDAO.salvar(perfil);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Perfil consultar(Integer id) {
        try {
            return perfilDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Perfil> consultarTodos() {
        try {
            return perfilDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(Perfil perfil) {
        try {
            perfilDAO.atualizar(perfil);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Perfil perfil) {
        try {
            perfilDAO.deletar(perfil);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Class<Perfil> entidade() {
        return this.perfilEntidade;
    }
}
