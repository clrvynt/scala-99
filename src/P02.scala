

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Find the last but one element of a list.
 * 
 */
object P02 {
  @tailrec private def lastButOne[A](list: List[A]): Option[A] = {
    list.length match {
      case 2 => list.headOption
      case n if n > 2 => lastButOne(list.tail)
      case _ => throw new NoSuchElementException
    }
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 4)
    println(lastButOne(v))
  }
}