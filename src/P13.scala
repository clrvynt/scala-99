

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Run-length encoding of a list (direct solution).
 * Implement the so-called run-length encoding data compression method directly. 
 * I.e. don't use other methods you've written (like P09's pack); do all the work directly.
 */
object P13 {
  
  def encode[A](list: List[A]): List[(Int, A)] = {
    val mutList = scala.collection.mutable.MutableList[(Int, A)]()
    var prevElement: Option[A] = None
    var sum = 0
    for ( i <- 0 to list.length - 1) {
      if ( Some(list(i)) != prevElement) {
        if ( sum > 0) mutList += Tuple2(sum, prevElement.get)
        sum = 0
        sum += 1
      }
      else {
        sum += 1
      }
      prevElement = Some(list(i))
    }
    if ( sum > 0) mutList += Tuple2(sum, prevElement.get)
    mutList.toList
  }
  
  def main(args: Array[String]) {
    val v = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println(encode(v))
  }
}