

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Find the Kth element of a list. ( without using built-in functions)
 * 
 */
object P03 {
  private def kth[A](k: Int, list: List[A]): Option[A] = {
    k match {
      case 1 => list.headOption
      case n if n > 1 => kth(k-1, list.tail)
      case _ => throw new NoSuchElementException
    }
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6)
    println(kth(4, v))
  }
}