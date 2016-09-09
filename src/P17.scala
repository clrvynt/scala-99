

/**
 * @author kal
 * 
 * Split a list into two parts.
 * 
 * The length of the first part is given. Use a Tuple for your result.
 * 
 */
import scala.annotation.tailrec

object P17 {
  
  def split[A](n: Int, list: List[A]): (List[A], List[A]) = {
    @tailrec def splitR(n: Int, left: List[A], right: List[A]): (List[A], List[A]) = {
      (n, right) match {
        case (0, _) => (left, right)
        case (_, head :: tail) => splitR(n-1, head :: left, tail)  
        case (_, Nil) => (left, Nil)
      }
    }
    val (l, r) = splitR(n, Nil, list)
    (l.reverse, r)
  }
  
  def main(args: Array[String]) = {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(split(3, v))
  }
  
}