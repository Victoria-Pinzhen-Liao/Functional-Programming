import scala.annotation.tailrec

// Greatest common divisor
@tailrec def gcd(a: Int, b: Int): Int = {
  if b == 0 then a else gcd(b, a % b)
}

class Rational(x: Int, y: Int) {

  def rationalGcd = {
    gcd(denom, numer)
  }

  def clean = {
    Rational(numer / rationalGcd, denom / rationalGcd)
  }

  def equals(that: Rational): Boolean = {
    val cleanThis = this.clean
    val cleanThat = that.clean
    cleanThis.numer == cleanThat.numer && cleanThis.denom == cleanThat.denom
  }

  def neg = {
    Rational(-this.numer, denom).clean
  }

  def mul(that: Rational): Rational = {
    Rational(this.numer * that.numer, this.denom * that.denom).clean
  }

  def div(that: Rational): Rational = {
    val reciprocal = Rational(that.denom, that.numer)
    this mul reciprocal
  }

  def add(that: Rational): Rational = {
    Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom).clean
  }

  def sub(that: Rational): Rational = {
    this add that.neg
  }

  def numer = x

  def denom = {
    if (y == 0) throw new IllegalArgumentException(s"denom cannot be 0") else y
  }

  override def toString: String = s"${this.numer}/${this.denom}"

}

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)

val a = Rational(2, 4)
val b = Rational(4, 2)

// val illegal = Rational(4, 0) // IllegalArgumentException: denom cannot be 0

x.neg.toString // val res0: String = -1/3

x sub y sub z // val res1: Rational = -79/42

a mul b // val res2: Rational = 1/1

a div a // val res3: Rational = 1/1

Rational(2, 4) equals Rational(1, 2) // val res4: Boolean = true