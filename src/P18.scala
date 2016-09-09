

/**
 * @author kal
 * 
 * Extract a slice from a list.
 *  Given two indices, I and K, the slice is the list containing the elements from 
 *  and including the Ith element up to but not including the Kth element of the 
 *  original list. Start counting the elements with 0.
 * 
 */
object P18 {
  
  def slice[A](i: Int, k: Int, list: List[A]): List[A] = {
    (i, k, list) match {
      case (0, 1, _) => Nil
      case (0, _, head :: tail) => head :: slice(0, k-1, tail)
      case (_, _, head :: tail) => slice(i-1, k, tail)
      case (_, _ , Nil) => Nil
    }
  }
  
  def main(args: Array[String]) = {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(slice(1, 4, v))
  }
}