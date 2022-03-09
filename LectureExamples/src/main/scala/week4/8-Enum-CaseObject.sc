sealed trait DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek

Sunday // val res0: Sunday.type = Sunday
Monday // val res1: Monday.type = Monday

s"Today is $Saturday" // val res2: String = Today is Saturday


// Error: does not have #values
//DayOfWeek.values

