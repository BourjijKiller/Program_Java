package exceptions;

public class ExceptionPlaceInexistante extends Exception
{
    public ExceptionPlaceInexistante()
    {
        super("Le numéro de place renseigné n'existe pas dans le parking !");
    }
}
