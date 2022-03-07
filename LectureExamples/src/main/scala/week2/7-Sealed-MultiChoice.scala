package week2

sealed abstract class MultipleChoice

case class OptionA() extends MultipleChoice

case class OptionB() extends MultipleChoice

case class OptionC() extends MultipleChoice

abstract class MultipleChoiceSub extends MultipleChoice
