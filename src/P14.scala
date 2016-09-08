

/**
 * @author kal
 * 
 * Duplicate the elements of a list.
 */

object P14 {
  
  def duplicateList[A](list: List[A]): List[A] = {
    list match {
      case el :: Nil => el :: el :: Nil
      case head :: tail =>  head :: head :: duplicateList(tail)
      case _ => Nil
    }
  }
  
  def duplicate[A](list: List[A]): List[A] = {
    list flatMap { t =>
      t :: t :: Nil
    }
  }
  
  def main(args: Array[String]) {
    val v = List(1, 2, 3, 40, 5, 6, 11, 9)
    println(duplicateList(v))
    println(duplicate(v))
  }

  
}