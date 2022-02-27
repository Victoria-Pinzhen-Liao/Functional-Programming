
// Complain immediately
val evenValWithNoImpl: Int => Boolean = ???
//scala.NotImplementedError: an implementation is missing

// Complain on call
def evenDef: Int => Boolean = ???
//even: Int => Boolean

evenDef
// scala.NotImplementedError: an implementation is missing

// ------------------------------

// Identity

def even: Int => Boolean = _ % 2 == 0
even eq even
//Boolean = false

val evenVal: Int => Boolean = _ % 2 == 0
evenVal eq evenVal
//Boolean = true



// --------------------------------

// Function Result

val randomInt: () => Int = {
  val r = util.Random.nextInt
  () => r
}

// Same results
randomInt()
randomInt()

// --------------------------------


def randomIntDef: () => Int = {
  val r = util.Random.nextInt
  () => r
}

// Different
randomIntDef()
randomIntDef()