package week2.lectureexample

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

