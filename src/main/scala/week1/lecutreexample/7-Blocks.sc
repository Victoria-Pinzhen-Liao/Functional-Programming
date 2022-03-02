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

// Rule 1/3 -
// The definitions inside a block are only visible from within the block

def plusOne(z: Int) = {
  z + 1
}

// If we try to check z here
// z // Not found: z

// Rule 2/3 -
// The definitions inside a block shadow definitions of the same names outside the block.

val x = 0
def plusFour(y: Int) = {
  val x = 3
  y + x + 1 // x = 3
}

plusFour(3) // val res1: Int = 7

// Rule 3/3 - Lexical Scoping: Definitions of outer blocks are **visible**
// inside a block unless they are shadowed.

val a = 2
def plusThree(b: Int) = {
  a + b + 1 // a = 3
}

plusThree(1) // val res2: Int = 4