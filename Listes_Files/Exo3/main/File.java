package Exo3.main;

import java.util.*;

public class File<E> implements Iterable<E>
{
    private LinkedList<E> file;

    /**
     * Création d'une file
     */
    public File()
    {
        this.file = new LinkedList<E>();
    }

    /**
     * Ajoute un élément dans la file
     * @param e
     */
    public void ajoute(E e)
    {
        this.file.add(e);
    }

    /**
     * Renvoie l'élément le plus anciennement ajouté (le 1er dans un FIFO)
     * @return E
     */
    public E prioritaire()
    {
        return this.file.peek();
    }

    /**
     * Supprime l'élément le plus anciennement ajouté (le 1er dans un FIFO)
     * @return E
     */
    public E enleve()
    {
        return this.file.poll();
    }

    /**
     * Renvoie la taille de la file
     * @return taille de la file
     */
    public int taille()
    {
        return this.file.size();
    }

    /**
     * Vérifie si la file contient ou pas l'objet passé en paramètre
     * @param e
     * @return vrai ou faux
     */
    public boolean contientElement(E e)
    {
        return this.file.contains(e);
    }

    /**
     * Retourne le contenu de la file sous forme de chaine de caractères
     * @return string
     */
    @Override
    public String toString()
    {
        return this.file.toString();
    }

    /**
     * Crée une nouvelle file en prenant alternativement un élément de la file et un élément de la file en paramètre f
     * La nouvelle file sera une ArrayList et non pas une PriorityQueue, sinon le mélange se fera en fonction des valeurs de prioritées
     * @param file
     * @return file mélangée
     */
    public File<E> melange(File<E> file)
    {
        File<E> liste = new File<E>();
        Iterator<E> i1 = iterator();
        Iterator<E> i2 = file.iterator();

        while(i1.hasNext() && i2.hasNext()) {
            liste.ajoute(i1.next());
            liste.ajoute(i2.next());
        }

        while(i1.hasNext()) {
            liste.ajoute(i1.next());
        }

        while(i2.hasNext()) {
            liste.ajoute(i2.next());
        }
        return liste;
    }

    /**
     * Redéfinition de la méthode iterator()
     * @return itérateur
     */
    @Override
    public Iterator<E> iterator() {
        return this.file.iterator();
    }

    /**
     * Méthode de test
     * @param args
     */
    public static void main(String[] args)
    {
        File file = new File();
        File filetmp = new File();
        for(int i = 0; i < 10; i++)
            file.ajoute(i);
        for(int i = 20; i < 30; i++)
            filetmp.ajoute(i);
        System.out.println(file.toString());
        System.out.println(filetmp.toString());

        System.out.println(file.melange(filetmp));
    }
}