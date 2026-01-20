package com.app.gestion;
import com.app.gestion.repository.JdbcUtilisateurRepository;
import com.app.gestion.repository.UtilisateurRepository;
import com.app.gestion.service.UtilisateurService;
import com.app.gestion.service.UtilisateurServiceImpl;
import com.app.gestion.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        //UtilisateurRepository repository = new InMemoryUtilisateurRepository();
        UtilisateurRepository repository = new JdbcUtilisateurRepository();
        UtilisateurService service = new UtilisateurServiceImpl(repository);


        ConsoleMenu menu = new ConsoleMenu(service);
        menu.demarrer();
    }
}