package com.app.gestion.repository;

import java.util.ArrayList;
import java.util.List;

import com.app.gestion.model.Utilisateur;

public class InMemoryUtilisateurRepository implements UtilisateurRepository {
    // Implementation details would go here
    private final List<Utilisateur> stockage = new ArrayList<>();

    @Override
    public void save(Utilisateur utilisateur) {
        stockage.add(utilisateur);
    }

    @Override
    public List<Utilisateur> findAll() {
        return stockage;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return stockage.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
    @Override
    public void deleteById(int id) {
        stockage.removeIf(u -> u.getId() == id);
    }

}
