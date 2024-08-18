package br.cefetmg.folhapagamento.concretas;

import br.cefetmg.folhapagamento.abstracts.Empregado;

public class PorHora extends Empregado{
    
    private double valorHora;
    private int numeroHoras;

    public PorHora(double valorHora, int numeroHoras, String nome) {
        super(nome);
        this.valorHora = valorHora;
        this.numeroHoras = numeroHoras;
    }
    
    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }    

    @Override
    public double getPagamento() {
        return this.valorHora * this.numeroHoras;
    }
    
}
