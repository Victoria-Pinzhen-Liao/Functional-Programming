// Creating a super class
class Shape
// Creating a subclass
class Rectangle extends Shape

def draw[T <: Shape](shape: T): Unit = println(s"Draw the shape ${shape}")

draw[Shape](new Shape)
// Draw the shape class repl$.rs$line$1$Shape

draw[Rectangle](new Rectangle)
// Draw the shape class repl$.rs$line$2$Rectangle