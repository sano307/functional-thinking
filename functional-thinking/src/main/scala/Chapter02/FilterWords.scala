package Chapter02

object FilterWords extends App {

  val words = List(
    "the", "quick", "brown", "fox", "jumped",
    "over", "the", "lazy", "dog"
  )

  // List(the, fox, the, dog)
  words.filter(_.length == 3)

  // (List(the, fox, the, dog),List(quick, brown, jumped, over, lazy))
  words.partition(_.length == 3)

  // Some(the)
  words.find(_.length == 3)

  // None
  words.find(_.length > 10)

  // List(the)
  words.takeWhile(_.length == 3)

  // List(quick, brown, fox, jumped, over, the, lazy, dog)
  words.dropWhile(_.startsWith("t"))
}
