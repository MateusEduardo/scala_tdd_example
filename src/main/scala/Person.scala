case class Person(firstName: String, lastName: String, age: Int) {
  def description = s"$firstName $lastName is $age ${if (age <= 1) "year" else "years" } old"

}

object Person {
// The for comprehension has been used only for demonstration purposes.
//  def filterAdult(persons: List[Person]): List[Person] = {
//    for {
//      person <- persons
//      if (person.age >= 18)
//    } yield (person)
//  }

  def filterAdult(persons: List[Person]): List[Person] = {
    persons.filter(_.age >= 18)
  }
}
