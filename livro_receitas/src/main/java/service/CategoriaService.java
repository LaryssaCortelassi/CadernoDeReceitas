package service;

import java.sql.SQLException;
import java.util.List;
import DAO.CategoriaDAO;
import models.Categoria;

public class CategoriaService {

    private CategoriaDAO categoriaDAO;

    public CategoriaService() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public List<Categoria> getAllCategorias() {
        try {
            return categoriaDAO.findAll();
        } catch (SQLException e) {
            return null;
        }
    }

    public Categoria getCategoriaById(int id) {
        try {
            return categoriaDAO.findById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public void createCategoria(Categoria categoria) {
        try {
            categoriaDAO.insert(categoria);
        } catch (SQLException e) {
        }
    }

    public void updateCategoria(Categoria categoria) {
        try {
            categoriaDAO.update(categoria);
        } catch (SQLException e) {
        }
    }

    public void deleteCategoria(int id) {
        try {
            categoriaDAO.deleteById(id);
        } catch (SQLException e) {
        }
    }
}
