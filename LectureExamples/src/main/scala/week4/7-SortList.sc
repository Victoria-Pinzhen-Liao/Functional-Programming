// worst case of insert: Big(O): N
def insert(x: Int, xs: List[Int]): List[Int] = xs match
  case List() => List(x)
  case y :: ys => if x < y then x :: xs else y :: insert(x, ys)


def sort(xs: List[Int]): List[Int] = xs match
  case List() => List()
  case y :: ys => insert(y, sort(ys))

sort(List(7, 3, 9, 2)) // val res0: List[Int] = List(2, 3, 7, 9)

