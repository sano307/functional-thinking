package chapter03

import cats._
import cats.data._
import cats.implicits._

sealed trait COption[+A]
case class CSome[A](counter: Int, a: A) extends COption[A]
case object CNone extends COption[Nothing]

object COption {
  implicit val coptionFunctor = new Functor[COption] {
    def map[A, B](fa: COption[A])(f: A => B): COption[B] =
      fa match {
        case CNone => CNone
        case CSome(c, a) => CSome(c + 1, f(a))
      }
  }
}

object Discipline extends App {

  val hits: COption[String] = CSome(0, "inseo")

  println(hits.map(identity(_)))
}
