

import scala.annotation.tailrec
/*
 * @author kal
 * 
 * Find out whether a list is a palindrome
 * 
 */
object P06 {
  
  def reverse[A](list: List[A]) : List[A]  = {
    list match {
      case _ :: Nil => list
      case head :: tail => reverse(tail) :+ head
      case _ => throw new NoSuchElementException
    }
  }
  
  def isPalindrome[A](list: List[A]): Boolean = {
    list == reverse(list)
  }
  
  /*
   * A slightly more efficient way to only check until half of the list .. 
   * 
   */
  def isPalindromeEfficient[A](list: List[A]) : Boolean = {
    def isP(in: Boolean, list: List[A]) : Boolean = {
      if (in) {
        list match {
          case _ :: Nil => true
          case head :: tail => isP((head == tail.last), tail.init)
          case _ => true
        }
      }
      else 
        false
    }
    isP(true, list)
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(isPalindrome(v))
    val v1 = List(10, 11, 10, 10, 11, 10)
    println(isPalindromeEfficient(v1))
  }
}