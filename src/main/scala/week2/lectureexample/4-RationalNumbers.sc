class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
}

val x = Rational(1, 2)

x.numer // 1
x.denom // 2

// -------------------------

def addRational(r: Rational, s: Rational): Rational =
  Rational(
    r.numer * s.denom + s.numer * r.denom,
    r.denom * s.denom)

def makeString(r: Rational): String = s"${r.numer}/${r.denom}"

val sum: Rational = addRational(Rational(1, 2), Rational(2, 3))

makeString(sum) // val res2: String = 7/6


