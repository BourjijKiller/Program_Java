package Exo3.test;

import Exo3.main.*;

import static org.junit.jupiter.api.Assertions.*;

class FileSansDoublonsTest
{
    public static void main( String [] args) {
        // le 3eme parametre du constructeur de Personne est un entier necessaire pour la question 3
        Personne p1 = new Personne("Marc", "Assin", 5);
        Personne p2 = new Personne("Laure", "Eole", 3);
        Personne p3 = new Personne("Sacha", "Touille", 3);
        Personne p4 = new Personne("Clement", "Tine", 5);
        Personne p5 = new Personne("Lara", "Tatouille", 1);
        Personne p6 = new Personne("Paul", "Emique", 2);
        File<Personne> f1 = new FileSansDoublons<Personne>();
        File<Personne> f2 = new FileSansDoublons<Personne>();
        File<Personne> f3;
        StringBuilder resultat;

        /*** question 2 ***/
        f1.ajoute( p1);
        f1.ajoute( p2);f1.ajoute( p2);f1.ajoute( p2);f1.ajoute( p2);
        f1.ajoute( new Personne("Marc","Assin", 150));
        assert( f1.taille() == 2);
        assert( f1.toString().equals("[Marc Assin, Laure Eole]"));
        assert( f1.prioritaire().toString().equals("Marc Assin"));
        resultat = new StringBuilder();
        for (Personne p : f1)
            resultat.append( p.getNom() + " ");
        assert( resultat.toString().equals("Assin Eole "));

        f2.ajoute( p3);
        f2.ajoute( p4);
        f2.ajoute( p5);
        f2.ajoute( p6);
        assert( f2.taille() == 4);
        assert( f2.toString().equals( "[Sacha Touille, Clement Tine, " + "Lara Tatouille, Paul Emique]"));

        f3 = f1.melange(f2);
        assert( f3.taille() == 6);
        assert( f3.toString().equals( "[Marc Assin, Sacha Touille, Laure Eole, "
                + "Clement Tine, Lara Tatouille, Paul Emique]"));
        p6.setNom("Ochon");
        assert( f2.toString().equals( "[Sacha Touille, Clement Tine, "
                + "Lara Tatouille, Paul Ochon]"));
        assert( f3.toString().equals( "[Marc Assin, Sacha Touille, Laure Eole, "
                + "Clement Tine, Lara Tatouille, Paul Ochon]"));

        resultat = new StringBuilder();
        while ( f2.taille() > 0 )
            resultat.append( f2.enleve().getNom() + " ");
        assert( resultat.toString().equals("Touille Tine Tatouille Ochon "));
        assert( f2.taille() == 0);

        // code a "activer" pour la question 3

        // Les personnes ont une valeur de priorite donnee en 3e parametre du constructeur

        // Les personnes les plus prioritaires dans f4 doivent etre celles qui ont la plus PETITE priorite
        FileAvecPriorite<Personne> 	f4 = new FileAvecPriorite<Personne>();
        for (Personne p : f3) f4.ajoute(p);
        assert( f4.taille() == 6);
        assert( f4.toString().equals( "[Lara Tatouille, Sacha Touille, Paul Ochon, " + "Clement Tine, Marc Assin, Laure Eole]"));
        resultat = new StringBuilder();
        while ( f4.taille() > 0 ) {
            Personne courant = f4.enleve();
            resultat.append( courant.getNom() + "(" + courant.getPriorite() + ") ");
        }
        assert( resultat.toString().equals("Tatouille(1) Ochon(2) Touille(3) " + "Eole(3) Tine(5) Assin(5) "));

         // Les personnes les plus prioritaires dans f5 doivent etre celles qui ont la plus GRANDE priorite
        FileAvecPriorite<Personne> f5 = new FileAvecPriorite<Personne>(new ComparateurDePersonnesParPriorite());
        for (Personne p : f3) f5.ajoute(p);
        resultat = new StringBuilder();
        while ( f5.taille() > 0 ) {
            Personne courant = f5.enleve();
            resultat.append( courant.getNom() + "(" + courant.getPriorite() + ") ");
         }

        assert( resultat.toString().equals("Assin(5) Tine(5) Touille(3) " + "Eole(3) Ochon(2) Tatouille(1) "));
        System.out.println( "____________________ Fin du test ____________________");
    }
}