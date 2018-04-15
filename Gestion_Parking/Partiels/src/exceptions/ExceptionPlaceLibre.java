package exceptions;

public class ExceptionPlaceLibre extends Exception
{
    public ExceptionPlaceLibre()
    {
        super("La place est libre, il n'y a pas de voiture !");
    }
}
