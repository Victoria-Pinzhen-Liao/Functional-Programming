lazy val even: Int => Boolean = _ % 2 == 0
even eq even
//Boolean = true

// -----------------------------

lazy val randomInt: () => Int = {
  val r = util.Random.nextInt
  () => r
}

randomInt()
// Int = -1068569869
randomInt()
// Int = -1068569869 - same result