
// Creating a super class
abstract class Shapes {
  def draw() = println("Draw the shape")

  // Overload
  def draw(id: Int) = println(s"Draw the shape (Id: $id)")
}

// Creating a subclass
class Rectangle extends Shapes

// Creating a subclass
class Circle extends Shapes {
  // Overriding
  override def draw() = println("Draw the Circle")

  // Override, Overload
  override def draw(id: Int) = println(s"Draw the Circle (Id: $id)")
}

val rectangle = new Rectangle
rectangle.draw()
rectangle.draw(0)

val circle = new Circle
circle.draw()
circle.draw(1)