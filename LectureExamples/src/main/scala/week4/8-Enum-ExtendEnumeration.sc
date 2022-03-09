object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

Weekday.Monday // val res0: Weekday.Value = Monday

Weekday.withName("Monday") // val res1: Weekday.Value = Monday
Weekday.values
// val res2: Weekday.ValueSet = Weekday.ValueSet(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)




//   -------------------------


object Weekday2 extends Enumeration {
  val Monday = Value("Mo.")
  val Tuesday = Value("Tu.")
  val Wednesday = Value("We.")
  val Thursday = Value("Th.")
  val Friday = Value("Fr.")
  val Saturday = Value("Sa.")
  val Sunday = Value("Su.")
}

Weekday2.Monday // val res2: Weekday2.Value = Mo.

Weekday2.Monday.toString // val res3: String = Mo.

Weekday2.values
// val res4: Weekday2.ValueSet = Weekday2.ValueSet(Mo., Tu., We., Th., Fr., Sa., Su.)

