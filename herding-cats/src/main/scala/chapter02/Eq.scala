package chapter02

import cats._
import cats.data._
import cats.implicits._

object Eq extends App {

  // Scala standard
  // https://github.com/scala/scala/blob/2.12.x/src/library-aux/scala/Any.scala#L92
  println(1 == 1)
  println(1 != "foo") // Compilation warning.

  // Cats standard
  // https://github.com/typelevel/cats/blob/master/kernel/src/main/scala/cats/kernel/Eq.scala#L12
  println(1 === 1)
  //println(1 === "foo") // Compilation failed.
}
