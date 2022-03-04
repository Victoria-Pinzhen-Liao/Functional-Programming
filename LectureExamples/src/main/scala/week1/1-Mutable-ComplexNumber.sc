class MutableComplexNumber(var real: Int, var imaginary: Int) {
  // Change this complex number
  def add(that: MutableComplexNumber) = {
    real += that.real
    imaginary += that.imaginary
  }
}

val thisMutableComplexNumber = MutableComplexNumber(1, 2)
val thatMutableComplexNumber = MutableComplexNumber(3, 4)
thisMutableComplexNumber.add(thatMutableComplexNumber)

assert(thisMutableComplexNumber.real == 4)
assert(thisMutableComplexNumber.imaginary == 6)