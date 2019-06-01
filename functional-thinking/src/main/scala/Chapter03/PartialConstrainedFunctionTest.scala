package Chapter03

object PartialConstrainedFunctionTest extends App {

  // Using case without match
  val cities = Map(
    "New Jersey" -> "NY",
    "Florida" -> "FL",
    "San Francsico" -> "CA"
  )

  cities.map {
    case (k, v) => println(k + " -> " + v)
  }

  // The difference between map and collect
  /*
  List(1, 3, 5, "seven").map {
    case i: Int => i + 1  // scala.MatchError: seven (of class java.lang.String)
  }
  */

  List(1, 3, 5, "seven").collect {
    case i: Int => i + 1  // No error is generated because string "seven" is not collected.
  }

  // How to use partial function trait
  def answerUnits: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  assert(answerUnits(42) == 1)  // assertion succeed
  // answerUnits(0) // scala.MatchError: 0 (of class java.lang.Integer)

  //
  def inc: PartialFunction[Any, Int] = {
    case i: Int => i + 1
  }

  assert(inc(41) == 42)
  // assert("FortyOne") // scala.MatchError: FortyOne (of class java.lang.String)

  assert(inc.isDefinedAt(41))
  assert(!inc.isDefinedAt("FortyOne"))
  assert(List(42) == List(41, "cat").collect {
    case i: Int => inc(i)
  })
}
