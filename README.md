# 🚀 Gestion des Utilisateurs – Java Backend

## 📌 Description
Projet Java backend réalisé dans un objectif d’apprentissage avancé.
Il permet de gérer des utilisateurs via une application console en appliquant
les bonnes pratiques professionnelles (POO, SOLID, Clean Code).

---

## 🛠️ Technologies utilisées
- Java 17
- Maven
- JDBC (MySQL / PostgreSQL)
- Git & GitHub
- JUnit 5
- Mockito

---

## 🧱 Architecture du projet

```
gestion-utilisateurs-java
├── pom.xml
└── src
├── main
│ ├── java
│ │ └── com.app.gestion
│ │ ├── Main.java
│ │ ├── model
│ │ ├── repository
│ │ ├── service
│ │ ├── exception
│ │ ├── ui
│ │ └── config
│ └── resources
└── test
└── java

```
---

## ✨ Fonctionnalités
- Créer un utilisateur
- Lister les utilisateurs
- Rechercher un utilisateur par email
- Validation des données
- Gestion des erreurs métier
- Persistance en base de données (JDBC)

---

## 🗄️ Base de données

### Table `utilisateur`
```sql
CREATE TABLE utilisateur (
    id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20),
    statut VARCHAR(20),
    date_creation TIMESTAMP
);
```
▶️ Lancer le projet
Prérequis

Java 17+

Maven

MySQL ou PostgreSQL

Étapes
git clone https://github.com/MHD-Lamine/gestion-utilisateurs-java.git
cd gestion-utilisateurs-java
mvn clean compile
mvn exec:java

🧪 Tests unitaires
mvn test

📚 Concepts Java appliqués

Programmation Orientée Objet (POO)

SOLID

Clean Code

Exceptions personnalisées

Interfaces & polymorphisme

JDBC

Tests unitaires (JUnit, Mockito)

👨‍💻 Auteur

Projet réalisé par DIABATE Mohamed Lamine
Dans le cadre d’un apprentissage Java avancé.

📈 Évolutions possibles

Migration vers Spring Boot

Exposition d’une API REST

Ajout d’une interface web

Sécurité (authentification)


---

## 🧩 ÉTAPE 2 — ADAPTER LE README

👉 Modifie :
- `VOTRE_USERNAME`
- Ton nom
- La base de données utilisée (MySQL ou PostgreSQL)

---

## 🧩 ÉTAPE 3 — COMMIT FINAL 🎯

bash
git status
git add README.md
git commit -m "add professional README for project documentation"
git push