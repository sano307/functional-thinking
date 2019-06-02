package chapter01

import simulacrum._

@typeclass
trait Monoid2[A] {
  @op("|+|") def mappend(a1: A, a2: A): A
  def mzero: A
}

object Monoid2 {
  val syntax = ops
  implicit val IntMonoid: Monoid2[Int] = new Monoid2[Int] {
    def mappend(a1: Int, a2: Int): Int = a1 + a2
    def mzero: Int = 0
  }

  implicit val StringMonoid: Monoid2[String] = new Monoid2[String] {
    def mappend(a1: String, a2: String): String = a1 + a2
    def mzero: String = ""
  }
}

object EnrichMyLibrary extends App {
  import Monoid2.syntax._

  println(2 |+| 3)
  println("a" |+| "b")
}
