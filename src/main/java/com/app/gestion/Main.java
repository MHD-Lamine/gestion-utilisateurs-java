package com.app.gestion;
import com.app.gestion.repository.InMemoryUtilisateurRepository;
import com.app.gestion.repository.JdbcUtilisateurRepository;
import com.app.gestion.repository.UtilisateurRepository;
import com.app.gestion.service.UtilisateurService;
import com.app.gestion.service.UtilisateurServiceImp;
import com.app.gestion.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        //UtilisateurRepository repository = new InMemoryUtilisateurRepository();
        UtilisateurRepository repository = new JdbcUtilisateurRepository();
        UtilisateurService service = new UtilisateurServiceImp(repository);


        ConsoleMenu menu = new ConsoleMenu(service);
        menu.demarrer();
    }
}