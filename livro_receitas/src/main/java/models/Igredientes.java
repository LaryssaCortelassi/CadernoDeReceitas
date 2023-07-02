package models;

/**
 *
 * @author Laly
 */
public class Igredientes {
    
    private int id;
    private String nome;
    private String quantidade;
    private String unidadeMedida;
    private Receitas receitas;
    private ModoPreparo modoPreparo;

    public Igredientes() {
    }

    public Igredientes(int id, String nome, String quantidade, String unidadeMedida, Receitas receitas, ModoPreparo modoPreparo) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.receitas = receitas;
        this.modoPreparo = modoPreparo;
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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Receitas getReceitas() {
        return receitas;
    }

    public void setReceitas(Receitas receitas) {
        this.receitas = receitas;
    }

    public ModoPreparo getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(ModoPreparo modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    @Override
    public String toString() {
        return "Igredientes{" + "id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", unidadeMedida=" + unidadeMedida + ", receitas=" + receitas + ", modoPreparo=" + modoPreparo + '}';
    }
}
