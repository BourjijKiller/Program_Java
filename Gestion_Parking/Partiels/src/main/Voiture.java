package main;

import java.util.Objects;

public class Voiture
{
    /**
     * Variables représentant une voiture de manière unique
     */
    private String modele;
    private String immatriculation;

    /**
     * Création d'une voiture
     * @param modele modèle de la voiture
     * @param immatriculation immatriculation de la voiture
     */
    public Voiture(String modele, String immatriculation)
    {
        this.modele = modele;
        this.immatriculation = immatriculation;
    }

    /**
     * Description textuelle d'une voiture
     * @return description de la voiture
     */
    @Override
    public String toString()
    {
        return this.modele + " [" + this.immatriculation + "]";
    }

    /**
     * Récupère le modèle d'une voiture
     * @return modèle
     */
    public String getModele()
    {
        return this.modele;
    }

    /**
     * Récupère l'immatriculation de la voiture
     * @return immatriculation
     */
    public String getImmatriculation()
    {
        return this.immatriculation;
    }

    /**
     * Redéfinition de la méthode hashCode de {@link Object#hashCode()}
     * Permet d'avoir un temps de gains pour savoir s'il faut passer par la méthode {@link Object#equals(Object)}
     * @return identifiant unique
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(modele, immatriculation);
    }

    /**
     * Redéfinition de la méthode equals de {@link Object#equals(Object)}
     * Permet de comparer si deux objets sont égaux sans comparer les références (méthode de base de la classe Object)
     * @param o objet
     * @return vrai ou faux
     */
    @Override
    public boolean equals(Object o)
    {
        return o != null && o instanceof Voiture && this.immatriculation.equals(((Voiture)o).immatriculation) && this.modele.equals(((Voiture)o).modele);
    }
}
