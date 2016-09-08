

/**
 * @author kal
 * 
 * Duplicate the elements of a list a given number of times.
 * 
 */
import scala.annotation.tailrec

object P15 {
  
  def duplicateN[A](n: Int, list: List[A]) : List[A] = {
    
    @tailrec def repeat(m: Int, el: A, l: List[A]): List[A] = {
      m match {
        case 0 => l
        case _ =>
          repeat(m-1, el, el :: l)
      }
    }
    
    list match {
      case el :: Nil => repeat(n, el, Nil) 
      case head :: tail =>  repeat(n, head, Nil) ++ duplicateN(n, tail)
      case _ => Nil
    }
  }
  
  def duplicateNEasy[A](n: Int, list: List[A]) : List[A] = {
    
    list match {
      case el :: Nil => List.fill(n)(el)
      case head :: tail =>  List.fill(n)(head) ++ duplicateN(n, tail)
      case _ => Nil
    }
  }

  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(duplicateN(3, v))
    println(duplicateNEasy(2, v))
    val v1 = List(2)
    println(duplicateN(3, v1))
    println(duplicateNEasy(3, v1))
  }

}