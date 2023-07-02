package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Igredientes;
import util.DataBase;

public class IgredientesDAO {
    
    private static final String INSERT = "INSERT INTO igredientes(id, nome, quantidade, unidade_medida) VALUES (?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT id, nome, quantidade, unidade_medida FROM igredientes";
    private static final String FIND_BY_ID = "SELECT id, nome, quantidade, unidade_medida FROM igredientes WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM igredientes WHERE id = ?";
    private static final String UPDATE = "UPDATE igredientes SET nome = ?, quantidade = ?, unidade_medida = ? WHERE id = ?";
    
    public List<Igredientes> findAll() throws SQLException {
        List<Igredientes> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Igredientes igredientes = new Igredientes();
                igredientes.setId(rs.getInt("id"));
                igredientes.setNome(rs.getString("nome"));
                igredientes.setQuantidade(rs.getString("quantidade"));
                igredientes.setUnidadeMedida(rs.getString("unidade_medida"));

                retorno.add(igredientes);
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
    
    public Igredientes findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Igredientes retorno = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retorno = new Igredientes();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setQuantidade(rs.getString("quantidade"));
                retorno.setUnidadeMedida(rs.getString("unidade_medida")); 
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


    public void insert(Igredientes ingrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, ingrediente.getId());
            pstmt.setString(2, ingrediente.getNome());
            pstmt.setString(3, ingrediente.getQuantidade());
            pstmt.setString(4, ingrediente.getUnidadeMedida());

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

    public void update(Igredientes ingrediente) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, ingrediente.getNome());
            pstmt.setString(2, ingrediente.getQuantidade());
            pstmt.setString(3, ingrediente.getUnidadeMedida());
            pstmt.setInt(4, ingrediente.getId());

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
