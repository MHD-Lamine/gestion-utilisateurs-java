package com.app.gestion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.app.gestion.config.DatabaseConfig;
import com.app.gestion.model.Role;
import com.app.gestion.model.Statut;
import com.app.gestion.model.Utilisateur;

public class JdbcUtilisateurRepository implements UtilisateurRepository {

    @Override
    public void save(Utilisateur u) {
        String sql = """
            INSERT INTO utilisateurs (id, nom, email, role, statut, date_creation)
            VALUES (?, ?, ?, ?, ?, ?)
                """;
        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, u.getId());
            st.setString(2, u.getNom());
            st.setString(3, u.getEmail());
            st.setString(4, u.getRole().name());
            st.setString(5, u.getStatut().name());
            st.setTimestamp(6, Timestamp.valueOf(u.getDateCreation()));

            st.executeUpdate();
        
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> list = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs ";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
                while(rs.next()) {
                    Utilisateur u = new Utilisateur(
                        rs.getInt("id"), 
                        rs.getString("nom"), 
                        rs.getString("email"), 
                        Role.valueOf(rs.getString("role")),
                        Statut.valueOf(rs.getString("statut"))
                    );
                    list.add(u);
                }
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des utilisateurs", e);
        }
        return list;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        String sql = "SELECT * FROM utilisateurs WHERE email = ?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, email);
            try(ResultSet rs = st.executeQuery()) {
                if(rs.next()) {
                    return new Utilisateur(
                        rs.getInt("id"), 
                        rs.getString("nom"), 
                        rs.getString("email"), 
                        Role.valueOf(rs.getString("role")),
                        Statut.valueOf(rs.getString("statut"))
                    );
                } 
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la recherche de l'utilisateur par email", e);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id = ?";
        try(Connection u = DatabaseConfig.getConnection();
        PreparedStatement st = u.prepareStatement(sql)){
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression de l'utilisateur", e);
        }
    }

    @Override
    public String toString() {
        return "JdbcUtilisateurRepository []";
    }

}

