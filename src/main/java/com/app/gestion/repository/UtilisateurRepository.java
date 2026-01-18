package com.app.gestion.repository;

import java.util.List;

import com.app.gestion.model.Utilisateur;

public interface UtilisateurRepository {

    void save(Utilisateur utilisateur);

    List<Utilisateur> findAll();

    Utilisateur findByEmail(String email);

}
