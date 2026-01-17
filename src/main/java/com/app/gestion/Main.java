package com.app.gestion;

import com.app.gestion.model.Role;
import com.app.gestion.model.Statut;
import com.app.gestion.model.Utilisateur;
import com.app.gestion.service.UtilisateurService;
import com.app.gestion.service.UtilisateurServiceImp;

public class Main {
    public static void main(String[] args) {
        UtilisateurService service = new UtilisateurServiceImp(); 

        Utilisateur u1 = new Utilisateur(
            1,
            "John Doe", 
            "john.doe@example.com", 
            Role.USER, 
            Statut.ACTIF
        );
        service.creerUtilisateur(u1);

        service.listerUtilisateurs().forEach(u -> {
            System.out.println("Utilisateur: " + u.getNom() + ", Email: " + u.getEmail());
        });
    }
}