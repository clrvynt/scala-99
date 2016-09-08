

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Find the last element of a list.
 */
object P01 {
  @tailrec private def last[A](list: List[A]): Option[A] = {
    if (list.length == 1)
      list.headOption
    else
      last(list.tail)
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 4)
    println(last(v))
  }
}