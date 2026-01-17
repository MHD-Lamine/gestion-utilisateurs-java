package com.app.gestion.service;

import java.util.ArrayList;
import java.util.List;

import com.app.gestion.exception.ValidationException;
import com.app.gestion.model.Utilisateur;

public class UtilisateurServiceImp implements UtilisateurService {

    private final List<Utilisateur> utilisateurs = new ArrayList<>();

    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {
        if(utilisateur.getNom() == null || utilisateur.getNom().isBlank()) {
            throw new ValidationException("Le nom est obligatoire");
        }
        if(utilisateur.getEmail() == null || !utilisateur.getEmail().contains("@")) {
            throw new ValidationException("Email invalide");
        }

        boolean emailExiste = utilisateurs.stream()
            .anyMatch(u -> u.getEmail().equalsIgnoreCase(utilisateur.getEmail()));
        if(emailExiste) {
            throw new ValidationException("Un utilisateur avec cet email existe déjà");
    }

        utilisateurs.add(utilisateur);
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurs;
    }

    @Override
    public Utilisateur rechercherParEmail(String email) {
        return utilisateurs.stream()
            .filter(u -> u.getEmail().equalsIgnoreCase(email))
            .findFirst()
            .orElse(null);
    }
  
}
