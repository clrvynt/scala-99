

/**
 * @author kal
 * 
 * Rotate a list N places to the left.
 */
object P19 {
  
  // Assume n < list.
  def rotate[A](n: Int, list: List[A]): List[A] = {
    
    def rotateR(n: Int, left: List[A], right: List[A]): (List[A], List[A]) = {
      (n, right) match {
        case (0, _) => (left, right)
        case (_ , Nil) => (left, Nil)
        case (_, head :: tail) => rotateR(n-1, head :: left, tail)
      }
    }
    val (l, r) = rotateR(n, Nil, list)
    r ::: l.reverse
  }
  
  def main(args: Array[String]) = {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(rotate(2, v))
  }
    
}