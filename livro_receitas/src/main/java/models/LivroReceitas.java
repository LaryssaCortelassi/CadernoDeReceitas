package models;

/**
 *
 * @author Laly
 */
public class LivroReceitas {
    
    private int id;
    private String nome;

    public LivroReceitas() {
    }

    public LivroReceitas(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "livro_receitas{" + "id=" + id + ", nome=" + nome + '}';
    }
}
