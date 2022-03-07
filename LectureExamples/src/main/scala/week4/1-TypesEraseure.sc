def isIntIntMap(x: Any) = x match {
  case m: Map[Int, Int] => true
  case _ => false
}


//val res0: Boolean = true
isIntIntMap(Map(1 -> 1))

//val res1: Boolean = true
isIntIntMap(Map("abc" -> "abc"))


//-----------------------------------
// Exception

def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}

//val res2: String = yes
isStringArray(Array("abc"))

//val res3: String = no
isStringArray(Array(1, 2, 3))
