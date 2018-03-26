package Exo3.numTel;

import Exo3.exceptions.NumeroAbsent;
import Exo3.exceptions.NumeroDejaPresent;

import java.util.Iterator;

public interface IListeNumTel
{
    boolean ajouterFin(NumTel num) throws NumeroDejaPresent;
    boolean ajouterDebut(NumTel num) throws NumeroDejaPresent;
    boolean ajouter(int index, NumTel num) throws NumeroDejaPresent;
    NumTel premierNumero();
    NumTel numero(int index) throws NumeroAbsent;
    boolean contientNumero(int num);
    int nbNumeros();
    String toString();
    Iterator iterator();
    boolean retirer(int num) throws NumeroAbsent;
}
