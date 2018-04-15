package test;

import exceptions.ExceptionPlaceInexistante;
import exceptions.ExceptionPlaceLibre;
import exceptions.ExceptionPlaceOccupee;
import exceptions.ExceptionVoitureInexistante;
import main.Parking;
import main.Voiture;

import static java.lang.System.out;

public class testParking
{
    public static void main(String[] args) throws ExceptionPlaceInexistante, ExceptionPlaceOccupee, ExceptionVoitureInexistante, ExceptionPlaceLibre
    {
        Parking parking = new Parking(10);
        Voiture voiture1 = new Voiture("FERRARI 400", "BA-491-MT");
        Voiture voiture2 = new Voiture("BMW X6", "AN-145-TS");
        Voiture voiture3 = new Voiture("FORD KA", "BF-674-ST");
        Voiture voiture4 = new Voiture("Peugeot 3008", "SI-875-JK");

        out.println("\n ---------------- NUMERO DES PLACES LIBRES ---------------- \n");
        out.println(parking.placesLibres() + "\n");

        parking.gare(voiture1, 5);
        out.println(parking.toString());
        parking.gare(voiture2, 2);
        out.println(parking.toString());

        /*
        Doit renvoyer une exception
         */
        //parking.gare(voiture3, 2);
        parking.gare(voiture3, 3);

        /*
        Doit renvoyer une exception
         */
        //parking.gare(voiture4, 10);
        parking.gare(voiture4, 9);
        out.println(parking.toString());

        out.println("\n ---------------- NUMERO DES PLACES LIBRES ---------------- \n");
        out.println(parking.placesLibres() + "\n");

        out.println("\n ------------------- POSITION DES VOITURES ------------------- \n ");
        String immat1 = voiture1.getImmatriculation();
        String immat2 = voiture2.getImmatriculation();
        String immat3 = voiture4.getImmatriculation();
        String tab[] = new String[]{immat1, immat2, immat3};
        for(int i = 0; i < tab.length; i++)
            out.println("La voiture d'immatriculation " + tab[i] + " est garée à la place n°" + parking.position(tab[i]));

        out.println("\n ------------------- SUPPRESSION DES VOITURES ------------------- \n ");
        Voiture voiture;
        for (int i = 0; i < tab.length-1; i++) {
            voiture = parking.retire(tab[i]);
            out.println("Voiture " + voiture + " retirée du parking !");
        }

        out.println("\n ---------------- NUMERO DES PLACES LIBRES ---------------- \n");
        out.println(parking.placesLibres() + "\n");

        out.println(parking.toString());
    }
}
