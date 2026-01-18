package com.app.gestion.ui;


import java.util.Scanner;
import com.app.gestion.model.Role;
import com.app.gestion.model.Statut;
import com.app.gestion.model.Utilisateur;
import com.app.gestion.service.UtilisateurService;

public class ConsoleMenu {

    private final UtilisateurService service;
    private final java.util.Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(UtilisateurService service) {
        this.service = service;
    }

    public void demarrer(){
         int choix;
         do {
            afficherMenu();
            choix = lireEntier("Choisissez une option: ");

            try {
                switch (choix) {
                    case 1 -> creerUtilisateur();
                    case 2 -> listerUtilisateurs();
                    case 3 -> rechercherParEmail();
                    case 0 -> System.out.println("Au revoir!");
                    default -> System.out.println("Option invalide.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } while (choix != 0);
    }

    private void afficherMenu() {
        System.out.println("\n=== Gestion des Utilisateurs ===");
        System.out.println("1. Créer un utilisateur");
        System.out.println("2. Lister les utilisateurs");
        System.out.println("3. Rechercher un utilisateur par email");
        System.out.println("0. Quitter");
    }

    private void creerUtilisateur() {
        System.out.println("\n--- Créer un Utilisateur ---");
        int id = lireEntier("ID: ");
        System.out.println("Nom: ");
        String nom = scanner.nextLine();


        System.out.println("Email: ");
        String email = scanner.nextLine();

        Role role = Role.USER; 
        Statut statut = Statut.ACTIF;

        Utilisateur u = new Utilisateur(id, nom, email, role, statut);
        service.creerUtilisateur(u);
        System.out.println("Utilisateur créé avec succès!");
       
    }
    private void listerUtilisateurs(){
        System.out.println("\n---- Liste des utilisateur ----");
        service.listerUtilisateurs().forEach(u -> {
            System.out.println(
                u.getId() + "|" +
                u.getNom() + "|" +
                u.getEmail() + "|" +
                u.getRole() + "|" +
                u.getStatut()
            );
        });
    }

    private void rechercherParEmail(){
        System.out.println("\n--- Rechercher un utilisateur par email ---");
        System.out.println("Email: ");
        String email = scanner.nextLine();

        Utilisateur u = service.rechercherParEmail(email);
        if(u != null) {
            System.out.println(
                u.getId() + "|" +
                u.getNom() + "|" +
                u.getEmail() + "|" +
                u.getRole() + "|" +
                u.getStatut()
            );
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
    }

    private int lireEntier(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide. " + message);
            scanner.next();
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
        return valeur;
    }

}
