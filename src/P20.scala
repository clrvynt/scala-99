

/**
 * @author kal
 * 
 * Remove the Kth element from a list.
 * 
 * Return the list and the removed element in a Tuple. Elements are numbered from 0.
 * 
 */
import scala.annotation.tailrec

object P20 {
  
  def removeAt[A](k: Int, list: List[A]): (List[A], A) = {
    @tailrec def removeR(k: Int, left: List[A], right: List[A]): (List[A], Option[A], List[A]) = {
      (k, right) match {
        case (0, head :: tail) => (left, Some(head), tail)
        case (_, head :: tail) => removeR(k-1, head :: left, tail)
        case (_, Nil) => (left, None, right)
      }
    }
    val (l, el, r) = removeR(k, Nil, list)
    (l.reverse ::: r , el.get)
  }
    
  def main(args: Array[String]) = {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(removeAt(2, v))
    println(removeAt(1, List('a, 'b, 'c, 'd)))
  }
  
}