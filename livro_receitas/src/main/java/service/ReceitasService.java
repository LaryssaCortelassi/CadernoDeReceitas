package service;

import java.sql.SQLException;
import java.util.List;

import DAO.ReceitasDAO;
import models.Receitas;

public class ReceitasService {

    private ReceitasDAO receitasDAO;

    public ReceitasService() {
        this.receitasDAO = new ReceitasDAO();
    }

    public void adicionarReceita(Receitas receita) {
        try {
            receitasDAO.insert(receita);
            System.out.println("Receita adicionada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar receita: " + e.getMessage());
        }
    }

    public void atualizarReceita(Receitas receita) {
        try {
            receitasDAO.update(receita);
            System.out.println("Receita atualizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar receita: " + e.getMessage());
        }
    }

    public void removerReceita(int id) {
        try {
            receitasDAO.deleteById(id);
            System.out.println("Receita removida com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover receita: " + e.getMessage());
        }
    }

    public void listarReceitas() {
        try {
            List<Receitas> receitas = receitasDAO.findAll();
            if (receitas.isEmpty()) {
                System.out.println("Nenhuma receita encontrada.");
            } else {
                System.out.println("Receitas encontradas:");
                for (Receitas receita : receitas) {
                    System.out.println(receita);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar receitas: " + e.getMessage());
        }
    }

    public void buscarReceitaPorId(int id) {
        try {
            Receitas receita = receitasDAO.findById(id);
            if (receita != null) {
                System.out.println("Receita encontrada: " + receita);
            } else {
                System.out.println("Receita não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar receita por ID: " + e.getMessage());
        }
    }
}
