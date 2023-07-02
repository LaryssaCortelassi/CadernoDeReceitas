package models;

import java.time.LocalDateTime;

/**
 *
 * @author Laly
 */
public class Receitas {
    
    private int id;
    private String nome;
    private String rendimento;
    private LocalDateTime localCreateTime;
    private Categoria categoria;

    public Receitas() {
    }

    public Receitas(int id, String nome, String rendimento, LocalDateTime localCreateTime, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.rendimento = rendimento;
        this.localCreateTime = localCreateTime;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalCreateTime() {
        return localCreateTime;
    }

    public void setLocalCreateTime(LocalDateTime localCreateTime) {
        this.localCreateTime = localCreateTime;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public String toString() {
        return "Receitas{" + "id=" + id + ", nome=" + nome + ", rendimento=" + rendimento + ", localCreateTime=" + localCreateTime + ", categoria=" + categoria + '}';
    }    
}
