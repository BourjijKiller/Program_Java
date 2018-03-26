package Exo3.numTel;

import Exo3.exceptions.NumeroAbsent;
import Exo3.exceptions.NumeroDejaPresent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListeNumTel implements IListeNumTel, Iterable<NumTel>
{
    private List<NumTel> numTelList;

    public ListeNumTel()
    {
        this.numTelList = new ArrayList<NumTel>();
    }

    /**
     * Ajoute un numéro en fin de liste
     * @param num numéro de téléphone
     * @return true
     * @throws NumeroDejaPresent si le numéro est déjà présent dans la liste
     */
    @Override
    public boolean ajouterFin(NumTel num) throws NumeroDejaPresent
    {
        if(this.numTelList.contains(num))
            throw new NumeroDejaPresent();
        else
            this.numTelList.add(num);
        return true;
    }

    /**
     * Ajoute un numéro en début de liste
     * @param num numéro de téléphone
     * @return true
     * @throws NumeroDejaPresent si le numéro est déjà présent
     */
    @Override
    public boolean ajouterDebut(NumTel num) throws NumeroDejaPresent {
        if(this.numTelList.contains(num))
            throw new NumeroDejaPresent();
        else
            this.numTelList.add(0, num);
        return true;
    }

    /**
     * Ajoute un numéro dans la liste en fonction de l'index précisé
     * @param index emplacement dans la liste
     * @param num numéro de téléphone
     * @return true
     */
    @Override
    public boolean ajouter(int index, NumTel num) throws NumeroDejaPresent {
        if(this.numTelList.contains(num))
            throw new NumeroDejaPresent();
        else
            this.numTelList.add(index, num);
        return true;
    }

    /**
     * Renvoie le premier numéro de la liste
     * @return premier numéro
     */
    @Override
    public NumTel premierNumero()
    {
        return this.numTelList.get(0);
    }


    /**
     * Numéro de téléphone en fonction d'un index de la liste
     * @param index de la liste
     * @return numéro de téléphone
     * @throws NumeroAbsent si le numéro n'existe pas à l'index précisé
     */
    @Override
    public NumTel numero(int index) throws NumeroAbsent {
        if(this.numTelList.get(index) != null)
            return this.numTelList.get(index);
        else
            throw new NumeroAbsent();
    }

    /**
     * Vérifie si le numéro passé en paramètre existe dans la liste de numéro
     * @param num numéro
     * @return vrai si le numéro est contenu dans la liste, faux sinon
     */
    @Override
    public boolean contientNumero(int num)
    {
        boolean isValid = false;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if(((NumTel)iterator.next()).getNum() == num)
                isValid = true;
        }
        return isValid;
    }

    /**
     * Taille de la liste des numéros
     * @return taille de la liste
     */
    @Override
    public int nbNumeros()
    {
        return this.numTelList.size();
    }

    /**
     * Redéfinition de la méthode iterator()
     * @return iterator()
     */
    @Override
    public Iterator<NumTel> iterator()
    {
        return this.numTelList.iterator();
    }

    /**
     * Supprime un numéro de la liste
     * @param num numéro de téléphone
     * @return vrai si le numéro a été retiré, false sinon
     * @throws NumeroAbsent si le numéro n'existe pas dans la liste
     */
    @Override
    public boolean retirer(int num) throws NumeroAbsent {
        boolean isValid = false;
        if(this.nbNumeros() > 1) {
            Iterator iterator = this.iterator();
            while (iterator.hasNext()) {
                if(((NumTel) iterator.next()).getNum() == num) {
                    iterator.remove();
                    isValid = true;
                }
            }
            if(!isValid)
                throw new NumeroAbsent();
        }
        else
            System.err.println("Liste vide");
        return isValid;
    }

    /**
     * Affiche la liste des numéros sous forme textuelle
     * @return liste de numéros
     */
    @Override
    public String toString()
    {
        return this.numTelList.toString();
    }

    /**
     * Méthode de test
     * @param args
     */
    public static void main(String[] args) throws NumeroDejaPresent, NumeroAbsent {
        NumTel numTelDorian = new NumTel(521653, "NP");
        NumTel numTelSamuel = new NumTel(0647667375, "NP");
        NumTel numTelDorianFixe = new NumTel(56487, "FP");
        ListeNumTel listeNumTel = new ListeNumTel();
        listeNumTel.ajouterFin(numTelDorian);
        listeNumTel.ajouterDebut(numTelSamuel);
        listeNumTel.ajouterDebut(numTelDorianFixe);
        //listeNumTel.ajouterDebut(numTelDorian); --> renvoie l'exception
        System.out.println(listeNumTel.toString());
        System.out.println(listeNumTel.contientNumero(56487));
        System.out.println(listeNumTel.contientNumero(58));
        listeNumTel.retirer(0647667375);
        System.out.println(listeNumTel.toString());
    }
}
