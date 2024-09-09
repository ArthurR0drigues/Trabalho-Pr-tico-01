package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregascontroller.exceptions.ValidationException;
import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Cliente;
import br.cefetmg.gestaoentregasentidades.util.CPFValidator;
import br.cefetmg.gestaoentregasentidades.util.PhoneNumberValidator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController implements EntidadeController<Cliente> {
    
    private Class<Cliente> clienteEntidade;
    private DAO<Cliente> clienteDAO;

    public ClienteController() {
        try {
            this.clienteEntidade = Cliente.class;
            this.clienteDAO = new DAO<>(Cliente.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Cliente cliente) {
        try {
            
            if(!PhoneNumberValidator.vef(cliente.getTelefone())) {
                throw new ValidationException("Telefone Inválido");
            }
            if(!CPFValidator.vef(cliente.getCPF())) {
                throw new ValidationException("CPF Inválido");
            }
            
            clienteDAO.salvar(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ValidationException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente consultar(Integer id) {
        try {
            return clienteDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cliente> consultarTodos() {
        try {
            return clienteDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(Cliente cliente) {
        try {
            
            if(!PhoneNumberValidator.vef(cliente.getTelefone())) {
                throw new ValidationException("Telefone Inválido");
            }
            if(!CPFValidator.vef(cliente.getCPF())) {
                throw new ValidationException("CPF Inválido");
            }
            
            clienteDAO.atualizar(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ValidationException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        try {
            clienteDAO.deletar(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Class<Cliente> entidade() {
        return this.clienteEntidade;
    }
}
