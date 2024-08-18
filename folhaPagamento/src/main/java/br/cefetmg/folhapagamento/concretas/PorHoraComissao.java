package br.cefetmg.folhapagamento.concretas;

import br.cefetmg.exceptions.ValorVendasInvalidoException;
import br.cefetmg.folhapagamento.interfaces.Comissao;

public class PorHoraComissao extends PorHora implements Comissao{
    
    private double valorVendas;
    
    public PorHoraComissao(double valorHora, int numeroHoras, String nome, double valorVendas) throws ValorVendasInvalidoException {
        super(valorHora, numeroHoras, nome);
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
    public double getPagamento(){
        return this.getValorVendas() * Comissao.PERCENTUAL_COMISSAO + this.getValorHora() * this.getNumeroHoras(); 
    } 
}
