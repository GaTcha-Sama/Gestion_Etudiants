// cSpell:disable

// package cas1;

import java.time.LocalDate;

public class Etudiant {
    // Attributs privés de la classe
    private String matricule;
    private String nom;
    private String genre;
    private LocalDate dateNaissance;
    private double moyenne;

    // Constructeur
    public Etudiant(String matricule, String nom, String genre, LocalDate dateNaissance, double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.moyenne = moyenne;
    }

    // Getters et Setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public void afficher() {
        System.out.println("Informations de l'etudiant :");
        System.out.println("Matricule : " + this.matricule);
        System.out.println("Nom : " + this.nom);
        System.out.println("Genre : " + this.genre);
        System.out.println("Date de naissance : " + this.dateNaissance);
        System.out.println("Moyenne : " + this.moyenne);
    }

    public int calculerAge() {
        return LocalDate.now().getYear() - this.dateNaissance.getYear();
    }

    public void bonifier(double bonus) {
        if (bonus > 0) {
            double nouvelleMoyenne = this.moyenne + bonus;
            this.moyenne = Math.min(nouvelleMoyenne, 20.0);
        }
    }
}
