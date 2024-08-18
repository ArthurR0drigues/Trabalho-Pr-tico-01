package br.cefetmg.folhapagamento;

import br.cefetmg.exceptions.ValorVendasInvalidoException;
import br.cefetmg.folhapagamento.concretas.PorHoraComissao;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FolhaPagamento {

    public static void main(String[] args) {
        
        PorHoraComissao porHoraComissao;    
        
        try {
            porHoraComissao = new PorHoraComissao(50.50, 20 * 8, "Carlos", 500);
            
            System.out.println("Nome:" + porHoraComissao.getNome());
            System.out.println("Pagamento:" + porHoraComissao.getPagamento());
        } catch (ValorVendasInvalidoException ex) {
            Logger.getLogger(FolhaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
