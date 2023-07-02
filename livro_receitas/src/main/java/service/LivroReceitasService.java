package service;
import DAO.LivroReceitasDAO;
import java.sql.SQLException;
import java.util.List;
import models.LivroReceitas;

public class LivroReceitasService {

    private LivroReceitasDAO livroReceitasDAO;

    public LivroReceitasService() {
        this.livroReceitasDAO = new LivroReceitasDAO();
    }

    public void adicionarLivroReceitas(LivroReceitas livroReceitas) {
        try {
            livroReceitasDAO.insert(livroReceitas);
            System.out.println("Livro de receitas adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar livro de receitas: " + e.getMessage());
        }
    }

    public void atualizarLivroReceitas(LivroReceitas livroReceitas) {
        try {
            livroReceitasDAO.update(livroReceitas);
            System.out.println("Livro de receitas atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro de receitas: " + e.getMessage());
        }
    }

    public void removerLivroReceitas(int id) {
        try {
            livroReceitasDAO.deleteById(id);
            System.out.println("Livro de receitas removido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover livro de receitas: " + e.getMessage());
        }
    }

    public void listarLivrosReceitas() {
        try {
            List<LivroReceitas> livros = livroReceitasDAO.findAll();
            if (livros.isEmpty()) {
                System.out.println("Nenhum livro de receitas encontrado.");
            } else {
                System.out.println("Livros de receitas encontrados:");
                for (LivroReceitas livro : livros) {
                    System.out.println(livro);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros de receitas: " + e.getMessage());
        }
    }

    public void buscarLivroReceitasPorId(int id) {
        try {
            LivroReceitas livro = livroReceitasDAO.findById(id);
            if (livro != null) {
                System.out.println("Livro de receitas encontrado: " + livro);
            } else {
                System.out.println("Livro de receitas não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar livro de receitas por ID: " + e.getMessage());
        }
    }
}
