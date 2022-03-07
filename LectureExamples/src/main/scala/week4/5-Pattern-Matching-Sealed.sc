sealed abstract class Furniture

case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}


findPlaceToSit(Chair())
// val res0: String = Sit on the chair