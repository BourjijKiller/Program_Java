package Exo3.main;

public class Personne implements Comparable<Personne>
{
    private String nom;
    private String prenom;
    private int priorite;

    /**
     * Créé une personne
     * @param nom
     * @param prenom
     * @param priorite
     */
    public Personne(String nom, String prenom, int priorite)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.priorite = priorite;
    }

    /**
     * Récupère le nom de la personne
     * @return nom de la personne
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Change le nom de la personne
     * @param value
     */
    public void setNom(String value)
    {
        this.nom = value;
    }

    /**
     * Récupère la priorité d'une personne
     * @return priorité de la personne
     */
    public int getPriorite()
    {
        return this.priorite;
    }

    /**
     * Affiche les détails de la personne sous forme d'une chaine de caractères
     * @return
     */
    @Override
    public String toString()
    {
        return this.nom + " " + this.prenom;
    }

    /**
     * Compare la priorité entre l'objet courant et l'objet passé en paramètre
     * @param p1
     * @return différence de priorité int
     */
    @Override
    public int compareTo(Personne p1)
    {
        return this.getPriorite() - p1.getPriorite();
    }

    /**
     * Vérifie l'égalité des noms et prénoms entre l'objet courant et l'objet passé en paramètre
     * @param obj
     * @return vrai ou faux
     */
    @Override
    public boolean equals(Object obj)
    {
        return obj != null && obj instanceof Personne && this.nom.equals(((Personne) obj).nom) && this.prenom.equals(((Personne) obj).prenom);
    }
}
