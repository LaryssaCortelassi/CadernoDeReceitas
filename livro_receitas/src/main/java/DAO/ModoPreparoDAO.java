package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ModoPreparo;
import util.DataBase;

public class ModoPreparoDAO {
    private static final String INSERT = "INSERT INTO modo_preparo(id, ordem, descricao) VALUES (?, ?, ?)";
    private static final String FIND_ALL = "SELECT id, ordem, descricao FROM modo_preparo";
    private static final String FIND_BY_ID = "SELECT id, ordem, descricao FROM modo_preparo WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM modo_preparo WHERE id = ?";
    private static final String UPDATE = "UPDATE modo_preparo SET ordem = ?, descricao = ? WHERE id = ?";

    public List<ModoPreparo> findAll() throws SQLException {
        List<ModoPreparo> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ModoPreparo modoPreparo = new ModoPreparo();
                modoPreparo.setId(rs.getInt("id"));
                modoPreparo.setOrdem(rs.getString("ordem"));
                modoPreparo.setDescricao(rs.getString("descricao"));

                retorno.add(modoPreparo);
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

    public ModoPreparo findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ModoPreparo retorno = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new ModoPreparo();
                retorno.setId(rs.getInt("id"));
                retorno.setOrdem(rs.getString("ordem"));
                retorno.setDescricao(rs.getString("descricao"));
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

    public void insert(ModoPreparo modoPreparo) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, modoPreparo.getId());
            pstmt.setString(2, modoPreparo.getOrdem());
            pstmt.setString(3, modoPreparo.getDescricao());

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

    public void update(ModoPreparo modoPreparo) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, modoPreparo.getOrdem());
            pstmt.setString(2, modoPreparo.getDescricao());
            pstmt.setInt(3, modoPreparo.getId());

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
