val ints = List(1, 2, 3)
val names = List("Joel", "Chris", "Ed")

val intsWithType: List[Int] = List(1, 2, 3)
val namesWithType: List[String] = List("Joel", "Chris", "Ed")

val a = List(1,2,3)
val b = 0 +: a
val c = List(-1, 0) ++: a

val d = a  :+ 0 // SLOW!


val fruit: List[String] = List("apples", "oranges", "pears")
val nums : List[Int] = List(1, 2, 3, 4)
val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty: List[Nothing] = List()

val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums2 = 1 :: (2 :: (3 :: (4 :: Nil)))
val empty2 = Nil

fruit.head // "apples"

fruit.tail.head // "oranges"

diag3.head // List(1, 0, 0)

empty.head
// would throw NoSuchElementException("head of empty list")

