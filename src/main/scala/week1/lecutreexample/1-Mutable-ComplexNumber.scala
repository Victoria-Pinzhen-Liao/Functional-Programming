package week1.lecutreexample

class MutableComplexNumber(var real: Int, var imaginary: Int) {
  // Change this complex number
  def add(that: MutableComplexNumber) = {
    real += that.real
    imaginary += that.imaginary
  }
}