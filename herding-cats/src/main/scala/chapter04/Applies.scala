package chapter04

import cats._
import cats.data._
import cats.implicits._

// https://github.com/typelevel/cats/blob/master/core/src/main/scala/cats/Apply.scala
object Applies extends App {

  val noneInt: Option[Int] = None
  val noneString: Option[String] = None

  (1.some, 2.some).mapN(_ - _) // Some(-1)
  (noneInt, 2.some).mapN(_ - _) // None
  (1.some, noneInt).mapN(_ - _) // None

  ({(_: Int) + 1}.some).ap(2.some) // Some(3)
  ({(_: String) + "hello"}.some).ap(noneString) // None

  (1.some, List(2).some).mapN(_ :: _) // Some(List(1,2))
  Apply[Option].map2(1.some, List(2).some)(_ :: _) // Some(List(1,2))

  Apply[Option].tuple2(1.some, 2.some) // Some((1,2))
  Apply[Option].tuple2(1.some, noneInt) // None
}
