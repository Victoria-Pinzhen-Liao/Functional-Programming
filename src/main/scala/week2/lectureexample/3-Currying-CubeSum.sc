//Look again at the summation functions:

def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)

def cube(x: Int): Int = x * x * x
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

// Rewrite sum as follows to make it a functions returning functions
def sumCurry(f: Int => Int): (Int, Int) => Int = {
  def sumLoop(a: Int, b: Int): Int =
    if a > b then 0
    else f(a) + sumLoop(a + 1, b)

  sumLoop
}

// We can then define some stepwise applications
def sumCubesCurry = sumCurry(x => x * x * x)

// These functions can in turn be applied like any other function:
sumCubesCurry(1, 10) // val res1: Int = 3025

// This consecutive Stepwise Applications  is the same as
sumCurry(cube)(1, 10) // val res1: Int = 3025

sumCurry(cube)(1, 10) == (sumCurry(cube)) (1, 10)

// ---------------------------------------

// Multiple Parameter Lists

// The type is (Int => Int) => (Int, Int) => Int
def cleanSum(f: Int => Int)(a: Int, b: Int): Int = {
  if a > b then 0 else f(a) + cleanSum(f)(a + 1, b)
}