package br.cefetmg.folhapagamento.concretas;

import br.cefetmg.exceptions.ValorVendasInvalidoException;
import br.cefetmg.folhapagamento.abstracts.Empregado;
import br.cefetmg.folhapagamento.interfaces.Comissao;

public class PorComissao extends Empregado implements Comissao{

    private double valorVendas;
    
    public PorComissao(double valorVendas, String nome) throws ValorVendasInvalidoException {
        super(nome);
        this.setValorVendas(valorVendas);
    }
     
    public double getValorVendas() {
        return valorVendas;
    }

    @Override
    public void setValorVendas(double valorVendas) throws ValorVendasInvalidoException {
        if (valorVendas < 0)
            throw new ValorVendasInvalidoException("O valor de vendas não pode ser negativo");
        else
            this.valorVendas = valorVendas;
    }

    @Override
    public double getPagamento() {
        return this.valorVendas * Comissao.PERCENTUAL_COMISSAO;
    }
}
