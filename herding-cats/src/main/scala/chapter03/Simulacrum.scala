package chapter03

import simulacrum._

@typeclass trait CanTruthy[A] { self =>
  def truthy(a: A): Boolean
}

object CanTruthy {
  implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.fromTruthy({
    case 0 => false
    case _ => true
  })

  def fromTruthy[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
    def truthy(a: A): Boolean = f(a)
  }
}

@typeclass trait CanAppend[A] {
  @op("|+|") def append(a1: A, a2: A): A
}

object CanAppend {
  implicit val intCanAppend: CanAppend[Int] = new CanAppend[Int] {
    def append(a1: Int, a2: Int): Int = a1 + a2
  }
}

object Simulacrum extends App {
  
  import CanTruthy.ops._
  import CanAppend.ops._

  println(10.truthy)
  println(0.truthy)

  println(1 |+| 2)
  println(1 |+| 2 |+| 3)
}
