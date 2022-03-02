package week1.lecutreexample

import week1.lecutreexample.ImmutableComplexNumber

class ImmutableComplexNumberTest extends munit.FunSuite {
  test("when adding two immutable complex number," +
    "will get a new complex number ," +
    "and the original numbers won't change") {
    val thisImmutableComplexNumber = ImmutableComplexNumber(1, 2)
    val thatImmutableComplexNumber = ImmutableComplexNumber(3, 4)
    val newImmutableComplexNumber = thisImmutableComplexNumber.add(thatImmutableComplexNumber)
    assertEquals(newImmutableComplexNumber.real, 4)
    assertEquals(newImmutableComplexNumber.imaginary, 6)
    assertEquals(thisImmutableComplexNumber.real, 1)
    assertEquals(thisImmutableComplexNumber.imaginary, 2)
    assertEquals(thatImmutableComplexNumber.real, 3)
    assertEquals(thatImmutableComplexNumber.imaginary, 4)
  }
}