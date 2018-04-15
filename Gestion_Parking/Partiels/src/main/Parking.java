package main;

import exceptions.ExceptionPlaceInexistante;
import exceptions.ExceptionPlaceLibre;
import exceptions.ExceptionPlaceOccupee;
import exceptions.ExceptionVoitureInexistante;

import java.util.*;

public class Parking implements Iterable<Map.Entry<Integer, Voiture>>
{
    private int nbPlaces;
    private HashMap<Integer, Voiture> parking;

    /**
     * Créé un parking avec une capacité initiale
     * @param nbPlaces nombre de places libres du parking
     */
    public Parking(int nbPlaces)
    {
        this.parking = new HashMap<Integer, Voiture>();
        for (int i = 0; i < nbPlaces; i++)
            this.parking.put(i, null);
    }

    /**
     * Gare la voiture à la place donnée
     * @param voiture voiture
     * @param numeroPlace numéro de place où il faut garer la voiture
     * @throws ExceptionPlaceInexistante si la place n'existe pas dans le parking
     * @throws ExceptionPlaceOccupee si la place est déjà occupée par une autre voiture
     */
    public void gare(Voiture voiture, int numeroPlace) throws ExceptionPlaceInexistante, ExceptionPlaceOccupee
    {
        if(voiture == null)
            throw new NullPointerException();
        else {
            if(numeroPlace < this.parking.size()) {
                if (this.parking.containsKey(numeroPlace) && this.parking.get(numeroPlace) != null)
                    throw new ExceptionPlaceOccupee();
                else
                    this.parking.put(numeroPlace, voiture);
            }
            else
                throw new ExceptionPlaceInexistante();
        }
    }

    /**
     * Retire la voiture du parking en fonction du numéro de place
     * @param numeroPlace numéro de place de la voiture à retirer
     * @return voiture retirée
     * @throws ExceptionPlaceInexistante si la place n'existe pas dans le parking
     * @throws ExceptionPlaceLibre si la place est libre (si la clé n'existe pas dans le parking)
     */
    public Voiture retire(int numeroPlace) throws ExceptionPlaceInexistante, ExceptionPlaceLibre
    {
        Voiture voitureRetiree = null;
        if(numeroPlace < this.parking.size()) {
            if(this.parking.containsKey(numeroPlace)) {
                voitureRetiree = (Voiture)this.parking.get(numeroPlace);
                this.parking.remove(numeroPlace);
            }
            else
                throw new ExceptionPlaceLibre();
        }
        else
            throw new ExceptionPlaceInexistante();
        return voitureRetiree;
    }

    /**
     * Description textuelle du parking seulement avec les places occupées
     * Redéfinition de la méthode {@link Object#toString()}
     * @return parking sous forme textuelle
     */
    @Override
    public String toString()
    {
        StringBuilder chaine = new StringBuilder();
        chaine.append("{");
        Iterator<Map.Entry<Integer, Voiture>> iterator = this.iterator();
        Map.Entry<Integer, Voiture> courant;
        while (iterator.hasNext()) {
            courant = iterator.next();
            if(courant.getValue() != null) {
                chaine.append(courant.getKey() + "=" + courant.getValue().toString() + ", ");
            }
        }
        chaine.deleteCharAt(chaine.length()-2);
        chaine.deleteCharAt(chaine.length()-1);
        chaine.append("}");
        return chaine.toString();
    }

    /**
     * Renseigne le numéro de place occupé par la voiture dont l'immatriculation est passé en paramètre
     * @param immatriculation de la voiture
     * @return numéro de place de parking
     */
    public int position(String immatriculation)
    {
        int position = -1;
        for (int i = 0; i < this.parking.size(); i++) {
            if(this.parking.get(i) != null) {
                if (this.parking.get(i).getImmatriculation().equals(immatriculation)) {
                    position = i;
                    break;
                }
            }
        }
        return position;
    }

    /**
     * Retire la voiture du parking en fonction de l'immatriculation
     * Utilisation de la méthode {@link Parking#position(String)} permettant de récupérer la position de la voiture en fonction de son immatriculation
     * Utilisation de la méthode {@link Parking#retire(int)} permettant de supprimer la voiture en fonction du résultat de {@link Parking#position(String)}
     * @param immatriculation immatriculation de la voiture
     * @return la voiture retirée du parking
     * @throws ExceptionVoitureInexistante Si la voiture n'existe pas dans le parking
     * @throws ExceptionPlaceInexistante si la place n'existe pas dans le parking
     * @throws ExceptionPlaceLibre si la place est libre (si la clé n'existe pas dans le parking)
     */
    public Voiture retire(String immatriculation) throws ExceptionVoitureInexistante, ExceptionPlaceInexistante, ExceptionPlaceLibre
    {
        int numeroPlace;
        Voiture voiture;
        numeroPlace = position(immatriculation);
        if(numeroPlace == -1)
            throw new ExceptionVoitureInexistante();
        else
            voiture = retire(numeroPlace);
        return voiture;
    }

    /**
     * Permet de lister les places libres du parking
     * @return ensemble de places libres
     */
    public List<Integer> placesLibres()
    {
        List<Integer> listPlacesLibres = new ArrayList<Integer>();
        for(int i = 0; i < this.parking.size(); i++) {
            if(this.parking.get(i) == null)
                listPlacesLibres.add(i);
        }
        return listPlacesLibres;
    }

    /**
     * Redéfinition de la méthode {@link Iterable#iterator()}
     * @return liste de pointeurs
     */
    @Override
    public Iterator<Map.Entry<Integer, Voiture>> iterator()
    {
        return this.parking.entrySet().iterator();
    }
}
