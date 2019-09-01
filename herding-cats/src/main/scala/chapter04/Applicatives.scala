package chapter04

import cats._
import cats.data._
import cats.implicits._

// https://github.com/typelevel/cats/blob/master/core/src/main/scala/cats/Applicative.scala
object Applicatives extends App {

  val F = Applicative[Option]
  val noneInt: Option[Int] = None

  Applicative[List].pure(1) // List(1)
  Applicative[Option].pure(1) // Some(1)

  F.ap({ F.pure((_: Int) + 1) })(F.pure(2)) // Some(3)

  sequenceA(List(1.some, 2.some)) // Some(list(1,2))
  sequenceA(List(1.some, 2.some, noneInt)) // None
  sequenceA(List(List(1,2), List(3,4))) // List(List(1,3), List(1,4), List(2,3), List(2,4))

  def sequenceA[F[_]: Applicative, A](list: List[F[A]]): F[List[A]] = list match {
    case Nil     => Applicative[F].pure(Nil: List[A])
    case x :: xs => (x, sequenceA(xs)).mapN(_ :: _)
  }
}
