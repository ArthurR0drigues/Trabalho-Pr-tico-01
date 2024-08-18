package br.cefetmg.gestaoentregasentidades.entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class EmpresaEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String CNPJ;
    private String CPF;
    private double porcentagemComissaoEntregador;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<FuncionarioEntidade> funcionarios;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<ClienteEntidade> clientes;

    public EmpresaEntidade() {}

    public EmpresaEntidade(int id, String nome, String CNPJ, String CPF, double porcentagemComissaoEntregador, List<FuncionarioEntidade> funcionarios, List<ClienteEntidade> clientes) {
        this.id = id;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
        this.porcentagemComissaoEntregador = porcentagemComissaoEntregador;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
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

    public double getPorcentagemComissaoEntregador() {
        return porcentagemComissaoEntregador;
    }

    public void setPorcentagemComissaoEntregador(double porcentagemComissaoEntregador) {
        this.porcentagemComissaoEntregador = porcentagemComissaoEntregador;
    }

    public List<FuncionarioEntidade> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioEntidade> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<ClienteEntidade> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteEntidade> clientes) {
        this.clientes = clientes;
    }
}
