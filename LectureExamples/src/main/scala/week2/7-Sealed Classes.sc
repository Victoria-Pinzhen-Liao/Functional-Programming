import week2.MultipleChoice
import week2.MultipleChoiceSub

// Error:  Cannot extend sealed class MultipleChoice in a different source file
case class OptionD() extends MultipleChoice

case class OptionY() extends MultipleChoiceSub  //This is valid