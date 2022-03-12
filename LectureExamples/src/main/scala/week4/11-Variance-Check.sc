trait Function1[-T, +U]:
  def apply(x: T): U // good

  def apply2(x: U): T // bad
 // |contravariant type T occurs in covariant position in type (x: U): T