package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.ItemPedido;

import java.util.List;

public class ItemPedidoController implements EntidadeController<ItemPedido> {
    
    private Class<ItemPedido> itemPedidoEntidade;
    private DAO<ItemPedido> itemPedidoDAO;

    public ItemPedidoController() {
        try {
            this.itemPedidoEntidade = ItemPedido.class;
            this.itemPedidoDAO = new DAO<>(ItemPedido.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(ItemPedido itemPedido) {
        try {
            itemPedidoDAO.salvar(itemPedido);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ItemPedido consultar(Integer id) {
        try {
            return itemPedidoDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ItemPedido> consultarTodos() {
        try {
            return itemPedidoDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(ItemPedido itemPedido) {
        try {
            itemPedidoDAO.atualizar(itemPedido);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(ItemPedido itemPedido) {
        try {
            itemPedidoDAO.deletar(itemPedido);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Class<ItemPedido> entidade() {
        return this.itemPedidoEntidade;
    }
}
