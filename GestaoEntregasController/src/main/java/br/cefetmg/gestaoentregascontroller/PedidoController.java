package br.cefetmg.gestaoentregascontroller;

import br.cefetmg.gestaoentregasdao.dao.DAO;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;
import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import br.cefetmg.gestaoentregasentidades.entidades.Pedido;
import br.cefetmg.gestaoentregasentidades.entidades.enums.Status;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class PedidoController implements EntidadeController<Pedido> {
    
    private Class<Pedido> pedidoEntidade;
    private DAO<Pedido> pedidoDAO;

    public PedidoController() {
        try {
            this.pedidoEntidade = Pedido.class;
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
    
    @Override
    public Class<Pedido> entidade() {
        return this.pedidoEntidade;
    }
    
    public List<Pedido> entregues() {
        
        List<Pedido> pedidos = this.consultarTodos();
        List<Pedido> resultado = new ArrayList<>();
        
        for(Pedido p : pedidos) {
            if(p.getStatus() == Status.ENTREGUE)
                resultado.add(p);
        }
        
        return resultado;
    }
    
    public Map<Funcionario, Map<LocalDate, Double>> gerarRelatorio(LocalDate dataInicio, LocalDate dataFim) {
        List<Pedido> todosPedidos = consultarTodos();

        List<Pedido> pedidosFiltrados = new ArrayList<>();
        for (Pedido pedido : todosPedidos) {
            LocalDate pedidoDate = pedido.getDataPedido().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (!pedidoDate.isBefore(dataInicio) && !pedidoDate.isAfter(dataFim)) {
                pedidosFiltrados.add(pedido);
            }
        }

        Map<Funcionario, Map<LocalDate, Double>> comissoes = new HashMap<>();

        for (Pedido pedido : pedidosFiltrados) {
            Funcionario funcionario = pedido.getFuncionario();
            LocalDate dataPedido = pedido.getDataPedido().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (!comissoes.containsKey(funcionario)) {
                comissoes.put(funcionario, new HashMap<>());
            }

            if (!comissoes.get(funcionario).containsKey(dataPedido)) {
                comissoes.get(funcionario).put(dataPedido, 0.0);
            }

            double comissao = pedido.getValorTotal() * pedido.getFuncionario().getEmpresa().getPorcentagemComissaoEntregador() / 100;
            comissoes.get(funcionario).put(dataPedido, comissoes.get(funcionario).get(dataPedido) + comissao);
        }

        return comissoes;
    }
}
