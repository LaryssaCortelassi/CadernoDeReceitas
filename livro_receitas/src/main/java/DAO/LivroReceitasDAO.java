package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.LivroReceitas;
import util.DataBase;

/**
 * Classe LivroReceitasDAO
 */
public class LivroReceitasDAO {
    private static final String INSERT = "INSERT INTO livro_receitas(id, nome) VALUES (?, ?)";
    private static final String FIND_ALL = "SELECT id, nome FROM livro_receitas";
    private static final String FIND_BY_ID = "SELECT id, nome FROM livro_receitas WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM livro_receitas WHERE id = ?";
    private static final String UPDATE = "UPDATE livro_receitas SET nome = ? WHERE id = ?";

    public List<LivroReceitas> findAll() throws SQLException {
        List<LivroReceitas> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                LivroReceitas livroReceitas = new LivroReceitas();
                livroReceitas.setId(rs.getInt("id"));
                livroReceitas.setNome(rs.getString("nome"));

                retorno.add(livroReceitas);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public LivroReceitas findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LivroReceitas retorno = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new LivroReceitas();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public void insert(LivroReceitas livroReceitas) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, livroReceitas.getId());
            pstmt.setString(2, livroReceitas.getNome());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(LivroReceitas livroReceitas) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, livroReceitas.getNome());
            pstmt.setInt(2, livroReceitas.getId());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
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
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
