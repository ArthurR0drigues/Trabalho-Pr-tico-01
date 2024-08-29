package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Pedido;

import java.util.List;

public class PedidoController implements EntidadeController<Pedido> {
    
    private DAO<Pedido> pedidoDAO;

    public PedidoController() {
        try {
            this.pedidoDAO = new DAO<>(Pedido.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Pedido pedido) {
        try {
            pedidoDAO.salvar(pedido);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido consultar(Integer id) {
        try {
            return pedidoDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pedido> consultarTodos() {
        try {
            return pedidoDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(Pedido pedido) {
        try {
            pedidoDAO.atualizar(pedido);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Pedido pedido) {
        try {
            pedidoDAO.deletar(pedido);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
