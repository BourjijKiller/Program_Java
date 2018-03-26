package Exo3.annuaire;

import Exo3.exceptions.NumeroAbsent;
import Exo3.exceptions.NumeroDejaPresent;
import Exo3.exceptions.PersonneAbsente;
import Exo3.exceptions.PersonneDejaPresente;
import Exo3.numTel.IListeNumTel;
import Exo3.numTel.ListeNumTel;
import Exo3.numTel.NumTel;
import Exo3.personne.Personne;

import java.util.*;

public class Annuaire implements IAnnuaire
{
    Map<Personne, IListeNumTel> hashMapAnnuaire;

    public Annuaire()
    {
        this.hashMapAnnuaire = new TreeMap<Personne, IListeNumTel>();
    }

    /**
     * Ajoute une personne et sa liste de numéro dans la table de hachage
     * @param p personne
     * @param nums liste des numéros
     * @return vrai ou faux
     * @throws PersonneDejaPresente si la personne à déjà une liste de numéros dans la HashMap
     */
    @Override
    public boolean ajouterEntree(Personne p, IListeNumTel nums) throws PersonneDejaPresente
    {
        if(this.hashMapAnnuaire.containsKey(p))
            throw new PersonneDejaPresente();
        else {
            this.hashMapAnnuaire.put(p, nums);
            return true;
        }
    }

    /**
     * Ajoute un numéro de téléphone dans la HashMap si la personne existe déjà
     * Sinon, on créé une liste avec son numéro, et on ajoute ensuite le couple personne/liste numéro dans la HashMap
     * @param p personne
     * @param n numéro de téléphone
     * @throws NumeroDejaPresent si le numéro existe déjà dans la liste
     */
    @Override
    public void ajouterNumeroFin(Personne p, NumTel n) throws NumeroDejaPresent
    {
        ListeNumTel listeNumTel;
        if(this.hashMapAnnuaire.containsKey(p)) {
            listeNumTel = (((ListeNumTel)this.hashMapAnnuaire.get(p)));
            listeNumTel.ajouterFin(n);
        }
        else {
            listeNumTel = new ListeNumTel();
            listeNumTel.ajouterFin(n);
            this.hashMapAnnuaire.put(p, listeNumTel);
        }
    }

    /**
     * Ajoute un numéro de téléphone dans la liste de numéros, puis cette liste dans la HashMap si la personne existe déjà dans la HashMap (on écrase l'ancienne liste par la nouvelle)
     * Sinon, on créé une liste avec le numéro en paramètre, et on ajoute ensuite le couple personne/liste numéro dans la HashMap
     * @param p personne
     * @param n numéro de téléphone
     * @throws NumeroDejaPresent si le numéro existe déjà
     */
    @Override
    public void ajouterNumeroDebut(Personne p, NumTel n) throws NumeroDejaPresent
    {
        ListeNumTel listeNumTel;
        if(this.hashMapAnnuaire.containsKey(p)) {
            listeNumTel = (((ListeNumTel)this.hashMapAnnuaire.get(p)));
            listeNumTel.ajouterDebut(n);
        }
        else {
            listeNumTel = new ListeNumTel();
            listeNumTel.ajouterDebut(n);
            this.hashMapAnnuaire.put(p, listeNumTel);
        }
    }

    /**
     * Permet de récupérer le premier numéro contenu dans la liste de numéro, contenu dans l'annuaire
     * @param p personne
     * @return premier numéro
     * @throws PersonneAbsente Si la personne n'existe pas dans l'annuaire
     */
    @Override
    public NumTel premierNumero(Personne p) throws PersonneAbsente
    {
        if(this.hashMapAnnuaire.containsKey(p))
            return this.hashMapAnnuaire.get(p).premierNumero();
        else
            throw new PersonneAbsente();
    }

    /**
     * Renvoie la liste des numéros en fonction de la personne p
     * @param p personne
     * @return liste des numéros
     * @throws PersonneAbsente Si la personne n'existe pas dans l'annuaire
     */
    @Override
    public IListeNumTel numeros(Personne p) throws PersonneAbsente
    {
        if(this.hashMapAnnuaire.containsKey(p))
            return this.hashMapAnnuaire.get(p);
        else
            throw new PersonneAbsente();
    }

    /**
     * Redéfinition de la méthode iterator()
     * @return pointeur sur les clés de la HashMap
     */
    @Override
    public Iterator personnes()
    {
        return this.hashMapAnnuaire.keySet().iterator();
    }

    /**
     * Affiche le contenu de l'annuaire
     */
    @Override
    public void afficher()
    {
        System.out.println(this.hashMapAnnuaire.toString());
    }

    /**
     * Supprime une personne de l'annuaire en fonction de p
     * @param p personne
     * @throws PersonneAbsente si la personne n'existe pas dans l'annuaire
     */
    @Override
    public void supprimer(Personne p) throws PersonneAbsente
    {
        if(this.hashMapAnnuaire.containsKey(p))
            this.hashMapAnnuaire.remove(p);
        else
            throw new PersonneAbsente();
    }

    /**
     * Supprime un numéro n en fonction de la personne p
     * @param p personne
     * @param n numéro à supprimer
     * @throws PersonneAbsente si la personne est absente de l'annuaire
     * @throws NumeroAbsent si le numéro n'existe pas dans la liste des numéros
     */
    @Override
    public void supprimer(Personne p, int n) throws PersonneAbsente, NumeroAbsent
    {
        if(this.hashMapAnnuaire.containsKey(p)) {
            ListeNumTel listeNumTel = (ListeNumTel)this.hashMapAnnuaire.get(p);
            if(listeNumTel.nbNumeros() == 1 && listeNumTel.premierNumero().getNum() == n)
                this.hashMapAnnuaire.remove(p);
            else
                listeNumTel.retirer(n);
        }
        else
            throw new PersonneAbsente();
    }

    /**
     * Ensemble de toutes les personnes de l'annuaire dont le nom débute par une chaîne donnée
     * @param s chaîne donnée
     * @return ensemble de personnes
     */
    @Override
    public Set<Personne> personnesDeNomCommencantPar(String s)
    {
        Set<Personne> personnes = new TreeSet<Personne>();
        Iterator iterator = this.hashMapAnnuaire.keySet().iterator();
        while (iterator.hasNext()) {
            Personne courante = (Personne) iterator.next();
            if(((Personne)courante).getNom().contains(s))
                personnes.add(courante);
        }
        return personnes;
    }

    /**
     * Méthode de test
     * @param args
     */
    public static void main(String[] args) throws NumeroDejaPresent, PersonneAbsente, PersonneDejaPresente, NumeroAbsent {
        /**
         * Déclaration de l'annuaire et des personnes
         */
        IAnnuaire annuaire = new Annuaire();
        Personne p1 = new Personne("Barret", "Valentin");
        Personne p2 = new Personne("Entezam", "Samuel");
        Personne p3 = new Personne("Grelu", "Dorian");
        Personne p4 = new Personne("Demange", "Lucie");
        Personne p5 = new Personne("Khan", "Pradap");
        Personne p6 = new Personne("Desad", "Julien");

        /**
         * Ajout des numéros dans l'annuaire
         */
        annuaire.ajouterNumeroDebut(p1, new NumTel(0154, "NP"));
        annuaire.ajouterNumeroDebut(p1, new NumTel(0256, "FD"));
        annuaire.ajouterNumeroDebut(p2, new NumTel(5489, "NF"));
        annuaire.ajouterNumeroDebut(p2, new NumTel(87545, "NP"));
        annuaire.ajouterNumeroDebut(p2, new NumTel(4123, "FD"));
        annuaire.ajouterNumeroDebut(p4, new NumTel(7777, "NP"));
        annuaire.ajouterNumeroFin(p4, new NumTel(0347, "FP"));
        annuaire.ajouterNumeroDebut(p3, new NumTel(4545, "NF"));
        annuaire.ajouterNumeroDebut(p3, new NumTel(1111, "FD"));

        /**
         * Affichage de l'annuaire
         */
        annuaire.afficher();

        System.out.println("\n ---------------------------------------------------- \n");

        /**
         * Suppression de Barret Valentin de l'annuaire
         */
        annuaire.supprimer(p1);

        /**
         * Affichage de l'annuaire
         */
        annuaire.afficher();

        /**
         * Ajout de la liste de numéros de la personne p5
         */
        ListeNumTel listeNumTelP5 = new ListeNumTel();
        listeNumTelP5.ajouterDebut(new NumTel(5641, "NP"));
        listeNumTelP5.ajouterFin(new NumTel(4101, "FP"));

        annuaire.ajouterEntree(p5, listeNumTelP5);

        System.out.println("\n ---------------------------------------------------- \n");

        /**
         * Affichage de l'annuaire
         */
        annuaire.afficher();

        /**
         * Suppression du numéro 5555 pour la personne p5
         * Doit renvoyer l'exception NumeroAbsent
         */
        //annuaire.supprimer(p5, 5555);
        annuaire.supprimer(p5, 4101);

        System.out.println("\n ---------------------------------------------------- \n");

        /**
         * Affichage de l'annuaire
         */
        annuaire.afficher();

        /**
         * Ajout de la personne p6 dans l'annuaire
         */

        annuaire.ajouterNumeroDebut(p6, new NumTel(1247, "FP"));
        annuaire.ajouterNumeroFin(p6, new NumTel(1974, "NP"));

        System.out.println("\n ---------------------------------------------------- \n");

        /**
         * Affichage de l'annuaire
         */
        annuaire.afficher();

        /**
         * Personne de l'annuaire commençant par De
         */
        System.out.println("\n Personnes de l'annuaire commençant par De : ");
        System.out.println(annuaire.personnesDeNomCommencantPar("De"));
    }
}
