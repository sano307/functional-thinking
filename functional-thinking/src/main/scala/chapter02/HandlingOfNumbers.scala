package chapter02

object HandlingOfNumbers extends App {

  val numbers: List[Int] = List(
    1, 2, 3, 4, 5,
    6, 7, 8, 9, 10
  )

  // List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
  numbers.map(_ + 1)

  // List(2, 4, 6, 8, 10)
  numbers.map(_ % 2 == 0)

  // List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  List(numbers, numbers).flatMap(_.toList)
}
