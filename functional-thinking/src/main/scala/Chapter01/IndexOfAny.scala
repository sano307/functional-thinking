package Chapter01

object IndexOfAny extends App {

  val input: String = "Hello World"

  val index: Option[Int] = firstIndexOfAny(input, Seq('H', 'W'))
  val indices: Seq[Int] = indexOfAny(input, Seq('H', 'W'))

  // Some(0)
  println(index)

  // Vector(0, 6)
  println(indices)

  def firstIndexOfAny(input: String, searchChars: Seq[Char]): Option[Int] = {
    def indexedInput = (0 until input.length).zip(input)

    val result = for (
      pair <- indexedInput;
      char <- searchChars
      if char == pair._2
    ) yield pair._1

    if (result.isEmpty) None
    else result.headOption
  }

  def indexOfAny(input: String, searchChars: Seq[Char]): Seq[Int] = {
    def indexedInput = (0 until input.length).zip(input)

    for (
      pair <- indexedInput;
      char <- searchChars
      if char == pair._2
    ) yield pair._1
  }
}
