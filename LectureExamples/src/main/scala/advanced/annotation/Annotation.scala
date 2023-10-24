package annotation


import scala.annotation.StaticAnnotation
import scala.reflect.runtime.universe._

// Define a custom annotation named Check
class Check extends StaticAnnotation

// Define a Cat class with two fields: eyes and nose
class Cat(val eyes: String, val nose: String) {
  // Define a method named run, annotated with @Check
  @Check
  def run(): String = "Running fast"

  // Define a method named meow
  def meow(): String = "Meowing"

  // Override the equals method to provide custom equality check
  override def equals(obj: Any): Boolean = obj match {
    // If the other object is also a Cat, compare their fields and annotated methods
    case other: Cat =>
      this.eyes == other.eyes &&
        this.nose == other.nose &&
        compareAnnotatedMethods(this, other)
    // If the other object is not a Cat, they are not equal
    case _ => false
  }

  // Helper method to compare methods annotated with @Check
  private def compareAnnotatedMethods(cat1: Cat, cat2: Cat): Boolean = {
    // Obtain a runtime mirror for reflection
    val runtimeMirrorResult = runtimeMirror(getClass.getClassLoader)
    // Create instance mirrors for both cats
    val instanceMirror1 = runtimeMirrorResult.reflect(cat1)
    val instanceMirror2 = runtimeMirrorResult.reflect(cat2)
    // Obtain all members of the Cat class
    val members = runtimeMirrorResult.classSymbol(cat1.getClass).toType.members

    // Filter to find methods that are annotated with @Check and ensure all of them are equal
    members.filter(m => m.isMethod && m.annotations.exists(_.tree.tpe =:= typeOf[Check])).forall { m =>
      val methodMirror1 = instanceMirror1.reflectMethod(m.asMethod)
      val methodMirror2 = instanceMirror2.reflectMethod(m.asMethod)
      methodMirror1.apply() == methodMirror2.apply()
    }
  }
}

// Define an object to run tests
object CatTest extends App {
  // Create a few cat instances
  val cat1 = new Cat("blue", "small")
  val cat2 = new Cat("blue", "small") {
    // Override the run method to return a different value
    override def run(): String = "Running slowly"
  }
  val cat3 = new Cat("green", "small")
  val cat4 = new Cat("green", "small")

  // Test 1: cat1 should not be equal to cat2 because their run methods are different
  assert(!(cat1 == cat2), "Test 1 failed: cat1 should not be equal to cat2")
  // Test 2: cat1 should not be equal to cat3 because their eyes fields are different
  assert(!(cat1 == cat3), "Test 2 failed: cat1 should not be equal to cat3")
  // Test 3: cat3 should be equal to cat4 because all their fields and methods are equal
  assert((cat3 == cat4), "Test 3 failed: cat3 should be equal to cat4")
  // If all tests pass, print a success message
  println("All tests passed!")
}
