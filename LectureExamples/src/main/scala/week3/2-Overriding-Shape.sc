
// Creating a super class
abstract class Shapes {
  def draw() = println("Draw the shape")

}

// Creating a subclass
class Rectangle extends Shapes

// Creating a subclass
class Circle extends Shapes {
  // Overriding
  override def draw() = println("Draw the Circle")

}

val rectangle = new Rectangle
rectangle.draw()

val circle = new Circle
circle.draw()

// Result

//val rectangle: Rectangle = Rectangle@47a8e61f
//Draw the shape
//
//val circle: Circle = Circle@15c2d397
//Draw the Circle


