import math.{abs, sqrt, pow}

// define a test to check for terminatation:
def isGoodEnough(guessedSquareRoot: Double, squareNum: Double) =
  abs(guessedSquareRoot * guessedSquareRoot - squareNum) < 0.001

// define a function improve to improve an estimate
def improve(guessedSquareRoot: Double, squareNum: Double) =
  (guessedSquareRoot + squareNum / guessedSquareRoot) / 2

// define a function which computes one iteration step
// Note that `squareRootIterator` is recursive, its right-hand side calls itself.
def squareRootIterator(guessedSquareRoot: Double, squareNum: Double): Double =
  if (isGoodEnough(guessedSquareRoot, squareNum)) guessedSquareRoot
  else squareRootIterator(improve(guessedSquareRoot, squareNum), squareNum)

// define the sqrt function:
def squareRoot(squareNum: Double) = squareRootIterator(1.0, squareNum)

// -------------------------

// Nod Bad Tests
squareRoot(4)
// val res0: Double = 2.0000000929222947

squareRoot(2)
// val res1: Double = 1.4142156862745097

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