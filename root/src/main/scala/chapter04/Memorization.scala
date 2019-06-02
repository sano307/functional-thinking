package chapter04

import scala.collection.mutable.{Map => MutableMap}

object Memorization extends App {

  def memorize[A, B](f: A => B) = new (A => B) {
    val cache: MutableMap[A, B] = MutableMap[A, B]()

    def apply(x: A): B = cache.getOrElseUpdate(x, f(x))
  }

  val students: MutableMap[Int, String] = MutableMap(
    1 -> "inseo",
    2 -> "taku",
    3 -> "nomura"
  )

  def nameHash: Int => String = memorize(students)

  for(cnt <- 1 to students.size) {
    println(nameHash(cnt))
  }
}
