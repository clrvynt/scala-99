

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Eliminate consecutive duplicates of list elements.
 */
object P08 {
  def compress[A](list: List[A]): List[A] = {
    val mutList = scala.collection.mutable.MutableList[A]()
    var prevElement: Option[A] = None
    for ( i <- 0 to list.length - 1) {
      if ( Some(list(i)) != prevElement) {
        mutList += list(i)
      }
      prevElement = Some(list(i))
    }
    mutList.toList
  }
  
  def main(args: Array[String]) {
    val v = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println(compress(v))
  }
}