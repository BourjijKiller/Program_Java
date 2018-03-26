package Exo1;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Auteur
{
    private final String prenom;
    private final String nom;
    private int hashCode;

    public Auteur(String prenom,String nom)
    {
        this.prenom=prenom;
        this.nom=nom;
        this.hashCode = prenom.hashCode() + nom.hashCode();
    }

    @Override
    public String toString()
    {
        return this.prenom + ' ' + this.nom;
    }

    @Override
    public int hashCode()
    {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object o)
    {
        return ((o != null) && (o instanceof Auteur) && (this.nom.equals(((Auteur)o).nom)) && (this.prenom.equals(((Auteur)o).prenom)));
    }

    public static void main(String[] args)
    {
        Map<Object,Object> m=new HashMap<Object,Object>();
        Auteur victorHugo=new Auteur("Victor","Hugo");
        m.put(victorHugo, "12345");
        m.put("1",victorHugo);
        m.put(new Integer(2),new Auteur("Victor","Hugo"));
        m.put(new Integer(2),new Auteur("Emile","Zola"));
        System.out.println(m.get(victorHugo));
        System.out.println(m.get(new Auteur("Victor","Hugo")));
        System.out.println(m.get("1"));
        System.out.println(m.get(new Integer(2)));
        Iterator<Object> i=m.keySet().iterator();
        while (i.hasNext())
            System.out.print(i.next()+"-");
        System.out.println();
        i=m.values().iterator();
        while (i.hasNext())
            System.out.print(i.next()+"-");
        System.out.println();
        Iterator<Map.Entry<Object,Object>> i2=m.entrySet().iterator();
        while (i2.hasNext())
            System.out.print(i2.next()+"-");
        System.out.println();
    }
}

/*
Le résultat de l'exécution de ce programme nous renvoie tout d'abord :
    12345, étant donné que notre HashMap contient, pour la clé victorHugo, la valeur 12345, si on récupère HashMap.get(victorHugo), la valeur sera bien 12345
    Ensuite, on obtiens null. On essaye d'afficher la valeur de la clé contenant une nouvelle instance d'auteur, mais on ne l'a pas ajouté au préalable à la HashMap, donc sa valeur est bien null
    On affiche ensuite la valeur de la clé 1, qui correspond bien à la valeur Victor Hugo
    On affiche ensuite la valeur de la clé 2, qui correspond bien à la valeur Emil Zola. Cependant, on pet noter que l'ancienne valeur de la clé 2 correspondait à Victor Hugo, mais a été écrasée par Emil Zola
    Pour finir, on parcours la collection Map pour afficher l'ensemble des clés, l'ensembles des valeurs et l'ensembles des paires clés/valeurs
 */