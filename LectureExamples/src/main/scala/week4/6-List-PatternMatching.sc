def listToString(list: List[String]): String = list match {
  case s :: rest => s + " " + listToString(rest)
  case Nil => ""
}

val fruits = "Apples" :: "Bananas" :: "Oranges" :: Nil
//fruits: List[java.lang.String] = List(Apples, Bananas, Oranges)

 listToString(fruits)
//res0: String = "Apples Bananas Oranges "