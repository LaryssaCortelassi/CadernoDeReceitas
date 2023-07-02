package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Categoria;
import models.LivroReceitas;
import util.DataBase;

public class CategoriaDAO {
    
    private static final String INSERT = "INSERT INTO categorias (id, doce, salgado, livro_receitas_id) VALUES (?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT id, doce, salgado, livro_receitas_id FROM categorias";
    private static final String FIND_BY_ID = "SELECT id, doce, salgado, livro_receitas_id FROM categorias WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM categorias WHERE id = ?";
    private static final String UPDATE = "UPDATE categorias SET doce = ?, salgado = ?, livro_receitas_id = ? WHERE id = ?";
    
    public List<Categoria> findAll() throws SQLException {
        List<Categoria> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDoce(rs.getInt("doce"));
                categoria.setSalgado(rs.getInt("salgado"));
                
                int livroReceitasId = rs.getInt("livro_receitas_id");
                LivroReceitas livroReceitas = getLivroReceitasById(livroReceitasId);
                categoria.setLivroReceitas(livroReceitas);

                retorno.add(categoria);
            }
        } finally {
            // fechar as conexões
        }

        return retorno;
    }
    
    public Categoria findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Categoria retorno = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retorno = new Categoria();
                retorno.setId(rs.getInt("id"));
                retorno.setDoce(rs.getInt("doce"));
                retorno.setSalgado(rs.getInt("salgado"));
                
                int livroReceitasId = rs.getInt("livro_receitas_id");
                LivroReceitas livroReceitas = getLivroReceitasById(livroReceitasId);
                retorno.setLivroReceitas(livroReceitas);
            }
        } finally {
            // fechar as conexões
        }

        return retorno;
    }

    public void insert(Categoria categoria) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, categoria.getId());
            pstmt.setInt(2, categoria.getDoce());
            pstmt.setInt(3, categoria.getSalgado());
            pstmt.setInt(4, categoria.getLivroReceitas().getId());

            pstmt.executeUpdate();
        } finally {
            // fechar as conexões
        }
    }

    public void update(Categoria categoria) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setInt(1, categoria.getDoce());
            pstmt.setInt(2, categoria.getSalgado());
            pstmt.setInt(3, categoria.getLivroReceitas().getId());
            pstmt.setInt(4, categoria.getId());

            pstmt.executeUpdate();
        } finally {
            // fechar as conexões
        }
    }

    public void deleteById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } finally {
            // fechar as conexões
        }
    }
    
    private LivroReceitas getLivroReceitasById(int id) throws SQLException {
        LivroReceitasDAO livroReceitasDAO = new LivroReceitasDAO();
        return livroReceitasDAO.findById(id);
    }
}
