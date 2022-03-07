class  A(a: Int)

A(3) match
  // A cannot be used as an extractor in a pattern
  // because it lacks an unapply or unapplySeq method
  //-- Error:
  case  A(a) => a
  case _ => -1