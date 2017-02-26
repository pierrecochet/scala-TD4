# TD4 Correction

## La fonction "insérer"  
```scala
def insert(elem: Int, myList: List[Int]): List[Int] =
    {
      myList match {
        case Nil => elem :: Nil
        case tete :: queue if (elem < tete) => elem :: myList
        case _ => myList.head :: (insert(elem, myList.tail))
      }
    }
  ```
  Example : 
  ```
  iteration 0   insert(4, (2, 3, 5))
  iteration 1   2 :: insert(4, (3, 5))
  iteration 2   2 :: 3 :: insert(4, (5))
  iteration 3   2 :: 3 :: 4 :: (5)
  iteration 4   (2, 3, 4, 5)
  ```
  
## La fonction tri
 ```scala
     def triIns(myList: List[Int]): List[Int] =
    {
      myList match {
        case Nil => Nil
        case tete :: queue => insert(tete, triIns(queue))
      }
    }
```
      Example : 
  ```
  iteration 0   triIns(4, 2, 5, 1))
  iteration 1   insert(4, triIns(2, 5, 1))
  iteration 2   insert(4, insert(2, triIns(5, 1))
  iteration 3   insert(4, insert(2, insert(5, triIns(1))
  iteration 4   insert(4, insert(2, insert(5, insert(1, triIns())
  iteration 5   insert(4, insert(2, insert(5, insert(1, List())
  iteration 6   insert(4, insert(2, insert(5, (1))
  iteration 7   insert(4, insert(2, (1, 5)
  iteration 8   insert(4, (1, 2, 5)
  iteration 9   (1, 2, 4, 5)
  ```
  
## La fonction "insérer" avec une fonction "ordre" en parametre
```scala
   def insert(elem: Int, myList: List[Int], fonctionOrdre: (Int, Int) => Boolean): List[Int] =
    {
      myList match {
        case Nil => elem :: Nil
        case tete :: queue  if (fonctionOrdre(elem, tete)) => elem :: myList else
        case tete :: queue  => tete :: (insert(elem, queue, fonctionOrdre))
      }
    }
 ```
    
## La tri "tri" avec une fonction "ordre" en parametre
 ```scala
    def triIns(myList: List[Int], fonctionOrdre: (Int, Int) => Boolean): List[Int] =
    {
      myList match {
        case Nil => Nil
        case tete :: queue => insert(tete, triIns(queue, fonctionOrdre), fonctionOrdre) //!!!!!!! Attention ici insert a 3 parametres et triIns 2
      }
    }
 ```
    
## Tri croissant avec la nouvelle fonction insere
 ```scala
    def triDecroissant(myList: List[Int]): List[Int] =
    {
     triIns(myList,(x,y)=>x>y)) //!!!!!!! Appelle de triIns avec une fonction croissante
    } 
 ```
     
## Tri Decroissant avec la nouvelle fonction insere
 ```scala
    def triCroissant(myList: List[Int]): List[Int] = 
    {
     triIns(myList,(x,y)=>x<y)) //!!!!!!! Appelle de triIns avec une fonction decroissante
    } 
 ```
 
## Tri Polymorphisme   
 ```scala
  def inserePoly[A](elem: A, myList: List[A], fonctionOrdre: (A, A) => Boolean): List[A] =
    {
      myList match {
        case Nil => elem :: Nil
        case tete :: queue => if (fonctionOrdre(elem, tete)) elem :: myList else tete :: (inserePoly(elem, queue, fonctionOrdre))
      }
    }

  def trifunPoly[A](myList: List[A], fonctionOrdre: (A, A) => Boolean): List[A] =
    {
      myList match {
        case Nil => Nil
        case tete :: queue => inserePoly(tete, trifunPoly(queue, fonctionOrdre), fonctionOrdre)
      }
    }

 ```
      
 ```scala  
  def triCroissantChar(myList: List[Char]): List[Char] =
    {
      trifunPoly(myList, (x: Char, y: Char) => x < y)
    }
 ```
