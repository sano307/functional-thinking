package chapter04

trait Appender {
  type T
  def transform(x: T): T
}

class NumberAppender extends Appender {
  type T = Int
  def transform(x: Int): Int = x + x
}

class StringAppender extends Appender {
  type T = String
  def transform(x: String): String = x.toUpperCase()
}

object Type extends App {

  println(new NumberAppender().transform(2)) // 4
  println(new StringAppender().transform("hello world")) // HELLO WORLD
}
