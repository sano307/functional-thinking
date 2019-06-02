package chapter03

case class Employee(name: String, salary: Int) {
  def paidMore(amount: Int): Boolean =
    this.salary > amount

  def isHighPaid = paidMore(3000000)
}

object EvaluateSalary extends App {

  val worker1: Employee = Employee("inseo", 4000000)
  val worker2: Employee = Employee("taku", 2999999)

  println(worker1.isHighPaid)  // true
  println(worker2.isHighPaid)  // false
}
