//  variable’s type is  _inferred_  by the compiler
val s = "hello"   // immutable
var i = 42        // mutable

// -------------------------------------------------------

class Person(name: String)
val p = new Person("Victoria Pinzhen Liao")

// -------------------------------------------------------

//  _explicitly_  declare the variable type
val s2: String = "hello"
var i2: Int = 42

//----------------------------------------

//  `val`  makes a variable  _immutable_  — like  `final`  in Java  i.e.  _values_
//  `var`  makes a variable  _mutable_.  i.e.  _variables_

val a = 'a'

// Error: reassignment to val
//a = 'b'

var c = 'c'
c = 'd' // This is fine