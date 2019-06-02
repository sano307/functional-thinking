package chapter03

case class Counter() {
  var cnt: Int = 0

  def increment = cnt += 1
  def printCnt = println(cnt)
}

object CounterNumber extends App {

  val counter1 = Counter()
  val counter2 = Counter()

  counter1.increment
  counter1.printCnt  // 1

  counter2.increment
  counter2.increment
  counter2.printCnt  // 2

  counter2.increment
  counter2.increment
  counter2.increment
  counter2.increment
  counter2.printCnt  // 6

  counter1.increment
  counter1.increment
  counter1.increment
  counter1.increment
  counter1.printCnt  // 5
}
