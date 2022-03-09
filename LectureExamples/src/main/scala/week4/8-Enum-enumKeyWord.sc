enum Expr {
  case Var(s: String)
  case Number(n: Int)
  case Sum(e1: Expr, e2: Expr)
  case Prod(e1: Expr, e2: Expr)
}

Expr.Number(10) // val res0: Expr = Number(10)

// Error: does not have #values
//Expr.values


// ------------------------------

enum Color {
  case Red
  case Green
  case Blue
}

Color.Red // val res1: Color = Red
Color.values //  val res2: Array[Color] = Array(Red, Green, Blue)

//--------------------------

enum Direction(val dx: Int, val dy: Int) {
  case Right extends Direction(1, 0)
  case Up extends Direction(0, 1)
  case Left extends Direction(-1, 0)
  case Down extends Direction(0, -1)

  def leftTurn = Direction.values((ordinal + 1) % 4)

}

Direction.values // val res3: Array[Direction] = Array(Right, Up, Left, Down)

val r = Direction.Right
val u = r.leftTurn // u = Up
val v = (u.dx, u.dy) // v = (1, 0)

