

/**
 * @author kal
 * 
 * Drop every Nth element from a list.
 * 
 */
object P16 {
  
  def drop[A](n: Int, list: List[A]) : List[A] = {
    val mutList = scala.collection.mutable.MutableList[A]()
    for (i <- 1 to list.length) {
      if (i % n != 0) 
        mutList += list(i-1)
    }
    mutList.toList
  }
  
  def dropRecursive[A](n: Int, list: List[A]): List[A] = {
    def dropSub(i: Int, l: List[A]): List[A] = (i, l) match {
      case (_, Nil) => Nil
      case (1, _ :: tail) => dropSub(n, tail)
      case (_, head :: tail) => head :: dropSub(i-1, tail)
    }
    dropSub(n, list)
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(drop(3, v))
    println(dropRecursive(3, v))
  }
  
  
}