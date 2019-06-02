package chapter01

trait Monoid[A] {
  def mappend(a1: A, a2: A): A
  def mzero: A
}

object Monoid {
  implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
    def mappend(a1: Int, a2: Int): Int = a1 + a2
    def mzero: Int = 0
  }

  implicit val StringMonoid: Monoid[String] = new Monoid[String] {
    def mappend(a1: String, a2: String): String = a1 + a2
    def mzero: String = ""
  }
}

object SumFunction extends App {

  val primeNumbers: List[Int] = List(2, 3, 5, 7, 11)
  val alphabets: List[String] = List("a", "b", "c", "d", "e")

  println(sum(primeNumbers))
  println(sum(alphabets))
  
  // def sum(xs: List[Int]): Int = xs.foldLeft(0) {_ + _}
  // def sum(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)
  // def sum(xs: List[Int], m: Monoid[Int]): Int = xs.foldLeft(m.mzero)(m.mappend)
  // def sum[A](xs: List[A], m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)
  // def sum[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)

  // Apply context bound
  def sum[A: Monoid](xs: List[A]): A = {
    val m = implicitly[Monoid[A]]
    xs.foldLeft(m.mzero)(m.mappend)
  }
}
