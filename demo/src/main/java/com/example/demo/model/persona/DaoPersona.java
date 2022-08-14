package com.example.demo.model.persona;
import com.example.demo.utils.MYSQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersona{
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;
    MYSQLConnection mysqlConnection = new MYSQLConnection();
    BeanPersona beanPersona = new BeanPersona();
    public List<BeanPersona> listarPersona() throws SQLException {

        List<BeanPersona> personas = new ArrayList<BeanPersona>();
        String sql = "SELECT * FROM persona.personas";
        conn = mysqlConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            long id = resulSet.getLong("id");
            String nombre = resulSet.getString("nombre");
            String surname = resulSet.getString("surname");
            String curp = resulSet.getString("curp");
            String cumple = resulSet.getString("cumple");
            BeanPersona persona = new BeanPersona(id, nombre, surname, curp, cumple);
            personas.add(persona);
        }
        closeConnections();
        return personas;
    }
    public List<BeanPersona> findAll() {
        List<BeanPersona> personas = new ArrayList<>();
        BeanPersona persona = null;
        try {
            conn = new MYSQLConnection().getConnection();
            String query = "SELECT * FROM persona.personas;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                persona = new BeanPersona();
                persona.setId(rs.getLong("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setSurname(rs.getString("surname"));
                persona.setCurp(rs.getString("curp"));
                persona.setCumple(rs.getString("cumple"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return personas;
    }

    public boolean save(BeanPersona persona) {

        try {
            conn = new MYSQLConnection().getConnection();
            String query = "INSERT INTO persona.personas" +
                    "(nombre,surname,curp,cumple)" +
                    " VALUES (?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getSurname());
            pstm.setString(3, persona.getCurp());
            pstm.setString(4, persona.getCumple());
            System.out.println(pstm);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }

    }

    public BeanPersona findOne(long id) {
        try {
            conn = new MYSQLConnection().getConnection();
            String query = "SELECT * FROM persona.personas WHERE id = ?";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanPersona persona = new BeanPersona();
                persona.setId(rs.getLong("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setSurname(rs.getString("surname"));
                persona.setCurp(rs.getString("curp"));
                persona.setCumple(rs.getString("cumple"));
                return persona;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public boolean delete(long id) {
        try {
            conn = new MYSQLConnection().getConnection();
            String query = "DELETE FROM persona.personas WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error delete method");
            return false;
        } finally {
            closeConnections();
        }
    }
    public boolean update(BeanPersona persona) {
        try {
            conn = new MYSQLConnection().getConnection();
            String query = "UPDATE personas SET nombre = ?, surname = ?, curp = ?, cumple = ? WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, persona.getNombre());
            pstm.setString(2,persona.getSurname());
            pstm.setString(3,persona.getCurp());
            pstm.setString(4,persona.getCumple());
            pstm.setLong(5,persona.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }


    public void closeConnections() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cstm != null) {
                cstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }
}
