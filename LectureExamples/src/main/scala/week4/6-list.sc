val ints = List(1, 2, 3)
val names = List("Joel", "Chris", "Ed")

val intsWithType: List[Int] = List(1, 2, 3)
val namesWithType: List[String] = List("Joel", "Chris", "Ed")

val a = List(1,2,3)
val b = 0 +: a
val c = List(-1, 0) ++: a

val d = a  :+ 0 // SLOW!
