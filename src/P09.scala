

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Pack consecutive duplicates of list elements into sublists.
 */
object P09 {
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
    println(pack(v))
  }
}