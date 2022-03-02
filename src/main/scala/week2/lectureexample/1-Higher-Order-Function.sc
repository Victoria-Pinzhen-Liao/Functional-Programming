// Summing with Higher-Order Functions
// Let’s define:
def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)

// when
def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if x == 0 then 1 else x * fact(x - 1)

//We can then write:
def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a, b)


sumInts(1, 2) // val res0: Int = 3
sumCubes(1, 2) // val res1: Int = 9
sumFactorials(1, 2) // val res2: Int = 3