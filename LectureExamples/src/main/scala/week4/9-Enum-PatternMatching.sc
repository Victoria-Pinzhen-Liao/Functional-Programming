enum DayOfWeek {
  case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}

import DayOfWeek._
import InternetCodes.CountryCode

def isWeekend(day: DayOfWeek) = day match
  case Saturday | Sunday => true
  case _ => false


isWeekend(Monday) // val res0: Boolean = false
isWeekend(Saturday) // val res1: Boolean = true

// --------------------
// Issue

object CurrencyEnum extends Enumeration {
  type Currency = Value
  val GBP = Value(1, "GBP")
  val EUR = Value
}

object InternetCodes extends Enumeration {
  type CountryCode = Value
  val EU, DE, CO = Value
}

import InternetCodes._
import CurrencyEnum._

 // Error
object Methods {
  def method(currency: Currency): Currency  =  currency
  def method(countryCode: CountryCode): CountryCode = countryCode
}

//|Double definition:
//  |def method(currency: CurrencyEnum.Currency): CurrencyEnum.Currency in object Methods at line 2 and
//  |def method(countryCode: InternetCodes.CountryCode): InternetCodes.CountryCode in object Methods at line 3