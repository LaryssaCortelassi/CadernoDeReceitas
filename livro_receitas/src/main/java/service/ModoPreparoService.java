package service;

import java.sql.SQLException;
import java.util.List;
import DAO.ModoPreparoDAO;
import models.ModoPreparo;

public class ModoPreparoService {

    private ModoPreparoDAO modoPreparoDAO;

    public ModoPreparoService() {
        this.modoPreparoDAO = new ModoPreparoDAO();
    }

    public List<ModoPreparo> getAllModosPreparo() {
        try {
            return modoPreparoDAO.findAll();
        } catch (SQLException e) {
            return null;
        }
    }

    public ModoPreparo getModoPreparoById(int id) {
        try {
            return modoPreparoDAO.findById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public void createModoPreparo(ModoPreparo modoPreparo) {
        try {
            modoPreparoDAO.insert(modoPreparo);
        } catch (SQLException e) {
        }
    }

    public void updateModoPreparo(ModoPreparo modoPreparo) {
        try {
            modoPreparoDAO.update(modoPreparo);
        } catch (SQLException e) {
        }
    }

    public void deleteModoPreparo(int id) {
        try {
            modoPreparoDAO.deleteById(id);
        } catch (SQLException e) {
        }
    }
}
