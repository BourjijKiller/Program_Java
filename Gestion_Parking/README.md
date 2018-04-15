# GESTION D'UN PARKING

-----------------------------------------------------------------------

## DESCRIPTION

Création d'un programme Java permettant de gérer un parking contenant des voitures. Une voiture est représenté par :
* Un _modèle_ (par exemple, une voiture de modèle **BMW**)
* Une _immatriculation_
et est définie par une classe **Voiture.java**.

Lors de la création du parking, représenté par une classe **Parking.java**, une capacité maximale de place est définie afin de créer un parking contenant un nombre **nbPlaces** de places.
Ce parking contient donc deux données :
1. Le numéro de place
2. La voiture garée associée au numéro de place

Le mieux est donc de représenter le parking par une collection de type [HashMap<clé, valeur>](https://openclassrooms.com/courses/java-et-les-collections/l-interface-map-k-v) ou la **clé** sera représenté par le numéro de place, et la **valeur** contiendra la voiture.

Lors de l'ajout d'une voiture dans le parking, le programme Java vérifie que :
* La place est libre, c'est-à-dire que la valeur de la clé de la collection vaut **_null_** (aucune voiture)
* La place existe dans le parking, c'est-à-dire que le numéro de place est strictement inférieur à la capacité du parking.
Si ces conditions ne sont pas respectées, des **exceptions** sont levées et bloque ainsi l'ajout de la voiture dans le parking.

D'autres exceptions peuvent-être levées si :
* La place est libre, notamment lors du départ d'une voiture de la place. Si la place est libre, cela signifie qu'il n'y a pas de voiture garée, donc on ne peut pas la retirer.
* La voiture est inexistante, lors du départ de la voiture du parking.

Les **exceptions** personnalisées sont représentées par des classes Java.

--------------------------------------------------------

## OPÉRATIONS POSSIBLES

La classe **Parking.java** contient des métodes :
1. `public Parking(int nbPlaces)` permettant de créer un parking avec une capacité de **nbPlaces**.
2. `public void gare(Voiture voiture, int numeroPlace) throws ExceptionPlaceInexistante, ExceptionPlaceOccupee` permettant de garer des voitures dans le parking, en fonction du numéro de place **numeroPlace** passé en paramètre de la méthode.
3. `public Voiture retire(int numeroPlace) throws ExceptionPlaceInexistante, ExceptionPlaceLibre` permettant de retirer une voiture du parking en fonction du numéro de la place **numeroPlace**.
4. `@Override
    public String toString()` permettant de représenter sous forme textuelle le contenu du parking.
5. `public int position(String immatriculation)` permettant de récupérer le numéro de place en fonction de l'immatriculation de la voiture **immatriculation** passée en paramètre.
6. `public Voiture retire(String immatriculation) throws ExceptionVoitureInexistante, ExceptionPlaceInexistante, ExceptionPlaceLibre` permettant de retirer une voiture du parking en fonction de l'immatriculation **immatriculation** de la voiture.
7. `public List<Integer> placesLibres()` permettant de récupérer les places libres du parking sous forme d'une liste de nombre entier, représentant les numéros de place du parking.

--------------------------------------------------------

## NOTIONS UTILISÉES

1. **Classe**
2. **Objet**
3. **Attribut**
4. **Méthode**
5. **Constructeur**
6. **Polymorphisme**
7. **Surcharge**
8. **Interface Set, List et Map**
9. **Exception**
10. **Collections**

--------------------------------------------------------

## UTILISATION

Ce projet est développé avec l'outil de développement [IntelliJ IDEA](https://www.jetbrains.com/idea/).
Les codes sources sont situés dans le dossier **src/** avec :
* Le package **main/** contenant les classes principales **Parking** et **Voiture**
* Le package **exception/** contenant **_les exceptions_** Java utilisées dans les classes
* Le package **test/** contenant la classe de test