package chapter02

import cats._
import cats.data._
import cats.implicits._

object Order extends App {

  // Scala standard
  // https://github.com/scala/scala/blob/2.12.x/src/library/scala/math/Ordering.scala#L132
  println(1 > 2.0)
  
  // Cats standard
  // https://github.com/typelevel/cats/blob/master/kernel/src/main/scala/cats/kernel/Order.scala#L22
  //println(1 compare 2.0) // Compilation failed.
  println(1.0 compare 2.0)
  println(1.0 max 2.0)
}
