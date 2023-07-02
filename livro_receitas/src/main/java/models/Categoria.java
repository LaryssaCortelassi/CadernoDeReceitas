package models;

/**
 *
 * @author Laly
 */
public class Categoria {
    
    private int id;
    private int doce;
    private int salgado;
    private LivroReceitas livroReceitas;

    public Categoria() {
    }

    public Categoria(int id, int doce, int salgado, LivroReceitas livroReceitas) {
        this.id = id;
        this.doce = doce;
        this.salgado = salgado;
        this.livroReceitas = livroReceitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoce() {
        return doce;
    }

    public void setDoce(int doce) {
        this.doce = doce;
    }

    public int getSalgado() {
        return salgado;
    }

    public void setSalgado(int salgado) {
        this.salgado = salgado;
    }

    public LivroReceitas getLivroReceitas() {
        return livroReceitas;
    }

    public void setLivroReceitas(LivroReceitas livroReceitas) {
        this.livroReceitas = livroReceitas;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", doce=" + doce + ", salgado=" + salgado + ", livroReceitas=" + livroReceitas + '}';
    }

    public void setNome(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
