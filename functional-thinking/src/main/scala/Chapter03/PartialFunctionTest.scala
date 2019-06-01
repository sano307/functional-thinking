package Chapter03

object PartialFunction extends App {

  def price(product: String): Double =
    product match {
      case "apples" => 140
      case "oranges" => 220
    }

  def withTax(cost: Double, state: String): Double =
    state match {
      case "NY" => cost * 2
      case "FL" => cost * 1.5
    }

  val NewJerseyTax = withTax(_: Double, "NY")
  val FloridaTax = withTax(_: Double, "FL")

  val costOfApplesInNewJersey = NewJerseyTax(price("apples"))  // 280.0
  val costOfOrangesInNewJersey = NewJerseyTax(price("oranges"))  // 440.0

  val costOfApplesInFlorida = FloridaTax(price("apples"))  // 210.0
  val costOfOrangesInFlorida = FloridaTax(price("oranges"))  // 330.0
}
