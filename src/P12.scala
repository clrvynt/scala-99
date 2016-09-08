

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Decode a run-length encoded list.
 * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
 * 
 */
object P12 {
  def decode[A](list: List[(Int, A)]): List[A] = {
    list.flatMap { t =>
      for ( i <- 0 to t._1 -1) yield(t._2)
    }
  }
  
  def main(args: Array[String]) {
    val v = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    println(decode(v))
  }
}