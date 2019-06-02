package chapter01

case class Company(name: String)

trait Car {
  def getName: String
}

case class Benz() extends Car {
  override def getName: String = "benz"
}

case class Audi() extends Car {
  override def getName: String = "audi"
}

trait Appendable[A] {
  def append(a1: A, a2: A): A
}

class AppendableInt extends Appendable[Int] {
  override def append(a1: Int, a2: Int) = a1 + a2
}

class AppendableString extends Appendable[String] {
  override def append(a1: String, a2: String) = a1.concat(a2)
}

object AppendableImplicits {
  implicit def toAppendableInt = new AppendableInt()
  implicit def toAppendableString = new AppendableString()
}

object Polymorphism extends App {

  // Parametic Polymorphism
  var primeNumbers: List[Int] = List(2, 3, 5, 7, 11)
  var business: List[String] = List("advertise", "game", "media")
  var gafa: List[Company] = List(Company("google"), Company("Apple"), Company("Facebook"), Company("Amazone"))

  println(head(primeNumbers))
  println(head(business))
  println(head(gafa))

  def head[A](xs: List[A]): A = xs(0)

  // Subtype Polymorphism
  var cars: List[Car] = List(Benz(), Audi())
  println(cars.map(_.getName))

  // Ad hoc Polymorphism
  import scala.language.implicitConversions._
  import AppendableImplicits._

  println(appendItems(1, 2))
  println(appendItems("a", "b"))

  def appendItems[A: Appendable](a1: A, a2: A): A = implicitly[Appendable[A]].append(a1, a2)
}
