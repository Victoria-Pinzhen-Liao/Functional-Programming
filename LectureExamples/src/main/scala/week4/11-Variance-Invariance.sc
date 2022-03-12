abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

val catContainer: Container[Cat] = new Container(Cat("Felix"))
val cat: Cat = catContainer.getValue // val cat: Cat = Cat(Felix)

// Error
val animalContainer: Container[Animal] = catContainer
// Found: (catContainer : Container[Cat]) Required: Container[Animal]

// Won't work
animalContainer.setValue(Dog("Spot")) // Not found: animalContainer


