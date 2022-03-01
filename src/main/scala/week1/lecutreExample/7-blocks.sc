{ val x = 3
  x * x  // the return of the block
}

//-----------------

// This is scala 2
val y = 3
if (y != 1) {
  println ("y is not 1")
}

//-----------------

// Rule 1/2 -
// The definitions inside a block are only visible from within the block

def plusOne(z: Int) = {
  z + 1
}

z // Not found: z

// Rule 2/2 -
// The definitions inside a block shadow definitions of the same names outside the block.

val x = 0
def plusFour(y: Int) = {
  val x = 3
  y + x + 1 // x = 3
}

plusFour(3) // val res1: Int = 7

 