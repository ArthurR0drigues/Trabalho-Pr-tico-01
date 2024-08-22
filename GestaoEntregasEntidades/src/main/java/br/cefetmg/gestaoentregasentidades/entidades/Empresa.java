package br.cefetmg.gestaoentregasentidades.entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String CNPJ;
    private String CPF;
    private double porcentagemComissaoEntregador;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Funcionario> funcionarios;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Cliente> clientes;

    public Empresa() {}

    public Empresa(int id, String nome, String CNPJ, String CPF, double porcentagemComissaoEntregador, List<Funcionario> funcionarios, List<Cliente> clientes) {
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
