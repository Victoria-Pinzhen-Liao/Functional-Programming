import scala.math.{abs, pow, sqrt}

// define the sqrt function:
def squareRoot(squareNum: Double) = {
  // define what is "Good enough"
  val accuracy = 0.001

  // define a test to check for terminatation:
  def isGoodEnough(guessedSquareRoot: Double) =
    abs(guessedSquareRoot * guessedSquareRoot - squareNum) < accuracy

  // define a function improve to improve an estimate
  def improve(guessedSquareRoot: Double) =
    (guessedSquareRoot + squareNum / guessedSquareRoot) / 2

  // define a function which computes one iteration step
  // Note that `squareRootIterator` is recursive, its right-hand side calls itself.
  def squareRootIterator(guessedSquareRoot: Double): Double =
    if (isGoodEnough(guessedSquareRoot)) guessedSquareRoot
    else squareRootIterator(improve(guessedSquareRoot))

  squareRootIterator(1.0)
}

squareRoot(4)
// val res0: Double = 2.0000000929222947

