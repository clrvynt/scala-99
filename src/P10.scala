

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Run-length encoding of a list.
 * Use the result of problem P09 to implement the so-called run-length encoding data compression method. 
 * Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
 * 
 */
object P10 {
  def encode[A](list: List[A]): List[(Int, A)] = {
    val v = pack(list)
    v.map { t =>
      (t.length, t.head)
    }
  }
  
  def pack[A](list: List[A]): List[List[A]] = {
    var mutList = scala.collection.mutable.MutableList[List[A]]()
    var prevElement: Option[A] = None
    var insideList = scala.collection.mutable.MutableList[A]()
    for ( i <- 0 to list.length - 1) {
      if ( Some(list(i)) != prevElement) {
        if ( insideList.length > 0) mutList += insideList.toList
        insideList = scala.collection.mutable.MutableList[A]()
        insideList += list(i)
      }
      else {
        insideList += list(i)
      }
      prevElement = Some(list(i))
    }
    if ( insideList.length > 0) mutList += insideList.toList
    mutList.toList
  }
  
  def main(args: Array[String]) {
    val v = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println(encode(v))
  }
}