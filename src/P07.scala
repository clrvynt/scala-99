

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Flatten a nested list structure.
 */
object P07 {
  def flatten[A](listOfLists : List[List[A]]): List[A] = {
    for (list <- listOfLists; el <- list) yield (el)
  }
  
  def main(args: Array[String]) {
    val v = List(List(1, 2, 3, 4), List(6, 2, 10), List(11, 1))
    println(flatten(v))
  }
}