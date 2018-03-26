package Exo3.exceptions;

public class NumeroDejaPresent extends Exception
{
    public NumeroDejaPresent()
    {
        super("Le numéro de téléphone est déjà présent dans la liste");
    }
}
