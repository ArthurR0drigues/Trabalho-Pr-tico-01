package br.cefetmg.gestaoentregasentidades.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String logradouro;
    private String bairro;
    private String telefone;
    private String CNPJ;
    private String CPF;
    
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntidade empresa;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<PedidoEntidade> pedidos;

    public ClienteEntidade() {}

    public ClienteEntidade(int id, String nome, String logradouro, String bairro, String telefone, String CNPJ, String CPF, EmpresaEntidade empresa, List<PedidoEntidade> pedidos) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.telefone = telefone;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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