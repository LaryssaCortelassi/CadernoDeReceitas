package service;

import java.sql.SQLException;
import java.util.List;

import DAO.IgredientesDAO;
import models.Igredientes;

public class IgredientesService {

    private IgredientesDAO igredientesDAO;

    public IgredientesService() {
        this.igredientesDAO = new IgredientesDAO();
    }

    public void adicionarIgredientes(Igredientes igredientes) {
        try {
            igredientesDAO.insert(igredientes);
            System.out.println("Igrediente adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar igrediente: " + e.getMessage());
        }
    }

    public void atualizarIgredientes(Igredientes igredientes) {
        try {
            igredientesDAO.update(igredientes);
            System.out.println("Igrediente atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar igrediente: " + e.getMessage());
        }
    }

    public void removerIgredientes(int id) {
        try {
            igredientesDAO.deleteById(id);
            System.out.println("Igrediente removido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover igrediente: " + e.getMessage());
        }
    }

    public void listarIgredientes() {
        try {
            List<Igredientes> igredientes = igredientesDAO.findAll();
            if (igredientes.isEmpty()) {
                System.out.println("Nenhum igrediente encontrado.");
            } else {
                System.out.println("Igredientes encontrados:");
                for (Igredientes igrediente : igredientes) {
                    System.out.println(igrediente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar igredientes: " + e.getMessage());
        }
    }

    public void buscarIgredientesPorId(int id) {
        try {
            Igredientes igrediente = igredientesDAO.findById(id);
            if (igrediente != null) {
                System.out.println("Igrediente encontrado: " + igrediente);
            } else {
                System.out.println("Igrediente não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar igrediente por ID: " + e.getMessage());
        }
    }
}
