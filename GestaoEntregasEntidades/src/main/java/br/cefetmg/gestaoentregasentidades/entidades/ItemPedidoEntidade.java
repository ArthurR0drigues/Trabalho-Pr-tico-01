package br.cefetmg.gestaoentregasentidades.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedidoEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valorUnitario;
    private int quantidade;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item_pedido")
    private List<ProdutoEntidade> produtos;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoEntidade pedido;

    public ItemPedidoEntidade() {}

    public ItemPedidoEntidade(int id, double valorUnitario, int quantidade, List<ProdutoEntidade> produtos, PedidoEntidade pedido) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.produtos = produtos;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<ProdutoEntidade> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntidade> produtos) {
        this.produtos = produtos;
    }
    
    public PedidoEntidade getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntidade pedido) {
        this.pedido = pedido;
    }
}
