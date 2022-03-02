import scala.annotation.tailrec

def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int) = sum(x => x, a, b)
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

sumInts(1, 2) // val res0: Int = 3
sumCubes(1, 2) // val res1: Int = 9

//----------------
// Lecture homework
//The sum function uses linear recursion.
//Write a tail-recursive version

def tailRecursiveSum(f: Int => Int, start: Int, end: Int): Int = {
  @tailrec def loop(current: Int, acc: Int): Int =
    if current == end then acc + f(current)
    else loop(current + 1, acc + f(current))

  loop(start, 0)
}

def tailRecursiveSumInts(a: Int, b: Int) = tailRecursiveSum(x => x, a, b)
def tailRecursiveSumCubes(a: Int, b: Int) = tailRecursiveSum(x => x * x * x, a, b)

tailRecursiveSumInts(1, 2) // val res0: Int = 3
tailRecursiveSumCubes(1, 2) // val res1: Int = 9