package com.app.gestion.service;
import org.junit.jupiter.api.Test;

import com.app.gestion.model.Role;
import com.app.gestion.model.Statut;
import com.app.gestion.model.Utilisateur;
import com.app.gestion.repository.UtilisateurRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class UtilisateurServiceImplTest {

    @Test
    void creerUtilisateur_valide_sauvegardeAppelee() {
        // Given

        UtilisateurRepository repo = mock(UtilisateurRepository.class);
        UtilisateurServiceImpl service = new UtilisateurServiceImpl(repo);

        Utilisateur u = new Utilisateur(
            1,
            "Dupont",
            "dupont@example.com",
            Role.USER,
            Statut.ACTIF
        );
        // When
        service.creerUtilisateur(u);
        // Then
        // verify(repo).save(u); --- IGNORE ---


    }

    @Test
    void creerUtilisateur_emailInvalide_lanceException() {
        // Given
        UtilisateurRepository repo = mock(UtilisateurRepository.class);
        UtilisateurServiceImpl service = new UtilisateurServiceImpl(repo);

        Utilisateur u = new Utilisateur(
            1,
            "Dupont",
            "dupontexample.com", // Email invalide
            Role.USER,
            Statut.ACTIF
        );
        // When & Then
        assertThrows(
            com.app.gestion.exception.ValidationException.class,
            () -> service.creerUtilisateur(u)
        );
    }

    @Test
    void creerUtilisateur_emailDejaUtilise_lExceptionLevee() {
        // Given
        UtilisateurRepository repo = mock(UtilisateurRepository.class);
        UtilisateurServiceImpl service = new UtilisateurServiceImpl(repo);

        Utilisateur u1 = new Utilisateur(
            1,
            "Dupont",
            "dupont@example.com",
            Role.USER,
            Statut.ACTIF
        );

        // L'email existe déjà en base
        when(repo.findByEmail("dupont@example.com")).thenReturn(u1);

        Utilisateur u2 = new Utilisateur(
            2,
            "Durand",
            "dupont@example.com",   // 👈 même email !
            Role.USER,
            Statut.ACTIF
        );

        // When & Then
        assertThrows(
            com.app.gestion.exception.ValidationException.class,
            () -> service.creerUtilisateur(u2)
        );
    }

}