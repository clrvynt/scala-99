

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Find the number of elements of a list.
 * 
 */
object P04 {
  
  def length(list: List[_]) : Int  = {
    lengthCount(0, list)
  }
  
  private def lengthCount(len: Int, list: List[_]): Int = {
    list match {
      case _ :: Nil => len + 1
      case _ :: tail => lengthCount(len + 1, list.tail)
      case _ => throw new NoSuchElementException
    }
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(length(v))
  }
}