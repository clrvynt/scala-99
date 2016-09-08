

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Reverse a list.
 * 
 */
object P05 {
  
  def reverse[A](list: List[A]) : List[A]  = {
    list match {
      case _ :: Nil => list
      case head :: tail => reverse(tail) :+ head
      case _ => throw new NoSuchElementException
    }
  }
  
  def reverseTailRec[A](list: List[A]): List[A] = {
    @tailrec def rev(result: List[A], list:List[A]): List[A] = {
      list match {
        case Nil => result
        case head :: tail => rev(head :: result, tail)
      }
    }
    rev(List.empty, list)
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(reverse(v))
    val v1 = List(10, 11)
    println(reverseTailRec(v1))
  }
}