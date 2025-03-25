package cas1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GestionEtudiants {
    private static Etudiant[] etudiants;
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.print("Entrez le nombre d'etudiants: ");
        int nbEtud = scanner.nextInt();
        etudiants = new Etudiant[nbEtud];

        enregistrerEtudiants();

        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();
            
            switch (choix) {
                case 1:
                    afficherParMerite();
                    break;
                case 2:
                    afficherPremierEtudiant();
                    break;
                case 3:
                    afficherDernierEtudiant();
                    break;
                case 4:
                    reinitialiserListe();
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }

    private static void enregistrerEtudiants() {
        for (int i = 0; i < etudiants.length; i++) {
            System.out.println("\nEnregistrement de l'etudiant " + (i+1));
            System.out.print("Matricule: ");
            String matricule = scanner.next();
            
            System.out.print("Nom: ");
            String nom = scanner.next();
            
            System.out.print("Genre (M/F): ");
            String genre = scanner.next();
            
            System.out.print("Date de naissance (dd/MM/yyyy): ");
            String dateStr = scanner.next();
            LocalDate dateNaissance = LocalDate.parse(dateStr, DATE_FORMATTER);
            
            System.out.print("Moyenne: ");
            double moyenne = scanner.nextDouble();

            etudiants[i] = new Etudiant(matricule, nom, genre, dateNaissance, moyenne);
        }
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Afficher les etudiants par ordre de merite");
        System.out.println("2. Afficher les informations du premier etudiant");
        System.out.println("3. Afficher les informations du dernier etudiant");
        System.out.println("4. Reinitialiser la liste de la classe");
        System.out.println("5. Quitter");
        System.out.print("Votre choix: ");
    }

    private static void afficherParMerite() {
        Etudiant[] copie = Arrays.copyOf(etudiants, etudiants.length);
        Arrays.sort(copie, Comparator.comparingDouble(Etudiant::getMoyenne).reversed());
        
        System.out.println("\nListe des etudiants par ordre de merite:");
        for (Etudiant etudiant : copie) {
            etudiant.afficher();
            System.out.println("------------------------");
        }
    }

    private static void afficherPremierEtudiant() {
        if (etudiants.length > 0) {
            System.out.println("\nPremier etudiant:");
            etudiants[0].afficher();
        } else {
            System.out.println("Aucun etudiant dans la liste!");
        }
    }

    private static void afficherDernierEtudiant() {
        if (etudiants.length > 0) {
            System.out.println("\nDernier etudiant:");
            etudiants[etudiants.length - 1].afficher();
        } else {
            System.out.println("Aucun etudiant dans la liste!");
        }
    }

    private static void reinitialiserListe() {
        etudiants = new Etudiant[0];
        System.out.println("Liste reinitialisee avec succes!");
    }
} 