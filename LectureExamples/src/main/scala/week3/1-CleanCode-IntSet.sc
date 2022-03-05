abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}



class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true

  def incl(x: Int): IntSet =
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if x > elem then NonEmpty(elem, left, right.incl(x))
    else this
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
}

object IntSet {
  def singleton(x: Int) = NonEmpty(x, Empty, Empty)
}

// val res0: Boolean = false
Empty.contains(1)
// Error: value contains is not a member of object NonEmpty
NonEmpty.contains(1)

// ---------------------------------

// val res1: Boolean = false
Empty.contains(1)

//val res2: Boolean = true
(NonEmpty(7, Empty, Empty)).contains(7)
