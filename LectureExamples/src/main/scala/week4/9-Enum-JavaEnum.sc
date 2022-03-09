
// Scala 3 only
object CurrencyADT(name: String, iso: String) extends java.lang.Enum {
  case EUR("Euro", "EUR")
  case USD("United States Dollar", "USD")
}
