package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;

import java.util.List;

public class FuncionarioController implements EntidadeController<Funcionario> {
    
    private DAO<Funcionario> funcionarioDAO;

    public FuncionarioController() {
        try {
            this.funcionarioDAO = new DAO<>(Funcionario.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Funcionario funcionario) {
        try {
            funcionarioDAO.salvar(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario consultar(Integer id) {
        try {
            return funcionarioDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Funcionario> consultarTodos() {
        try {
            return funcionarioDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(Funcionario funcionario) {
        try {
            funcionarioDAO.atualizar(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Funcionario funcionario) {
        try {
            funcionarioDAO.deletar(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
