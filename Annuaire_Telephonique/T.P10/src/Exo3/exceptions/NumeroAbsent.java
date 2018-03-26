package Exo3.exceptions;

public class NumeroAbsent extends Exception
{
    public NumeroAbsent()
    {
        super("Le numéro n'est pas contenu dans la liste");
    }
}
