package lecutreExample

class ImmutableComplexNumber(val real: Int, val imaginary: Int) {
  // Return a new complex number
  def add(that: ImmutableComplexNumber): ImmutableComplexNumber = {
    new ImmutableComplexNumber(this.real + that.real, this.imaginary + that.imaginary)
  }
}