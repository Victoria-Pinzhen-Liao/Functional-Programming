class ImmutableComplexNumber(val real: Int, val imaginary: Int) {
  // Return a new complex number
  def add(that: ImmutableComplexNumber): ImmutableComplexNumber = {
    new ImmutableComplexNumber(this.real + that.real, this.imaginary + that.imaginary)
  }
}

val thisImmutableComplexNumber = ImmutableComplexNumber(1, 2)
val thatImmutableComplexNumber = ImmutableComplexNumber(3, 4)
val newImmutableComplexNumber = thisImmutableComplexNumber.add(thatImmutableComplexNumber)

assert(newImmutableComplexNumber.real == 4)
assert(newImmutableComplexNumber.imaginary == 6)
assert(thisImmutableComplexNumber.real == 1)
assert(thisImmutableComplexNumber.imaginary == 2)
assert(thatImmutableComplexNumber.real == 3)
assert(thatImmutableComplexNumber.imaginary == 4)
