package br.cefetmg.folhapagamento.abstracts;

public abstract class Empregado {
    
    private String nome;

    public Empregado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void imprimirPagamento() {
        System.out.println("Pagamento: "+ this.getPagamento());
    }
    
    public abstract double getPagamento();
}
