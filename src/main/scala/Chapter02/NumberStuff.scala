package Chapter02

object NumberStuff extends App {

  val numbers: List[Int] = List.range(1, 10)

  println(addOnlyOddNumbersIn(numbers))  // 25

  def addOnlyOddNumbersIn(numbers: List[Int]) =
    numbers.foldLeft(0) { (acc, number) =>
      if (number % 2 != 0) acc + number
      else acc
    }
}
