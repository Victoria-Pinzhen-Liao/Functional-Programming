import scala.annotation.tailrec

import week2.lectureexample.Rational
import week2.lectureexample.Rational._

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)

val a = Rational(2, 4)
val b = Rational(4, 2)
val c = Rational(2)
val d = Rational(-2, 3)



x less z // val res0: Boolean = true
x less2 z // val res1: Boolean = true

// val illegal = Rational(4, 0) // IllegalArgumentException: denom cannot be 0

largerRationalNumber(c, d) // val res2: week2.lectureexample.Rational = 2/1

x.neg.toString // val res0: String = -1/3

x sub y sub z // val res1: Rational = -79/42

a mul b // val res2: Rational = 1/1

a div a // val res3: Rational = 1/1

Rational(2, 4).toString // val res4: String = 1/2

Rational(2, 4) equals Rational(1, 2) // val res4: Boolean = true

extension (thisRational: Rational) {
  def abs: Rational = Rational(thisRational.numer.abs, thisRational.denom)
}

d.abs // val res8: Rational = 2/3
