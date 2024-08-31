package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Produto;

import java.util.List;

public class ProdutoController implements EntidadeController<Produto> {
    
    private Class<Produto> produtoEntidade;
    private DAO<Produto> produtoDAO;

    public ProdutoController() {
        try {
            this.produtoEntidade = Produto.class;
            this.produtoDAO = new DAO<>(Produto.class, "persistence");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Produto produto) {
        try {
            produtoDAO.salvar(produto);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto consultar(Integer id) {
        try {
            return produtoDAO.consultar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Produto> consultarTodos() {
        try {
            return produtoDAO.consultarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void atualizar(Produto produto) {
        try {
            produtoDAO.atualizar(produto);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Produto produto) {
        try {
            produtoDAO.deletar(produto);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Class<Produto> entidade() {
        return this.produtoEntidade;
    }
}
