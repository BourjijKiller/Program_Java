package Exo3.exceptions;

public class PersonneDejaPresente extends Exception
{
    public PersonneDejaPresente()
    {
        super("La personne est déjà présente dans l'annuaire !");
    }
}
