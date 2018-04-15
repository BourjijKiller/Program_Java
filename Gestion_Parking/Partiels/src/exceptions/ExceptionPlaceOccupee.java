package exceptions;

public class ExceptionPlaceOccupee extends Exception
{
    public ExceptionPlaceOccupee()
    {
        super("La place renseignée est déjà occupée par une autre voiture !");
    }
}
