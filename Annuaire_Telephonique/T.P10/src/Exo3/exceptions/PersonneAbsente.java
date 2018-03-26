package Exo3.exceptions;

public class PersonneAbsente extends Exception
{
    public PersonneAbsente()
    {
        super("La personne n'existe pas");
    }
}
