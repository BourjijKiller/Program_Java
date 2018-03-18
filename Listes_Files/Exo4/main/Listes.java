package Exo4.main;

import java.util.*;

public class Listes<E> implements Evaluable
{

    /**
     * Multiplie par deux les valeurs de la liste
     * @param listeTemp
     * @return liste de Double contenant les valeurs des objets de la liste multipliées par deux
     */
    public static LinkedList<Double> deuxFois(List<? extends Evaluable> listeTemp) throws IllegalStateException
    {
        if(listeTemp.equals(Collections.EMPTY_LIST))
            throw new IllegalStateException("La liste est vide");
        LinkedList<Double> listeResult = new LinkedList<Double>();
        Iterator iterator = listeTemp.iterator();
        while(iterator.hasNext()) {
            listeResult.add(new Double(((Evaluable)iterator.next()).getValeur()*2));
        }

        return listeResult;
    }

    /**
     * Mélange 2 listes passées en paramètres
     * @param liste1
     * @param liste2
     * @return nouvelle liste mélangée
     * @throws Exception
     */
    public static<E> List<E> fusionne(List<E> liste1, List<E> liste2) throws Exception
    {
        if(liste1.size() != liste2.size())
            throw new Exception("Les listes ont des tailles différentes");
        else {
            List<E> listeMelange = new LinkedList<E>();
            Iterator i1 = liste1.iterator();
            Iterator i2 = liste2.iterator();

            while(i1.hasNext() && i2.hasNext()) {
                listeMelange.add((E) i1.next());
                listeMelange.add((E) i2.next());
            }

            return listeMelange;
        }
    }

    /**
     * Prend une liste en paramètre et renvoie une nouvelle liste avec les éléments dans l'ordre inverse de la liste passée en paramètre
     * @param listeTemp
     * @return liste dans l'ordre inverse
     */
    public static<E> List<E> inverse(List<E> listeTemp)
    {
        LinkedList<E> newListe = new LinkedList<E>();
        ListIterator listIterator = listeTemp.listIterator(listeTemp.size());
        while(listIterator.hasPrevious()) {
            newListe.add((E)listIterator.previous());
        }

        return newListe;
    }

    @Override
    public double getValeur()
    {
        return 0;
    }
}
