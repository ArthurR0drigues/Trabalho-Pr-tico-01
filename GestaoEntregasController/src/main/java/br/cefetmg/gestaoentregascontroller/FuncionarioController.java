package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregascontroller.exceptions.ValidationException;
import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import br.cefetmg.gestaoentregasentidades.entidades.enums.TipoPerfil;
import br.cefetmg.gestaoentregasentidades.util.PasswordHasher;
import br.cefetmg.gestaoentregasentidades.util.PhoneNumberValidator;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioController implements EntidadeController<Funcionario> {
    
    private Class<Funcionario> funcionarioEntidade;
    private DAO<Funcionario> funcionarioDAO;

    public FuncionarioController() {
        try {
            this.funcionarioEntidade = Funcionario.class;
            this.funcionarioDAO = new DAO<>(Funcionario.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Funcionario funcionario) {
        try {
            
            if(!PhoneNumberValidator.vef(funcionario.getTelefone())) {
                throw new ValidationException("Telefone Inválido");
            }
            
            funcionario.setSenha(PasswordHasher.hashPassword(funcionario.getSenha()));
            
            funcionarioDAO.salvar(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ValidationException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
            
            if(!PhoneNumberValidator.vef(funcionario.getTelefone())) {
                throw new ValidationException("Telefone Inválido");
            }
            
            funcionario.setSenha(PasswordHasher.hashPassword(funcionario.getSenha()));
            
            funcionarioDAO.atualizar(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ValidationException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public Class<Funcionario> entidade() {
        return this.funcionarioEntidade;
    }
    
    public List<TipoPerfil> consultarLogin(String nome, String senha) {
        
        List<Funcionario> funcionarios = this.consultarTodos();
        List<TipoPerfil> perfis = new ArrayList<>();
        
        for (Funcionario f : funcionarios) {
            if (f.getSenha().equals(PasswordHasher.hashPassword(senha))
                && f.getNome().equals(nome))
            {
                f.getPerfis().forEach(perfil -> perfis.add(perfil.getTipoPerfil()));
                return perfis;
            }
        }

        return null; 
    }
}
