package Exo2;

import java.util.*;

class Cle
{
    String ident;
    public Cle(String id)
    {
        this.ident = id;
    }

    public String toString()
    {
        return this.ident;
    }

    public int hashCode()
    {
        return ident.hashCode();
    }

    public boolean equals(Object r)
    {
        return (r instanceof Cle) && ident.equals(((Cle)r).ident);
    }
    public void finalize()
    {
        System.out.println("Finalisation Cle "+ident);
    }
}

class Valeur
{
    String ident;
    public Valeur(String id)
    {
        ident = id;
    }

    public String toString()
    {
        return ident;
    }

    public void finalize()
    {
        System.out.println("Finalisation Valeur "+ident);
    }
}

public class MappingCanonique {
    public static void main(String[] args) {
        int taille = 10;
        Cle[] cles = new Cle[taille];
        WeakHashMap<Cle,Valeur> whm = new WeakHashMap<Cle,Valeur>();
        for( int i = 0; i < taille; i++ ) {
            Cle c = new Cle( Integer.toString( i));
            Valeur v = new Valeur( Integer.toString( i));
            if ( i % 3 == 0 ) cles[ i] = c; // Sauvegarde comme une "vraie" reference
            whm.put( c, v);
        }
        Iterator<Cle> i=whm.keySet().iterator();
        while (i.hasNext()) System.out.print(i.next()+" ");
        System.out.println();
        System.gc();
        i=whm.keySet().iterator();
        while (i.hasNext()) System.out.print(i.next()+" ");
        System.out.println();
    }
}
