package Chapter03

import scala.annotation.tailrec

object RecursionTest extends App {

  def numbers: List[Int] = List(
    6, 28, 4, 9, 12,
    4, 8, 8, 11, 45,
    99, 2
  )

  def iterateList(list: List[Int]): Unit =
    list.foreach { element =>
      println(element)
    }

  iterateList(numbers)

  // Think about it which combination of the first element and the rest.
  @tailrec
  def recurseList(list: List[Int]): Unit =
    if (list.isEmpty) {
      None
    } else {
      println(list.head)
      recurseList(list.tail)
    }

  recurseList(numbers)

  // A predicate is a function that returns a Boolean.
  def predicateFilter(list: List[Int]) = list.filter(modBy2)

  def modBy2(num: Int) = num % 2 == 0

  val l = predicateFilter(numbers)
  println(l)
}
