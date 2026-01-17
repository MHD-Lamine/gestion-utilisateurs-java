package com.app.gestion.service;

import java.util.List;

import com.app.gestion.model.Utilisateur;

public interface UtilisateurService {

    void creerUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> listerUtilisateurs();
    Utilisateur rechercherParEmail(String email);
}
