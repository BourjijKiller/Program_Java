package Exo3.personne;

import java.util.Objects;

public class Personne implements Comparable<Personne>
{
    /**
     * Variables caractérisant une personne
     */
    private String nom;
    private String prenom;

    /**
     * Créé une personne
     * @param nom nom de la personne
     * @param prenom prénom de la personne
     */
    public Personne(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Récupère le nom de la personne
     * @return nom de la personne
     */
    public String getNom()
    {
        return this.nom;
    }

    /**
     * Récupère le prénom de la personne
     * @return prénom de la personne
     */
    public String getPrenom()
    {
        return this.prenom;
    }

    /**
     * Affiche le nom et le prénom de la personne sous forme textuelle
     * @return nom et prénom
     */
    @Override
    public String toString()
    {
        return "\n" + this.getNom() + " " + this.getPrenom() + " ";
    }

    /**
     * Permet de regrouper des personnes dans des ensembles pour appeler ensuite la méthode {@link Personne#equals(Object)}()}
     * @return entier
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(this.nom, this.prenom);
    }

    /**
     * Permet de déterminer si deux objets sont identiques (en terme de référence)
     * @param o
     * @return vrai ou faux
     */
    @Override
    public boolean equals(Object o)
    {
        return (o != null && o instanceof Personne && this.nom.equals(((Personne)o).nom) && this.prenom.equals(((Personne)o).prenom));
    }

    /**
     * Permet de comparer deux personnes pour trier l'annuaire dans l'ordre alphabétique
     * @param o personne
     * @return
     */
    @Override
    public int compareTo(Personne o)
    {
        int result = this.nom.compareTo(o.nom);
        if(result != 0)
            return result;
        else
            return this.prenom.compareTo(o.prenom);
    }
}
