package Ordenacao;

import java.util.Objects;
import java.util.Comparator;

public class Produto implements Comparable<Produto>{
    private long codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(long codigo, String nome, double preco, int quantidade){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public int compareTo(Produto p){
        return nome.compareToIgnoreCase(p.getNome());
    }
    public long getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int quantidade(){
        return quantidade;
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Produto produto)) return false;
        return getCodigo() == produto.getCodigo();
    }
    public int hashCode(){
        return Objects.hash(getCodigo());
    }
    public String toString(){
        return "Produto{" +
            "codigo='" + codigo +
            ", nome=" + nome + '\'' +
            ", preco='" + preco +
            ", quantidade='" + quantidade +
            '}';
    }
}
class ComparatorPorPreco implements Comparator<Produto>{
    
    public int compare(Produto p1, Produto p2){
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
