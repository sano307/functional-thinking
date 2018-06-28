package Chapter02

object TheCompanyProcess extends App {

  val employees = List(
    "neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan", "liam",
    "mason", "noah", "lucas", "jacob", "jayden", "jack", "inseo"
  )

  // Neal,Stu,Rich,Bob,Aiden,Ethan,Liam,Mason,Noah,Lucas,Jacob,Jayden,Jack,Inseo
  val result = employees
    .filter(_.length > 1)
    .map(_.capitalize)
    .reduce(_ + "," + _)

  // Parallel processing
  val parallelResult = employees
    .par
    .filter(_.length > 1)
    .map(_.capitalize)
    .reduce(_ + "," + _)
}
