package Exo4.test;

import static org.junit.jupiter.api.Assertions.*;
import Exo4.main.Evaluable;
import Exo4.main.Listes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Truc implements Evaluable
{
    private int valeur;
    public Truc(int v)
    {
        valeur = v;
    }

    public double getValeur()
    {
        return valeur;
    }
}

public class TestListes
{

    public static void main(String[] args) throws Exception
    {

        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();
        List<StringBuilder> l3 = new LinkedList<StringBuilder>();
        l1.add("un"); l1.add("deux"); l1.add("trois");
        for( String s: l1)  {
            l2.add(new String(s));
            l3.add(new StringBuilder(s));
        }
        assert ( Listes.inverse(l3).toString().equals("[trois, deux, un]"));

        List<String> resultat = Listes.fusionne(l1, l2);
        assert ( resultat.toString().equals("[un, un, deux, deux, trois, trois]"));

        List<? extends CharSequence> resultat2 = Listes.fusionne(l1, l3);
        assert ( resultat2.toString().equals("[un, trois, deux, deux, trois, un]"));

        List<Truc> l4 = new ArrayList<Truc>();
        for (int i=1; i<6; i++) l4.add( new Truc(i));
        assert ( Listes.deuxFois(l4).toString().equals("[2.0, 4.0, 6.0, 8.0, 10.0]"));

        System.out.println( "_____ Fin du test _____");
    }
}