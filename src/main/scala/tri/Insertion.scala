package tri

import common._

object Insertion {

  /**
   * Les listes:
   *
   * Une liste est une structure de donnees fondamentale en programmation : elle permet de representer une suite d'elements, et
   * de les manipuler tres naturellement. Cette structure est tres adaptee a certains algorithmes de tri, entre autres le tri par
   * insertion.Cependant, elle n'est pas immediate d'acces en C (il faut implementer une liste chainee soi-meme )
   * En scala ce type de donnees est accessible directement, on peut en profiter.
   * La liste est un type de donnees tres interessant, car il est recursif par nature. En effet, on definit
   *  formellement une liste de la maniere suivante :
   *  une liste est :
   *                  soit une liste vide (notee Nil) ;
   *                  soit un element suivi d'une liste : on note a::b, a etant l'element et b la liste
   *                  on appellera l'element a la "tete", et la liste qui le suit (b) la "queue" de la liste.
   *
   * Cette definition, tres elegante (on n'a pas parle de pointeurs), appelle directement a utiliser la liste
   * avec des algorithmes recursifs.
   */

  /**
   * L'algorithme du tri par insertion est decoupe  en deux fonctions.
   *
   * La fonction "inserer" qui insere un element a la bonne position dans la liste
   *
   * Et la fonction "tri_insertion", qui reutilise la fonction inserer pour trier le tableau, en inserant
   * chaque element successivement a la bonne place.
   */

  /**
   *  Insere un element dans une liste triee en ordre croissant, de maniere a renvoyer une liste
   *  toujours triee
   */
  def insert(elem: Int, myList: List[Int]): List[Int] = ???

  /**
   * Maintenant on tri
   * si la liste est vide, on la renvoie
   * si la liste est une tete suivie d'une queue, on trie la queue, et on y insere la tete.
   */
  def triIns(myList: List[Int]): List[Int] = ???

  /**
   * Notre fonction trie une liste en ordre croissant. Tres bien.
   * Mais si on voulait trier en ordre decroissant, il faudrait la recoder ?
   */
  def insert(elem: Int, myList: List[Int], fonctionOrdre: (Int, Int) => Boolean): List[Int] = ???

  /**
   * tri croissant avec la nouvelle fonction insere
   */
  def triDecroissant(myList: List[Int]): List[Int] = ???

  /**
   * tri Decroissant avec la nouvelle fonction insere
   */
  def triCroissant(myList: List[Int]): List[Int] = ???

  /* Le Polymorphisme est atteint en precisant les variables de type. 
 
	scala> def drop1 [A] (l: List[A]) = l.tail 
	drop1: [A] (l: List[A]) List[A] 

	scala> drop1 (Liste (1,2,3)) 
	res1: Liste [Int] = List (2, 3)
	
	On voi ici que l'on peut utilise drop1 avec une liste de plusieur type*/

  /**
   *  Reecrivez les fonctions precedents avec des type generique
   */
  def inserePoly[A](elem: A, myList: List[A], fonctionOrdre: (A, A) => Boolean): List[A] = ???

  def trifunPoly[A](myList: List[A], fonctionOrdre: (A, A) => Boolean): List[A] = ???

  /**
   * Tri d'une liste de carateres
   */
  def triCroissantChar(myList: List[Char]): List[Char] = ???
}
