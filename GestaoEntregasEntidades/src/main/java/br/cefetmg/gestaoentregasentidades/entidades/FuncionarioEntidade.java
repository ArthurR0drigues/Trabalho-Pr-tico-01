package br.cefetmg.gestaoentregasentidades.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public class FuncionarioEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String senha;
    private String telefone;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<PerfilEntidade> perfis;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<PedidoEntidade> pedidos;
    
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntidade empresa;

    public FuncionarioEntidade() {}

    public FuncionarioEntidade(int id, String nome, String senha, String telefone, List<PerfilEntidade> perfis, EmpresaEntidade empresa, List<PedidoEntidade> pedidos) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.perfis = perfis;
        this.empresa = empresa;
        this.pedidos = pedidos;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<PerfilEntidade> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<PerfilEntidade> perfis) {
        this.perfis = perfis;
    }

    public EmpresaEntidade getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntidade empresa) {
        this.empresa = empresa;
    }
    
    public List<PedidoEntidade> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoEntidade> pedidos) {
        this.pedidos = pedidos;
    }
}
