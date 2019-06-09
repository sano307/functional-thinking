package chapter02

import cats.{Show => CatsShow}
import cats.data._
import cats.implicits._

case class A(name: String)
case class B(name: String)

object Show extends App {

  // Scala standard
  // https://github.com/scala/scala/blob/2.12.x/src/library-aux/scala/Any.scala#L78
  println(3.toString)
  println("hello".toString)
  
  // Cats standard
  // https://github.com/typelevel/cats/blob/master/core/src/main/scala/cats/Show.scala#L15
  println(3.show)
  println("hello".show)

  implicit val aShow = CatsShow.show[A](_.name)
  implicit val bShow = CatsShow.fromToString[B]

  println(A("a").show)
  println(B("b"))
}
