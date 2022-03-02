// Normal summing functions
//Take the sum of the integers between a and b:
def sumInts(a: Int, b: Int): Int =
  if a > b then 0 else a + sumInts(a + 1, b)

//Take the sum of the cubes of all the integers between a and b :
def cube(x: Int): Int = x * x * x
def sumCubes(a: Int, b: Int): Int =
  if a > b then 0 else cube(a) + sumCubes(a + 1, b)

def factorial(n: Int): Int =
  if n == 0 then 1 else n * factorial(n - 1)

//Take the sum of the factorials of all the integers between a and b :
def sumFactorials(a: Int, b: Int): Int =
  if a > b then 0 else factorial(a) + sumFactorials(a + 1, b)


sumInts(1, 2) // val res0: Int = 3
sumCubes(1, 2) // val res1: Int = 9
sumFactorials(1, 2) // val res2: Int = 3