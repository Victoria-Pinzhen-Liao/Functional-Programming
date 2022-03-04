// 1. Write a `#product` function that calculates the product of the
// values of a function for the points on a given interval.

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if a > b then 1 else f(a) * product(f)(a + 1, b)
}

// 1 * 2 * 3 = 6
product(x => x)(1, 3) // val res0: Int = 6

// 1 * 4 * 9 = 36
product(x => x * x)(1, 3) // val res0: Int = 36

// ----------------------------------------

// 2. Write factorial in terms of product.

// 2 * 3 * 4 * 5 = 120
def fact(n: Int) = product(x => x)(1, n)
fact(5) // val res2: Int = 120

// ----------------------------------------

// 3. Can you write a more general function, which generalizes both sum
//  and product

def mapReducedCalc(initial: Int)(operator: (Int, Int) => Int)(mapFunction: Int => Int)(start: Int, end: Int): Int
= {
  if start > end then initial else operator(mapFunction(start),
    mapReducedCalc(initial)(operator)(mapFunction)(start + 1, end))
}


// 1 + 2 + 3 = 6
mapReducedCalc(0)((x, y) => x + y)(x => x)(1, 3) // val res1: Int = 6

// 2 * 3 * 4 * 5 = 120
mapReducedCalc(1)((x, y) => x * y)(x => x)(1, 5) // val res4: Int = 120


