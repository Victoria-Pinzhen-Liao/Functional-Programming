package lecutreExample

import lecutreExample.MutableComplexNumber

class MutableComplexNumberTest extends munit.FunSuite {
  test("when adding two mutable complex numbers," +
    "will not get a new complex number ," +
    "and the original numbers will be changed") {
    val thisMutableComplexNumber = MutableComplexNumber(1, 2)
    val thatMutableComplexNumber = MutableComplexNumber(3, 4)
    thisMutableComplexNumber.add(thatMutableComplexNumber)

    assertEquals(thisMutableComplexNumber.real, 4)
    assertEquals(thisMutableComplexNumber.imaginary, 6)
  }
}