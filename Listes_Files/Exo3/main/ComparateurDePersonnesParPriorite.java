package Exo3.main;

import java.util.Comparator;

public class ComparateurDePersonnesParPriorite implements Comparator<Personne>
{
    public ComparateurDePersonnesParPriorite()
    {

    }

    /**
     * Compare la priorité de deux personnes
     * @param p1
     * @param p2
     * @return différence de priorité sous forme d'int
     */
    @Override
    public int compare(Personne p1, Personne p2)
    {
        return p1.getPriorite() - p2.getPriorite();
    }
}
