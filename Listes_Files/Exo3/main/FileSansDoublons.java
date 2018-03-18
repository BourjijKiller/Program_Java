package Exo3.main;

public class FileSansDoublons<E> extends File<E>
{
    /**
     * Construit une file sans doublons
     */
    public FileSansDoublons()
    {
        super();
    }

    /**
     * Redéfinition de la méthode ajoute de la classe File, avec ajout d'une vérification de l'existence des doublons
     * @param e
     */
    @Override
    public void ajoute(E e)
    {
        if(!contientElement(e))
            super.ajoute(e);
    }
}
