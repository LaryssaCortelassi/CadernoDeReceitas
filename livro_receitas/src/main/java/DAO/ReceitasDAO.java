package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import models.Receitas;
import models.Categoria;
import util.DataBase;

public class ReceitasDAO {
    private static final String INSERT = "INSERT INTO receitas(id, nome, rendimento, local_create_time, categoria_id) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT r.id, r.nome, r.rendimento, r.local_create_time, c.id AS categoria_id, c.nome AS categoria_nome FROM receitas r JOIN categoria c ON r.categoria_id = c.id";
    private static final String FIND_BY_ID = "SELECT r.id, r.nome, r.rendimento, r.local_create_time, c.id AS categoria_id, c.nome AS categoria_nome FROM receitas r JOIN categoria c ON r.categoria_id = c.id WHERE r.id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM receitas WHERE id = ?";
    private static final String UPDATE = "UPDATE receitas SET nome = ?, rendimento = ?, local_create_time = ?, categoria_id = ? WHERE id = ?";

    public List<Receitas> findAll() throws SQLException {
        List<Receitas> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Receitas receita = new Receitas();
                receita.setId(rs.getInt("id"));
                receita.setNome(rs.getString("nome"));
                receita.setRendimento(rs.getString("rendimento"));
                receita.setLocalCreateTime(rs.getObject("local_create_time", LocalDateTime.class));
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));
                receita.setCategoria(categoria);

                retorno.add(receita);
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

    public Receitas findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Receitas retorno = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Receitas();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setRendimento(rs.getString("rendimento"));
                retorno.setLocalCreateTime(rs.getObject("local_create_time", LocalDateTime.class));
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));
                retorno.setCategoria(categoria);
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

    public void insert(Receitas receita) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, receita.getId());
            pstmt.setString(2, receita.getNome());
            pstmt.setString(3, receita.getRendimento());
            pstmt.setObject(4, receita.getLocalCreateTime());
            pstmt.setInt(5, receita.getCategoria().getId());

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

    public void update(Receitas receita) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, receita.getNome());
            pstmt.setString(2, receita.getRendimento());
            pstmt.setObject(3, receita.getLocalCreateTime());
            pstmt.setInt(4, receita.getCategoria().getId());
            pstmt.setInt(5, receita.getId());

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
