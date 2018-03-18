package Exo3.main;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class FileAvecPriorite<E> implements Iterable<E>
{
    private PriorityQueue<E> fileDePriorite;

    /**
     * Créé une file de priorité
     */
    public FileAvecPriorite()
    {
        this.fileDePriorite = new PriorityQueue<E>();
    }

    public FileAvecPriorite(Comparator<E> e)
    {
        this.fileDePriorite = new PriorityQueue<E>(5, e);
    }

    /**
     * Ajoute un objet à la file
     * @param e objet
     */
    public void ajoute(E e)
    {
        this.fileDePriorite.offer(e);
    }

    /**
     * Enleve et renvoie l'élément le plus anciennement ajouté à la file
     * @return element E
     */
    public E enleve()
    {
        return this.fileDePriorite.poll();
    }

    /**
     * Renvoie le premier élément ajouté à la file
     * @return element E
     */
    public E prioritaire()
    {
        return this.fileDePriorite.peek();
    }

    /**
     * Taille de la file de priorité
     * @return entier
     */
    public int taille()
    {
        return this.fileDePriorite.size();
    }

    /**
     * Affiche la file de priorité sous forme d'une chaine de caractères
     * @return string
     */
    @Override
    public String toString()
    {
        return this.fileDePriorite.toString();
    }

    /**
     * Redéfinition de la méthode iterator de l'interface Iterable
     * @return iterateur
     */
    @Override
    public Iterator<E> iterator()
    {
        return this.fileDePriorite.iterator();
    }
}
