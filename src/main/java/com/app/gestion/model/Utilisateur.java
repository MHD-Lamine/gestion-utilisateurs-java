package com.app.gestion.model;

import java.time.LocalDateTime;

public class Utilisateur {

    private int id;
    private String nom;
    private String email;
    private Role role;
    private Statut statut;
    private LocalDateTime dateCreation;

    public Utilisateur(int id, String nom, String email, Role role, Statut statut) {
        this.id = (int) id;
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.statut = statut;
        this.dateCreation = LocalDateTime.now();
        
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

   
}
