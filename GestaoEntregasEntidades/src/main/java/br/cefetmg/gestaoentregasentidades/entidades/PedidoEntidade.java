package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.enums.FormaPagamento;
import br.cefetmg.gestaoentregasentidades.entidades.enums.Status;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class PedidoEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;
    private double valorTotal;
    private String observacao;
    
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedidoEntidade> itemPedidos;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntidade cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private FuncionarioEntidade funcionario;

    public PedidoEntidade() {}

    public PedidoEntidade(int id, Date dataPedido, double valorTotal, Status status, List<ItemPedidoEntidade> itemPedidos, ClienteEntidade cliente, FuncionarioEntidade funcionario, FormaPagamento formaPagamento, String observacao) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.status = status;
        this.itemPedidos = itemPedidos;
        this.cliente = cliente;
        this.funcionario = funcionario; 
        this.formaPagamento = formaPagamento;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return dataPedido;
    }

    public void setData(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<ItemPedidoEntidade> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedidoEntidade> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public ClienteEntidade getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntidade cliente) {
        this.cliente = cliente;
    }
    
    public FuncionarioEntidade getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioEntidade funcionario) {
        this.funcionario = funcionario;
    }
    
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacoes(String observações) {
        this.observacao = observacao;
    }
}
