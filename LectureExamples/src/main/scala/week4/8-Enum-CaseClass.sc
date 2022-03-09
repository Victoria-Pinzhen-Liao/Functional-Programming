trait Expr

object Expr {
  case class Var(s: String) extends Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr
}

Expr.Number(10) // val res0: Expr.Number = Number(10)

// Does not have #values
//Expr.values