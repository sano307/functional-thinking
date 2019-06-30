package chapter03

import cats._ // Show[A], Functor[F[_]], Eq[A], Id[A], Traverse[F[_]], Monad[F[_]]
import cats.data._ // Validated[+E, +A], Reader[A, B]
import cats.implicits._ // https://github.com/typelevel/cats/blob/master/core/src/main/scala/cats/implicits.scalaim

object Import extends App {
  
  println("An import feature guide.")
}
