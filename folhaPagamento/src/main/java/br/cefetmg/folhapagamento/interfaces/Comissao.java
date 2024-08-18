package br.cefetmg.folhapagamento.interfaces;

import br.cefetmg.exceptions.ValorVendasInvalidoException;

public interface Comissao {
    
    public static double PERCENTUAL_COMISSAO = 0.1;
    
    public void setValorVendas(double valorVendas) throws ValorVendasInvalidoException;
}
