package br.cefetmg.gestaoentregasentidades.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String localizacao;
    private String marca;
    
    @ManyToOne
    @JoinColumn(name = "id_item_pedido")
    private ItemPedido itemPedido;

    public Produto() {}

    public Produto(int id, String nome, String localizacao, ItemPedido itemPedido, String marca) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.itemPedido = itemPedido;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
