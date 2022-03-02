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

// -------------------------

// Not bad
squareRoot(4)
// val res0: Double = 2.0000000929222947

// -------------------------

// Bad example
squareRoot(0.001)
// val res2: Double = 0.04124542607499115

// Correct answer
sqrt(0.001)
// val res3: Double = 0.03162277660168379

// -------------------------

val largeNumber: Double = pow(10, 50)

// Correct answer
sqrt(largeNumber)
// val res4: Double = 1.0E25

// Bad example
squareRoot(largeNumber)
// Never terminate