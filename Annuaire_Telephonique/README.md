# GESTION D'UN ANNUAIRE TÉLÉPHONIQUE

--------------------------------------------------------

## DESCRIPTION

Création d'un programme Java permettant de gérer un annuaire téléphonique contenant de nombreuses informations :
* Le **nom** et **prénom** de la personne
* Pour chaque personne est associée un ou plusieurs numéros de téléphone pouvant représenter :
	1. Un numéro de type _Fixe professionnel_ **(FP)**
	2. Un numéro de type _Numéro de portable_ **(NP)**
	3. Un numéro de type _Fixe domicile_ **(FD)**
	4. Un numéro de type _Numéro de faxe_ **(NF)**

Lors de l'ajout d'une personne dans l'annuaire, on renseigne donc son nom et prénom, ainsi que la liste des numéros de téléphone, contenant **le numéro de téléphone** ainsi que le type de numéro représenté par un **code**.

Certains blocages sont présents. On ne peut pas ajouter :
* Une personne déjà existante dans l'annuaire.
* Un numéro déjà existant dans la liste de numéros de la personne.

L'annunaire est représenté sous forme d'une [HashMap](https://openclassrooms.com/courses/java-et-les-collections/l-interface-map-k-v), ce qui est le plus adapté. Elle prend en **clé** la personne, et en valeur de chaque clé, une **liste de numéro** représenté par l'interface [List](https://openclassrooms.com/courses/java-et-les-collections/l-interface-list-e).
On peut donc ainsi stocker de nombreuses données.

Chaque objets est représenté par une classe :
* Une personne est représenté par une classe Java **Personne.java**
* Un numéro de téléphone est représenté par une classe Java **NumTel.java**
* La liste des numéros de téléphone est représenté par une classe java **ListNumTel.java**

Le package contenant le programme sur l'annuaire étant le package **Exo3/**, les autres packages étant des exemples d'applications pour les notions de manipulation des **Collections** en Java (**HashMap**).

![](https://image.noelshack.com/fichiers/2018/13/1/1522091367-capture.png)

--------------------------------------------------------

## OPÉRATIONS POSSIBLES

L'interface **IAnnuaire** possède un ensemble de méthodes, définit dans la classe **Annuaire**, qui définit ainsi de nombreuses opérations :

```java
/**
 * Ajoute un numéro de téléphone dans la HashMap si la personne existe déjà
 * Sinon, on créé une liste avec son numéro, et on ajoute ensuite le couple personne/liste numéro dans la HashMap
 * @param p personne
 * @param n numéro de téléphone
 * @throws NumeroDejaPresent si le numéro existe déjà dans la liste
 */
@Override
public void ajouterNumeroFin(Personne p, NumTel n) throws NumeroDejaPresent
```

```java
/**
 * Ajoute un numéro de téléphone dans la liste de numéros, puis cette liste dans la HashMap si la personne existe déjà dans la HashMap (on écrase l'ancienne liste par la nouvelle)
 * Sinon, on créé une liste avec le numéro en paramètre, et on ajoute ensuite le couple personne/liste numéro dans la HashMap
 * @param p personne
 * @param n numéro de téléphone
 * @throws NumeroDejaPresent si le numéro existe déjà
 */
@Override
public void ajouterNumeroDebut(Personne p, NumTel n) throws NumeroDejaPresent
```

```java
/**
 * Permet de récupérer le premier numéro contenu dans la liste de numéro, contenu dans l'annuaire
 * @param p personne
 * @return premier numéro
 * @throws PersonneAbsente Si la personne n'existe pas dans l'annuaire
 */
@Override
public NumTel premierNumero(Personne p) throws PersonneAbsente
```

```java
/**
 * Renvoie la liste des numéros en fonction de la personne p
 * @param p personne
 * @return liste des numéros
 * @throws PersonneAbsente Si la personne n'existe pas dans l'annuaire
 */
@Override
public IListeNumTel numeros(Personne p) throws PersonneAbsente
```

```java
/**
 * Affiche le contenu de l'annuaire
 */
@Override
public void afficher()
```

```java
/**
 * Supprime une personne de l'annuaire en fonction de p
 * @param p personne
 * @throws PersonneAbsente si la personne n'existe pas dans l'annuaire
 */
@Override
public void supprimer(Personne p) throws PersonneAbsente
```

```java
/**
 * Supprime un numéro n en fonction de la personne p
 * @param p personne
 * @param n numéro à supprimer
 * @throws PersonneAbsente si la personne est absente de l'annuaire
 * @throws NumeroAbsent si le numéro n'existe pas dans la liste des numéros
 */
@Override
public void supprimer(Personne p, int n) throws PersonneAbsente, NumeroAbsent
```

```java
/**
 * Ensemble de toutes les personnes de l'annuaire dont le nom débute par une chaîne donnée
 * @param s chaîne donnée
 * @return ensemble de personnes
 */
@Override
public Set<Personne> personnesDeNomCommencantPar(String s)
```

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
* Le package **annuaire/** contenant la classe et l'interface de l'annuaire
* Le package **exception/** contenant **_les exceptions_** Java utilisées dans les classes
* Le package **numTel/** contenant la classe et l'interface de la liste des numéros
* Le package **personne/** contenant la classe **_Personne_**