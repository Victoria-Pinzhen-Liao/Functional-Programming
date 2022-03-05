
// Creating a super class
abstract class Shapes {
  def draw() = println("Draw the shape")

  // Overload
  def draw(id: Int) = println(s"Draw the shape (Id: $id)")
}

trait MathShape {
  def size: Int
}

// Creating a subclass
class Rectangle extends Shapes {
  def size = println("length (L) * width (W) ")
}

// Creating a subclass
class Circle extends Shapes {
  // Overriding
  override def draw() = println("Draw the Circle")

  // Override, Overload
  override def draw(id: Int) = println(s"Draw the Circle (Id: $id)")

  def size = println("pi * radius^2 ")
}

val rectangle = new Rectangle
rectangle.draw()
rectangle.draw(0)
rectangle.size

val circle = new Circle
circle.draw()
circle.draw(1)
circle.size





