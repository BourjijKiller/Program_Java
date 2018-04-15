package exceptions;

public class ExceptionVoitureInexistante extends Exception
{
    public ExceptionVoitureInexistante()
    {
        super("La voiture n'existe pas dans le parking !");
    }
}
