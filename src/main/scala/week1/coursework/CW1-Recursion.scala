package coursework

import scala.annotation.tailrec
import scala.collection.mutable.Stack

object Recursion {

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(col: Int, row: Int): Int = {
    if (col == 0 && row == 0) 1 else if (col < 0 | row < 0) 0
    else pascal(col - 1, row - 1) + pascal(col, row - 1)
  }

  /**
   * Exercise 2
   */

  def balance(chars: List[Char]): Boolean = {
    var parenthesesStack = new Stack[Char]()

    @tailrec def balanceRec(chars: List[Char]): Boolean = {
      if (parenthesesStack.isEmpty && chars.isEmpty) true
      else if (parenthesesStack.nonEmpty && chars
        .isEmpty) false else {
        chars.last match {
          case ')' => {
            parenthesesStack.push(')')
            balanceRec(chars.dropRight(1))
          }
          case '(' => {
            if (parenthesesStack.nonEmpty && parenthesesStack.pop == ')') balanceRec(chars.dropRight(1))
            else false
          }
          case _ => balanceRec(chars.dropRight
          (1))
        }
      }
    }

    val isBalanced = balanceRec(chars)
    parenthesesStack = Stack[Char]()
    isBalanced

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty) 0
    else if (money == 0) 1
    else {
      val withFirstCoin = countChange(money - coins.head, coins)
      val withoutFirstCoin = countChange(money, coins.drop(1))
      withFirstCoin + withoutFirstCoin
    }
  }
}