package chapter02

import cats._
import cats.data._
import cats.implicits._

object PartialOrder extends App {

  // Cats standard
  // https://github.com/typelevel/cats/blob/master/kernel/src/main/scala/cats/kernel/PartialOrder.scala#L25
  println(1 tryCompare 2)
  println(1.0 tryCompare Double.NaN)

  //println(lt[Int](1, 2.0)) // Compilation failed.
  println(lt[Double](1.0, 2.0))

  def lt[A: PartialOrder](a1: A, a2: A): Boolean = a1 <= a2
}
