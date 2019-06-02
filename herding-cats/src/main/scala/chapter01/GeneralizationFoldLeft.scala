package chapter01

// higher-kinded type should be enabled.
trait FoldLeft[F[_]] {
  def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
}

object FoldLeft {
  implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
    def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B): B = xs.foldLeft(b)(f)
  }
}

object GeneralizationFoldLeft extends App {

  val primeNumbers: List[Int] = List(2, 3, 5, 7, 11)
  val alphabets: List[String] = List("a", "b", "c", "d", "e")
  
  println(sum(primeNumbers))
  println(sum(alphabets))

  // higher-kinded type should be enabled.
  def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
    val m = implicitly[Monoid[A]]
    val fl = implicitly[FoldLeft[M]]
    fl.foldLeft(xs, m.mzero, m.mappend)
  }
}
