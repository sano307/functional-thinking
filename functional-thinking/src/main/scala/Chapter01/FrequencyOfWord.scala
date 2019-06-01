package Chapter01

object FrequencyOfWord extends App {

  final val NON_WORDS: Seq[String] = Seq(
    "the", "and", "of", "to", "a",
    "i", "it", "in", "or", "is",
    "d", "s", "as", "so", "but",
    "be"
  )

  val words: String = "amoad amoad inseo cyberagent afio afio afio afio the a is that something new"

  wordFreq(words).toSeq.sortWith(_._2 > _._2).foreach(m => println(m._1 + " / " + m._2))

  def regexToList(words: String, regex: String): List[String] = {
    regex.r.findAllIn(words).map(_.toString).toList
  }

  def wordFreq(words: String): Map[String, Int] =
    regexToList(words, "\\w+")
      .map(_.toLowerCase)
      .filter(!NON_WORDS.contains(_))
      .zipWithIndex
      .groupBy(_._1)
      .mapValues(_.size)

}
