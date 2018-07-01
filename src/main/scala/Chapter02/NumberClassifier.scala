package Chapter02

object NumberClassifier extends App {

  val number1: Int = 6
  val number2: Int = 18

  println(isPerfect(number1))  // true
  println(isPerfect(number2))  // false

  def factorsOf(number: Int): Seq[Int] =
    Seq.range(1, number + 1)
      .filter(potential => number % potential == 0)

  def sumFactors(number: Int): Int =
    factorsOf(number).reduce(_ + _)

  def aliquotSum(number: Int): Int =
    //factorsOf(number).sum - number
    sumFactors(number) - number

  def isPerfect(number: Int): Boolean =
    aliquotSum(number) == number

  def isAbundant(number: Int): Boolean =
    aliquotSum(number) > number

  def isDeficient(number: Int): Boolean =
    aliquotSum(number) < number
}
