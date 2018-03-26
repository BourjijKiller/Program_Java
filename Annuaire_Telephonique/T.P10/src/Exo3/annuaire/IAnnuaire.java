package Exo3.annuaire;

import Exo3.exceptions.NumeroAbsent;
import Exo3.exceptions.NumeroDejaPresent;
import Exo3.exceptions.PersonneAbsente;
import Exo3.exceptions.PersonneDejaPresente;
import Exo3.numTel.IListeNumTel;
import Exo3.numTel.NumTel;
import Exo3.personne.Personne;

import java.util.Iterator;
import java.util.Set;

public interface IAnnuaire
{
    boolean ajouterEntree(Personne p, IListeNumTel nums) throws PersonneDejaPresente;
    void ajouterNumeroFin(Personne p, NumTel n) throws NumeroDejaPresent;
    void ajouterNumeroDebut(Personne p, NumTel n) throws NumeroDejaPresent;
    NumTel premierNumero(Personne p) throws PersonneAbsente;
    IListeNumTel numeros(Personne p) throws PersonneAbsente;
    Iterator personnes();
    void afficher();
    void supprimer(Personne p) throws PersonneAbsente;
    void supprimer(Personne p, int n) throws PersonneAbsente, NumeroAbsent;
    Set<Personne> personnesDeNomCommencantPar(String s);
}
