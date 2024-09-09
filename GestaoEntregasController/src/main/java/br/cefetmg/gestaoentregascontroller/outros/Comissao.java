package br.cefetmg.gestaoentregascontroller.outros;


import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import java.time.LocalDate;

public class Comissao {
    private String funcionario;
    private LocalDate data;
    private Double comissao;

    public Comissao(String funcionario, LocalDate data, Double comissao) {
        this.funcionario = funcionario;
        this.data = data;
        this.comissao = comissao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getComissao() {
        return comissao;
    }
}