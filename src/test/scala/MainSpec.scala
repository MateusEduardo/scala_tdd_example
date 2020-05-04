import org.scalatest.{Matchers, WordSpec}

class MainSpec extends WordSpec with Matchers {

  "A person" should {
    "be instantiated with a age and name" in {
      val john = Person(firstName = "John", lastName = "Mayer", 42)
      john.firstName should be("John")
      john.lastName should be("Mayer")
      john.age should be(42)
    }
  }

  "Get a human readable representation of the person" in {
    val paul = Person(firstName = "Paul", lastName = "Gilbert", age = 24)
    paul.description should be("Paul Gilbert is 24 years old")
  }

  "The Person companion object" should {
    val(akira, peter, nick) = (
      Person(firstName = "Akira", lastName = "Sakura", age = 11),
      Person(firstName = "Peter", lastName = "Muller", age = 34),
      Person(firstName = "Nick", lastName = "Tagart", age = 52)
    )
    "return a list of adult person" in {
      val ref = List(akira, peter, nick)
      Person.filterAdult(ref) should be(List(peter, nick))
    }
    "return an empty list if no adult in the list" in {
      val ref = List(akira)
      Person.filterAdult(ref) should be(List.empty[Person])
    }
  }
}
