package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregascontroller.exceptions.ValidationException;
import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Empresa;
import br.cefetmg.gestaoentregasentidades.util.CPFValidator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaController implements EntidadeController<Empresa> {
    
    private Class<Empresa> empresaEntidade;
    private DAO<Empresa> empresaDAO;

    public EmpresaController() {
        try {
            this.empresaEntidade = Empresa.class;
            this.empresaDAO = new DAO<>(Empresa.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Empresa empresa) {
        try {
            
            if(!CPFValidator.vef(empresa.getCPF())) {
                throw new ValidationException("CPF Inválido");
            }
            
            empresaDAO.salvar(empresa);
            
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            System.out.println("Erro de validação: " + e.getMessage());
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
            
            if(!CPFValidator.vef(empresa.getCPF())) {
                throw new ValidationException("CPF Inválido");
            }
            
            empresaDAO.atualizar(empresa);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ValidationException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public Class<Empresa> entidade() {
        return this.empresaEntidade;
    }
}
