

import scala.annotation.tailrec
import scala.math.abs

class Rational(x: Int, y: Int) {

  require(y != 0, "denominator cannot be 0")

  def rationalGcd = {
    gcd(x, y)
  }

  def equals(that: Rational): Boolean = {
    this.numer == that.numer && this.denom == that.denom
  }

  def neg = {
    Rational(-this.numer, denom)
  }

  def mul(that: Rational): Rational = {
    Rational(this.numer * that.numer, this.denom * that.denom)
  }

  def div(that: Rational): Rational = {
    val reciprocal = Rational(that.denom, that.numer)
    this mul reciprocal
  }

  def add(that: Rational): Rational = {
    Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom)
  }

  def less(that: Rational): Boolean = {
    (this.numer / this.denom) < (that.numer / that.denom)
  }

  def less2(that: Rational): Boolean = {
    (numer / denom) < (that.numer / that.denom)
  }

  def sub(that: Rational): Rational = {
    this add that.neg
  }

  def numer = x / rationalGcd

  def denom = y / rationalGcd

  override def toString: String = s"${this.numer}/${this.denom}"

  def this(x: Int) = this(x, 1)

  def +(that: Rational): Rational = this.add(that)

  infix def *(that: Rational): Rational = this.mul(that)

  infix def min(that: Rational): Rational = {
    if (this less that) this else that
  }

  // Greatest common divisor
  @tailrec private def gcd(a: Int, b: Int): Int = {
    if b == 0 then a else gcd(b, a % b)
  }

}

end Rational

// Companion Object
object Rational {
  def largerRationalNumber(thisRational: Rational, thatRational: Rational)
  : Rational = {
    if (thisRational less thatRational) thatRational else thisRational
  }
}

import Rational.largerRationalNumber

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)


x less z // val res0: Boolean = true
x less2 z // val res1: Boolean = true

x min z // val res2: Rational = 1/3

// val illegal = Rational(4, 0) // IllegalArgumentException: denom cannot be 0

x.neg.toString // val res0: String = -1/3

x sub y sub z // val res1: Rational = -79/42

val a = Rational(2, 4)
val b = Rational(4, 2)
val c = Rational(2)
val d = Rational(-2, 3)

largerRationalNumber(c, d) // val res2: Rational = 2/1

a mul b // val res2: Rational = 1/1

a * b // val res2: Rational = 1/1

a.*(b) // val res2: Rational = 1/1

c + c // val res7: Rational = 4/1

a div a // val res3: Rational = 1/1

extension (thisRational: Rational) {
  def abs: Rational = Rational(thisRational.numer.abs, thisRational.denom)
}

d.abs // val res8: Rational = 2/3

Rational(2, 4).toString // val res4: String = 1/2

Rational(2, 4) equals Rational(1, 2) // val res4: Boolean = true


