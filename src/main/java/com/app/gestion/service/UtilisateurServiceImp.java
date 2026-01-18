package com.app.gestion.service;


import java.util.List;

import com.app.gestion.exception.ValidationException;
import com.app.gestion.model.Utilisateur;
import com.app.gestion.repository.UtilisateurRepository;

public class UtilisateurServiceImp implements UtilisateurService {

    private final UtilisateurRepository repository;

    public UtilisateurServiceImp(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public void creerUtilisateur(Utilisateur utilisateur){
        if (utilisateur.getNom() == null || utilisateur.getNom().isBlank()) {
            throw new ValidationException("Le nom est obligatoire");
        }
        if(utilisateur.getEmail() == null || !utilisateur.getEmail().contains("@")) {
            throw new ValidationException("Email invalide");
        }

        if(repository.findByEmail(utilisateur.getEmail()) != null) {
            throw new ValidationException("Un utilisateur avec cet email existe déjà");
        }

        repository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return repository.findAll();
    }

    @Override
    public Utilisateur rechercherParEmail(String email) {
        return repository.findByEmail(email);
    }
}
