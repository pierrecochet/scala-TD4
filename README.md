# [**correction TD3**](https://github.com/poussard/scala-TD3/blob/master/correction.md)
# Programmation fonctionnelle -TD4

Le but de ce TD est d'implémenter la méthode de tri par insertion

## Installation
* Télécharger le [**ZIP**](https://github.com/poussard/scala-TD4/archive/master.zip)  git clone https://github.com/poussard/scala-TD4.git
* Décompresser le
* Importer le comme 'Existing Projects into Workspace'

## Liste des fichiers

    src
    |- main
    |  |- scala
    |  |  |- common
    |  |  |  |- package.scala
    |  |  |- tri
    |  |  |  |- Insertion.scala     // Méthodes a implémenter
    |- test
    |  |- scala
    |  |  |- tri
    |  |  |  |- TriSuite.scala      // Tests

## Tri par insertion
Le tri par insertion est un algorithme de tri classique, que la plupart des personnes utilisent naturellement pour trier des cartes. Prendre les cartes mélangées une à une sur la table, et former une main en insérant chaque carte à sa place. En général, le tri par insertion est beaucoup plus lent que d'autres algorithmes comme le tri rapide et le tri fusion pour traiter de grandes séquences, car sa complexité asymptotique est quadratique.

Il est cependant considéré comme le tri le plus efficace sur des entrées de petite taille. Il est aussi très rapide lorsque les données sont déjà presque triées. Pour ces raisons, il est utilisé en pratique en combinaison avec d'autres méthodes comme le tri

## Les listes
Une liste est une structure de données fondamentale en programmation : elle permet de représenter une suite d'éléments, et de les manipuler très naturellement. Cette structure est très adaptée à certains algorithmes de tri, entre autres le tri par insertion. Cependant, elle n'est pas immédiate d'accès en C (il faut implémenter une liste chaînée soi-même ) En scala ce type de données est accessible directement, on peut en profiter. La liste est un type de données très intéressant, car il est récursif par nature. En effet, on définit formellement une liste de la manière suivante : 
* soit une liste vide (notée Nil) ;
* soit un élément suivi d'une liste : on note a::b, a étant l'élément et b la liste. On appellera l'élément a la "tête", et la liste qui le suit (b) la "queue" de la liste.

Cette définition, très élégante (on n'a pas parlé de pointeurs), appelle directement à utiliser la liste avec des algorithmes récursifs.

## Polymorphisme
Il est possibe de définir une fonction générique, en précisant les paramètres de type entre crochets.
Exemples
```scala
scala> def id[A](x: A) = x
id: [A](x: A)A
```
On peut instancier cette fonction sans préciser son type, qui est determiné automatiquement à partir du type des arguments, par exemple :
```scala
scala> val c = id('A')
c: Char = A
scala> val i = id(3)
i: Int = 3
```
## Exercice: Tri par insertion    
L'algorithme du tri par insertion est découpé  en deux fonctions.
* La fonction "insert" qui insère un élément à la bonne position dans la liste
* la fonction "triIns", qui réutilise la fonction insérer pour trier le tableau, en insérant chaque élément successivement à la bonne place

 Leur signatures sont les suivantes:
```scala
def insert(elem :Int, list: List[Int]):  List[Int]

def triIns(list: List[Int]): List[Int] 
```
