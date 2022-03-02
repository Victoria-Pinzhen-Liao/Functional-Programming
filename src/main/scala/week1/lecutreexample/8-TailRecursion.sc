// Function that calls itself as its last action
// Impl of the function that computes the greatest common divisor of two numbers
// using Euclid’s algorithm:

import scala.annotation.tailrec

@tailrec def gcd(a: Int, b: Int): Int = {
  if b == 0 then a else gcd(b, a % b)
}

gcd(14, 21) // val res0: Int = 7

//→ if 21 == 0 then 14 else gcd(21, 14 % 21)
//→ if false then 14 else gcd(21, 14 % 21)
//  → gcd(21, 14 % 21)
//  → gcd(21, 14)
//→ if 14 == 0 then 21 else gcd(14, 21 % 14)
//  →→ gcd(14, 7)
//  →→ gcd(7, 0)
//→ if 0 == 0 then 7 else gcd(0, 7 % 0)
//  → 7

// Function that does NOT call itself as its last action
// ----------------------------------

//@tailrec ERROR:   Cannot rewrite recursive call: it is not in tail position
def factorial(n: Int): Int =
  if n == 0 then 1 else n * factorial(n - 1)

factorial(4) // val res1: Int = 24

//→ if 4 == 0 then 1 else 4 * factorial(4 - 1) 3-> →→ 4 * factorial(3)
//  →→ 4 * (3 * factorial(2))
//  →→ 4 * (3 * (2 * factorial(1)))
//  →→ 4 * (3 * (2 * (1 * factorial(0)))
//  →→ 4 * (3 * (2 * (1 * 1)))
//  →→ 24

// change factorial to @tailrec

@tailrec def factorialTailRec(n: Int, lastFactorial: Int): Int =
  if n == 0 then lastFactorial else factorialTailRec(n - 1, n * lastFactorial)

factorialTailRec(4, 1) // val res1: Int = 24
