package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Empresa;

import java.util.List;

public class EmpresaController implements EntidadeController<Empresa> {
    
    private DAO<Empresa> empresaDAO;

    public EmpresaController() {
        try {
            this.empresaDAO = new DAO<>(Empresa.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Empresa empresa) {
        try {
            empresaDAO.salvar(empresa);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Empresa consultar(Integer id) {
        try {
            return empresaDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Empresa> consultarTodos() {
        try {
            return empresaDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(Empresa empresa) {
        try {
            empresaDAO.atualizar(empresa);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Empresa empresa) {
        try {
            empresaDAO.deletar(empresa);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
