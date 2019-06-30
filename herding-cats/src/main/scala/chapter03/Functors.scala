package chapter03

import cats._
import cats.data._
import cats.implicits._

object Functors extends App {

  val numbers = List(1, 2, 3, 4, 5)

  // https://github.com/typelevel/cats/blob/master/core/src/main/scala/cats/Functor.scala#L12
  val lifted = Functor[List].lift {(_: Int) * 2}

  println(lifted(numbers)) // List[Int] => List[Int]
  println(numbers.void) // List[Int] => List[Unit]
  println(numbers.fproduct {(_: Int) * 2}) // List[Int] => List[(Int, Int)]
  println(numbers.as("x")) // List[Int] => List[String]
}
