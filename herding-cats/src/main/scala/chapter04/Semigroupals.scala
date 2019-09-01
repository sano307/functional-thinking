package chapter04

import cats._
import cats.data._
import cats.implicits._

// https://github.com/typelevel/cats/blob/master/core/src/main/scala/cats/Semigroupal.scala
object Semigroupals extends App {

  val noneInt: Option[Int] = None
  val noneString: Option[String] = None

  Semigroupal[Option].product(1.some, "1".some) // Some((1,"1"))
  Semigroupal[Option].product(1.some, noneString) // None
  Semigroupal[Option].product(noneInt, "1".some) // None
  Semigroupal[Option].product(noneInt, noneString) // None
}
