# LISTES ET FILES

--------------------------------------------------

## DESCRIPTION

Création d'un programme en Java permettant de représenter le système de **File** et de **Liste**.

Une **Liste est une est une structure de donnée permettant, comme les tableaux, de stocker plusieurs valeurs de même type, mais qui soit de taille variable, contrairement aux tableaux**. On peut donc, au cours du programme, ajouter autant d'éléments que l'on souhaite, sans avoir une erreur de taille comme pour les tableaux.

Une **File est une liste, mais permet de réaliser une FIFO (First In First Out), ce qui veut dire que les premiers éléments ajoutés à la file seront aussi les premiers à être récupérés**. Il existe deux types de files :

1. Les files **standard** (FIFO)
2. Les files **de priorité** --> Système permettant d'attribuer, pour chaque élément ajoutés à la file, d'attribuer une valeur qui correspondra à la priorité de l'élément. En fonction de la priorité de chaque éléments, certains seront donc prioritaire sur d'autres.

* Le package **_Exo3/_** concerne les Files
* Le package **_Exo4/_** concerne les Listes

--------------------------------------------------

## OPÉRATIONS POSSIBLES

### Pour les files

1. Classe **File.java** qui représente une file normale :
	* `void ajoute(E e)` qui ajoute un élément **e** à la file
	* `E enleve()` qui enleve et renvoie l'élément le plus anciennement ajouté à la file
	* `E prioritaire()` qui renvoie l'élément le plus anciennement ajouté à la file
	* `int taille()` qui renvoie la taille de la file
	* `String toString()` qui redéfinit `Object.toString()` et affiche le contenu de la file
	* `melange(File<E> f)`  qui crée une nouvelle file en prenant alternativement un élément de la file et un élément de la file en paramètre **f**

2. Classe **FileSansDoublons.java** qui reprend les opérations élémentaires d'une file standard, mais dont l'ajout de deux éléments identiques est impossible.
3. Classe **FileAvecPriorite.java** qui reprend les opérations élémentaires d'une file standard, mais rajoute un système de priorité en prenant comme exemple les files d’attente de Personne (création d'une classe **Personne.java** basique pour créer une personne) telles que les éléments qui sortent les premiers de la file sont les plus grands selon leur ordre naturel.

### Pour les listes

1. Classe **Listes.java** permettant la manipulation sur des listes :
	* `LinkedList<Double> deuxFois(List<? extends Evaluable> listeTemp)` qui multiplie par deux les valeurs de liste **listeTemp**
	* `List<E> fusionne(List<E> liste1, List<E> liste2)` qui mélange la liste **liste1** et la liste **liste2**, et renvoie une nouvelle liste
	* `List<E> inverse(List<E> listeTemp)` qui prend une liste en paramètre et renvoie une nouvelle liste avec les éléments dans l'ordre inverse de la liste **listeTemp** passée en paramètre

--------------------------------------------------

## NOTIONS UTILISÉES

1. **Classe**
2. **Objet**
3. **Attribut**
4. **Méthode**
5. **Constructeur**
6. **Interface List, Comparator, Comparable, Iterable, Queue et Deque**
7. **Héritage**
8. **Polymorphisme**
9. **JUnit Test Case**