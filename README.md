
#  (1) Principles of Functional Programming

## About

:octocat: GitHub: All of the example code: [repo (link)](https://github.com/Victoria-Pinzhen-Liao/Functional-Programming)

:page_facing_up:  blog link:  https://purrgramming.life/cs/programming/fp/   :star:


-------------------------------------------

This blog answers

1. What is functional programming?
2. Why functional programming?
3. Advantage of functional programming

-------------------------------------------

## Programming Paradigms

**Paradigm** - In science, a paradigm describes distinct concepts or thought patterns in some scientific discipline.


Image source: https://javascript.plainenglish.io/what-are-javascript-programming-paradigms-3ef0f576dfdb

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655330430.png)


## Imperative Programming

In imperative programming, we
- modify mutable variables,
- using assignments ( sets and/or re-sets the value stored in the storage location(s) denoted by a variable name)
- using control structures such as if-then-else, loops, break, continue, return.

Example:  instruction sequences for a Von Neumann computer.

image source: https://diu-eil.gricad-pages.univ-grenoble-alpes.fr/archi-robotique-systeme-reseau/systeme/syst_2_processus.pdf

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655317849.png)

where

- Mutable variables ≈ memory cells
- Variable dereferences (used to access or manipulate data contained in the memory location pointed to by a pointer) ≈ load instructions
- Variable assignments ≈ store instructions
- Control structures ≈ jumps






###  Example: Complex Number Theory

#### Definition of Theory

A theory consists of
-  one or more data types
- operations on these types
-  laws that describe the relationships between values and operations
-
Typically, a theory does **not** describe mutations.

image source: https://dandelife.com/what-are-the-things-you-should-know-about-complex-numbers/
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645741123766.png)

For instance, the theory of complex number defines the sum of two complex numbers by laws such as:

image source: https://numberworksheet.info/complex-number-multiplication-worksheet/
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645741136587.png)

where complex numbers are addends

image source: https://www.greenemath.com/Prealgebra/5/PropertiesofAdditionLesson.html
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645741145282.png)

#### Coding Example



In an imperative / mutable  program, we can define ComplexNumber as :

```scala
  
class MutableComplexNumber(var real: Int, var imaginary: Int) {  
  // Change this complex number  
  def add(that: MutableComplexNumber) = {  
  real += that.real  
    imaginary += that.imaginary  
  }  
}
```

We can see that when adding two mutable complex numbers, the function will not return a new complex number, and instead, the original complex number (the addend) is changed.

```scala
import lecutreExample.MutableComplexNumber

class MutableComplexNumberTest extends munit.FunSuite {  
  test("when adding two mutable complex numbers," +  
    "will not get a new complex number ," +  
    "and the original numbers will be changed") {  
  val thisMutableComplexNumber = MutableComplexNumber(1, 2)  
  val thatMutableComplexNumber = MutableComplexNumber(3, 4)  
  thisMutableComplexNumber.add(thatMutableComplexNumber)  
  
  assertEquals(thisMutableComplexNumber.real, 4)  
  assertEquals(thisMutableComplexNumber.imaginary, 6)  
 }}
```


### Issues

Issues of Mutation and Imperative Programming

#### In Math
There is no place for mutation if we implement high-level concepts following their mathematical theories.
- The theories do not admit it.
-  Mutation can destroy useful laws in the theories.

#### In CS
The mutation changes an object and is one common side effect in programming languages.
- Mutation may lead to unexpected and hard-to-debug issues, where data becomes incorrect somewhere, and you have no idea where it happens.
- Mutation makes code harder to understand: at any time, an array or object may have a different value, so we need to be very careful when reading the code.
- Mutation of function arguments makes the behaviour of a function surprising.

Also, it's hard to scale up ("Von Neumann" bottleneck)
- " One tends to conceptualize data structures word-by-word. "
-   Need to define high-level abstractions such as collections, polynomials, geometric shapes, strings, documents

## Functional Programming

### Definition

**Restricted** :  A functional programming language  does ***not*** have
- mutable variables
-  assignments,
- or imperative control structures.

**Wider** : a functional programming language focused on functions and immutable data structures.

### FP Languages

- Lisp, Scheme, Racket, Clojure
-  SML, Ocaml, F#
-  Haskell
-  Scala

Concepts and constructs from functional languages are also found in many traditional languages like Java.

### Functions in FP

Functions in an FP language are first-class citizens i.e.
-  they can be defined anywhere, including inside other functions
-  like any other value, they can be passed as parameters to functions and returned as results
- as for other values, there exists a set of operators to compose functions
- i.e. functions can be values that are produced, consumed, and composed



### Benefits

1. Reduce errors
    -   no need to check two places to see all available variables

2. Increased developer productivity
    -  Shorter code

3. More philosophical
    - More mathematical
    -  Improve modularity
    - Higher-level abstractions

4. Morden
    - It is an effective tool to handle concurrency and parallelism on every scale
    - Our computers are not Van-Neuman machines anymore. They are parallel

### Coding Example

In an functional / immutable  program we can define ComplexNumber as :

```scala
class ImmutableComplexNumber(val real: Int, val imaginary: Int) {  
  // Return a new complex number  
  def add(that: ImmutableComplexNumber): ImmutableComplexNumber = {  
  new ImmutableComplexNumber(this.real + that.real, this.imaginary + that.imaginary)  
 }}
```

We can see that when adding two immutable complex numbers, the function will return a new complex number, and the original complex numbers (addends) will not change.

```scala
  
import lecutreExample.ImmutableComplexNumber  
  
class ImmutableComplexNumberTest extends munit.FunSuite {  
  test("when adding two immutable complex number," +  
    "will get a new complex number ," +  
    "and the original numbers won't change") {  
  val thisImmutableComplexNumber = ImmutableComplexNumber(1, 2)  
  val thatImmutableComplexNumber = ImmutableComplexNumber(3, 4)  
  val newImmutableComplexNumber = thisImmutableComplexNumber.add(thatImmutableComplexNumber)  
  assertEquals(newImmutableComplexNumber.real, 4)  
  assertEquals(newImmutableComplexNumber.imaginary, 6)  
  assertEquals(thisImmutableComplexNumber.real, 1)  
  assertEquals(thisImmutableComplexNumber.imaginary, 2)  
  assertEquals(thatImmutableComplexNumber.real, 3)  
  assertEquals(thatImmutableComplexNumber.imaginary, 4)  
 }}
```

## Tool: REPL

Functional programming is a bit like using a calculator.

An interactive shell (or [REPL, for Read-Eval-Print-Loop](https://docs.scala-lang.org/overviews/scala-book/scala-repl.html)) lets one write expressions and responds with their value.  Alternatively, you can use a scala worksheet.



**Doc**
REPL: https://docs.scala-lang.org/overviews/scala-book/scala-repl.html
Scala worksheet: https://docs.scala-lang.org/scala3/book/tools-worksheets.html

**Example**

The Scala REPL can be started by simply typing
```scala
> scala
```

Here are some simple interactions with the REPL
```scala
scala> 87 + 145 
res0: Int = 232 
```

Functional programming languages are more than simple calcululators because they let one define `values and functions`:
```scala
scala> def size = 2 
size: Int 

scala> 5 * size 
res1: Int = 10
```


## Elements of Programming


Every non-trivial programming language provides:
- primitive* expressions representing the simplest elements
-  ways to combine expressions
-  ways to abstract expressions, which introduce a name for an expression that can then be referred to.

### Primitive
In Scala, Primitive types are similar to Java but are written capitalized:

| Int        | 32-bit integers                |
|-------------------|-----------------------------------------|
| Long     | 64-bit integers                |
| Float    | 32-bit floating point numbers  |
| Double   | 64-bit floating point numbers  |
| Char     | 16-bit unicode characters      |
| Short    | 16-bit integers                |
| Byte     | 8-bit integers                 |
| Boolean  | boolean values true and false  |



### Evaluation

A non-primitive expression is evaluated as follows.
1. Take the leftmost operator
2.  Evaluate its operands (left before right)
3.  Apply the operator to the operands

A name is evaluated by replacing it with the right-hand side of its definition.
The evaluation process stops once it results in a value.


#### Example： Circumference

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645746285121.png)

```scala
// Circumference  
def pi = 3.14159  
def radius = 10  
(2 * pi) * radius
```

Scala worksheet output

```scala
def pi: Double
def radius: Int
val res0: Double = 62.8318
```

### Parameters

Definitions can have parameters.



```scala
def square(x: Double) = x * x  
  
square(2)  
square(5 + 4)  
square(square(4))  
```

Output

```scala
def square(x: Double): Double

val res0: Double = 4.0
val res1: Double = 81.0
val res2: Double = 256.0

```

Function parameters come with their type,   which is given after a colon.

```scala
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)  
```



Applications of parameterized functions are evaluated similarly as operators:
1. Evaluate all function arguments, from left to right
2.  Replace the function application by the function’s right-hand side, and, at the same time
3.  Replace the formal parameters of the function with the actual arguments

```scala
sumOfSquares(3, 2+2)
```

it is converted to

```scala
-> sumOfSquares(3, 4) 
-> square(3) + square(4)
-> 9 + 16
```

Output

```scala
def sumOfSquares(x: Double, y: Double): Double
val res3: Double = 25
```


## The substitution Model
###  Function Termination

```
Q: Does every expression reduce to a value (in a finite number of steps)? 
```

No. Here is a counter-example

```scala
def loop: Int = loop loop
```

### Substitution Model
This scheme of expression evaluation is called the substitution model, where
- all evaluation does is reduce an expression to a value.
- It can be applied to all expressions, as long as they have no side effects (storing files, printing, reading etc.).
- The substitution model is formalized in the `λ-calculus`, which gives a foundation for functional programming.

### Functional Contract

- A method with a  **functional contract**  will always return the same value to the same arguments.
- Have no other side effects (like storing files, printing, reading).
- Thus, even if you mutate temporary values inside your function, it is still pure from the outside.



## Call-by-Name and Call-by-Value

### Call-by-Value

The interpreter reduces function arguments to values before rewriting the function application.

```scala
def square(x:  Double ) = x * x
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)  
sumOfSquares(3, 2+2) 
square(3) + square(2+2) 
3 * 3 + square(2+2) 
9 + square(2+2) 
9 + (2+2) * (2+2) 
9 + 4 * (2+2) 
9 + 4 * 4 
25
```

### Call-by-Name

Apply the function to unreduced arguments.  
We prepend  _**=>**_  (rocket symbol) to its type.

```scala
def callByNameFunc(input: => InputType)  
```

```scala
def square(x: =>  Double ) = x*x
def sumOfSquares(x: => Double, y: => Double) = square(x) + square(y)  
sumOfSquares(3, 2+2) 
sumOfSquares(3, 4) 
square(3) + square(4) 
3 * 3 + square(4) 
9 + square(4) 
9 + 4 * 4 
9 + 16 
25
```

### Comparison
Both strategies reduce to the same final values as long as
- the reduced expression consists of pure functions, and
- both evaluations terminate.

#### Performance

Say we have a function that takes two inputs and  returns the square of the first input
i.e. the 2nd input is not used

```scala
def squareOfFirstElement(x: Int, y: Int) = x * x
```

Which one is faster? Call by name or call by value?
```
squareOfFirstElement(7, 8)  
squareOfFirstElement(3+4, 8) 
squareOfFirstElement(7, 2*4)  
squareOfFirstElement(3+4, 2*4)  
```

We want to examine the evaluation strategy and determine which one is faster (fewer steps) in these conditions:

##### Scenario 1

```scala
squareOfFirstElement(2,3)
```

call by value:
```scala
squareOfFirstElement(2,3) 
↓ 
2*2 
↓
4  
```
call by name:
```scala
squareOfFirstElement(2,3) 
↓
2*2 
↓
4  
```

Here the result is reached with the same number of steps.

##### Senario 2

```scala
squareOfFirstElement(3+4,8)
```


call by value:
```scala
squareOfFirstElement(7,8) 
↓ 
7*7
↓ 
49  
```

call by name:
```scala
(3+4)*(3+4) 
↓
7*(3+4)
↓
7*7 
↓
49  
```
Here call by value is faster.

##### Senario 3

```scala
squareOfFirstElement(7,2*4)
```


call by value:
```scala
squareOfFirstElement(7,8) 
↓ 
7*7 
↓
49
```  
call by name:
```scala
7 * 7 
↓ 
49  
```
Here call by name is faster.

##### Senario 4

```scala
squareOfFirstElement(3+4, 2*4) 
```

call by value:

```scala
squareOfFirstElement(7,2*4) 
↓ 
squareOfFirstElement(7, 8)
↓
7*7 
↓
49  
```

call by name:
```scala
(3+4)*(3+4)
↓
7*(3+4) 
↓ 
7*7
↓ 
49  
```
The result is reached within the same steps.


#### Advantage
Call-by-value
-  it evaluates every function argument only once
- avoids the repeated re-computation of argument expressions

Call-by-name
- a function argument is not evaluated if the corresponding parameter is unused in the evaluation of the function body.


#### Termination

Call-by-name and call-by-value evaluation strategies reduce an expression to the same value as long as both evaluations terminate.

```
Q: But what if termination is not guaranteed?
```

If CBV evaluation of an expression `#e` terminates, then CBN evaluation of `#e` terminates, too.
The other direction is not true.

| Terminates? | CallByName | CallByValue | Possible? |
|-------------|------------|-------------|-----------|
| 1           | T          | T           | T         |
| 2           | F          | T           | F         |
| 3           | F          | F           | T         |
| 4           | T          | F           | T         |

For example: find an expression that terminates under CBN but not under CBV.

```scala
def firstByValue(x: Int, y: Int) = x  
def firstByName(x: => Int, y: => Int) = x  
  
def loop: Int = {  
  while (true) {  
    Thread.sleep(1000)  
  }  
  1  
}  

// #loop never called，
firstByName(1, loop)  
// Return: val res0: Int = 1

// Whill try to exe #loop first 
firstByValue(1, loop) 
// Never end
```


# (2) Scala Basics

## About

:octocat: GitHub: All of the example code: [repo (link)](https://github.com/Victoria-Pinzhen-Liao/Functional-Programming)

:page_facing_up:  blog link:  https://purrgramming.life/cs/programming/fp/   :star:

 
-------------------------------------------

Topics:
1. Scala set up
2.  `val` vs `var` vs `def` vs method
3.   Condition blocks
4. Arithmetic and boolean expressions
5. Semicolons
6. Blocks and Lexical Scope

-------------------------------------------

## Getting Started

- Get up and running with Scala on your computer: [link](https://www.coursera.org/learn/scala-functional-programming/supplement/BNOBK/tools-setup-please-read)
- Useful links for learning scala: [link](https://www.coursera.org/learn/scala-functional-programming/supplement/D9pm0/learning-resources)

## Functions and Methods

### Functions
A function
- is a collection of statements that perform a certain task.
- is used to put some common and repetitive tasks into a single function, so we can call the function instead of writing the same code again and again for different inputs.
- Scala is assumed as a functional programming language, so these play an important role. It makes it easier to debug and modify the code. Scala functions are  **first-class values**.

### Functions vs Methods

Function -  an object which can be stored in a variable.
Method - always belongs to a class with a name signature bytecode.

etc. You can say a method is a function that is a member of some object.

## var vs val

In Java you declare new variables like this:

```java
String s = "hello";
int i = 42;
Person p = new Person("Victoria Pinzhen Liao");

```

Each variable declaration is preceded by its type.


Scala has two types of variables:

-   `val`  creates an  _immutable_  variable (like  `final`  in Java, or `constants` in other languages)
-   `var`  creates a  _mutable_  variable

This is what variable declaration looks like in Scala:

```scala
//  variable’s type is  _inferred_  by the compiler 
val s = "hello"   // immutable
var i = 42        // mutable

class Person(name: String)
val p = new Person("Victoria Pinzhen Liao")
```

Those examples show that the Scala compiler is usually **smart enough** to infer the variable’s data type from the code on the right side of the  `=`  sign. We say that the variable’s type is  _inferred_  by the compiler.

You can also  _explicitly_  declare the variable type if you prefer:

```scala
//  _explicitly_  declare the variable type 
val s: String = "hello"
var i: Int = 42
```

### Performance

`val` and `var` are evaluated when defined.

###  `val`  vs `var`

`val`  makes a variable  _immutable_  — like  `final`  in Java, i.e.  _values_
`var`  makes a variable  _mutable_.  i.e.  _variables_

```scala
val a = 'a'
a = 'b'
```
Result
```scala
<console>:12: error: reassignment to val
```

That fails with a `reassignment to val` error, as expected. Conversely, you can reassign a  `var`:

```scala
var c = 'c'  
c = 'd' // This is fine
```
Result
```scala
c: Char = d
```

### Which One?
The general rule is that you should always use a  `val`  field unless there is a `good` reason not to.
- makes your code more like algebra
- helps get you started down the path to functional programming, where  _all_  fields are immutable.



###  `val`  in REPL

The REPL is not 100% the same as working with source code in an IDE, so you can do a few things in the REPL that you `cannot` do when working on real-world code in a project.

You can redefine a  `val`  field in the REPL, like this:

```scala
// It's ok only in REPL
scala> val age = 18
age: Int = 18

scala> val age = 19
age: Int = 19

```

`val`  fields cannot be redefined like that in the real world, but they can be redefined in the REPL playground.


## val vs def  vs lazy val


### val vs def

To introduce a definition evaluated only when used, we use the keyword `def.`

`def` introduces a definition where the right-hand side is evaluated on each use.

While the `def`  is a function declaration, it is evaluated on call, i.e. `val`  evaluates when defined,  `def`  - when called:

**Example**:
```scala
// Complain immediately
scala> val even: Int => Boolean = ???
scala.NotImplementedError: an implementation is missing

// Complain on call
scala> def even: Int => Boolean = ???
even: Int => Boolean

scala> even
scala.NotImplementedError: an implementation is missing

```

### Function Identity
Method  `def even`  evaluates on call and creates **new** function every time (new instance of  `Function1`).

```scala
def even: Int => Boolean = _ % 2 == 0  
even eq even  
//Boolean = false  
  
val evenVal: Int => Boolean = _ % 2 == 0  
evenVal eq evenVal  
//Boolean = true  
  
```

### Function Results

With  `def`  you can get new function on every call:

```scala
val randomInt: () => Int = {  
  val r = util.Random.nextInt  
  () => r  
}  
  
randomInt() // val res3: Int = 1764655189  
randomInt() // val res4: Int = 1764655189

// --------------------------------  
  
  
def randomIntDef: () => Int = {  
  val r = util.Random.nextInt  
  () => r  
}  
  
// Different  
randomIntDef()  
randomIntDef()

```


###  lazy val

`lazy val` is evaluated when called the first time:

```scala
scala> lazy val even: Int => Boolean = ???
even: Int => Boolean = <lazy>

scala> even
scala.NotImplementedError: an implementation is missing

```

But returns the same result (in this case same instance of  `FunctionN`) every time:

#### Identity
```scala
lazy val even: Int => Boolean = _ % 2 == 0  
even eq even  
//Boolean = true
```

#### Result

```scala
  
lazy val randomInt: () => Int = {  
  val r = util.Random.nextInt  
  () => r  
}  
  
randomInt()  
// Int = -1068569869  
randomInt()  
// Int = -1068569869 - same result
```

### Performance

`val` is evaluated when defined.

`def` is evaluated on every call so that performance could be worse than  `val`  for multiple calls. You will get the same performance with a single call. Furthermore, with no calls, you will get no overhead from  `def`, so you can define it even if you do not use it in some branches.

With a  `lazy val` you will get a lazy evaluation: you can define it even if you do not use it in some branches, and it evaluates once or never, but you will get a little overhead from double-checking locking on every access to your  `lazy val`.

However, if you need a function (not a method) for function composition or higher-order functions (like  `filter(even)`) compiler will generate a function from your method every time you are using it as a function so that performance could be slightly worse than with  `val`.


## Conditionals


To express choosing between two alternatives, Scala has a conditional expression if-then-else.

Example:

```scala
def absoluteValue(x: Int) = if (x >= 0) x else -x  
absoluteValue(1)  // val res0: Int = 1
absoluteValue(-2) // val res1: Int = 2
```
where `x >= 0` is a predicate, of type `Boolean`.

### Boolean Composition

Boolean expressions b can be composed of
```scala
true false // Constants 
!b // Negation 
b && b // Conjunction 
b || b // Disjunction 
```
Example: The usual  operations:
```scala
e <= e
e == e
e != e
```

### Clean Code

```scala
!true --> false 
!false --> true 
true && e --> e 
false && e --> false 
true || e --> true 
false || e --> e 
```
Note that && and || do not always need their right operand to be evaluated.


##  Semicolons

If there are more than one statements on a line, they need to be separated by semicolons:

```scala
val y = x + 1; y * y 
```
Semicolons at the end of lines are usually (and should be) left out.

You could write
```scala
val x = 1; 
```
but it would not be very idiomatic in Scala


##  Blocks and Lexical Scope

### Blocks

A block is delimited by braces `{ ... }`.

A block
- contains a sequence of definitions or expressions.
- may appear everywhere an expression can.

Example block
```scala
{ val x = 3
x * x  // the return of the block 
}
```

Result
```scala
val x: Int = 3
val res0: Int = 9
```
####  Block return
- the last element of a block is an expression that defines its value
   - (The `x * x` in this block ).
- This return expression can be preceded by auxiliary definitions.

### Braces

From Scala 3, braces are optional (i.e. implied) around a correctly indented expression that appears after `=, then, else, …`

Scala 2
```scala 
val y = 3  
if (y != 1) {  
  println ("y is 1")  
}
```

Scala 3
```scala 
val y = 3  
if y != 1 {  
  println ("y is not 1")  
}
```

### Visibility -  3 Rules

Rule 1/3 - The definitions inside a block are only visible from within the block

```scala
def plusOne(z: Int) = {  
  z + 1  
}  
  
z // Error: Not found: z
```

Rule 2/3 - The definitions inside a block shadow definitions of the same names outside the block.

```scala
val x = 0  
def plusFour(y: Int) = {  
  val x = 3  
  y + x + 1 // x = 3  
}  
  
plusFour(3) // val res1: Int = 7
 
```

Rule 3/3 Lexical Scoping: Definitions of outer blocks are **visible** inside a block unless they are shadowed.

```scala
val a = 2  
def plusThree(b: Int) = {  
  a + b + 1 // a = 3  
}  
  
plusThree(1) //  val res1: Int = 4
```


# (3) Recursion

## About

:octocat: GitHub: All of the example code: [repo (link)](https://github.com/Victoria-Pinzhen-Liao/Functional-Programming)

:page_facing_up:  blog link:  https://purrgramming.life/cs/programming/fp/   :star:

-------------------------------------------

Topics
1. Recursion
2. Tail Recursion
3. Coursework solutions

-------------------------------------------

## Background
Recursion is the process of defining a problem (or the solution to a problem) in terms of (a simpler version of) itself.
For example, we can define the operation "find your way home" as Stop moving if you are at home.

image source: https://stackoverflow.com/questions/13242050/java-recursion-triangle-with-deviation
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1646007793273.png)

## Recursion
In Scala, recursive functions are functions that include calls to themselves in their definition, they

- do ***not***  always terminated
- require an explicit return type in Scala (the return type can be omitted in non-recursive functions, but it is required by the compiler for recursive functions)
-  are ***not*** introduced by a dedicated keyword

### Example: squareRoot

We will define in this session a function
```scala
/** Calculates the square root of parameter x */ 
def squareRoot(x: Double): Double = ... 
```

The classical way to achieve this is by successive approximations using Newton’s method.

To compute squareRoot(x):
- Start with an initial estimate y (let’s pick `y = 1`).
-  Repeatedly improve the estimate by taking the mean of y and x/y.

image source: https://blogs.sas.com/content/iml/2016/05/18/newtons-method-babylonian-square-root.html
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1646007812068.png)


Example: x = 2

|  Estimation  | Quotient  | Mean  |
|--------------------|--------------------|----------------|
| 1                  | 2 / 1=2            | 1.5            |
| 1.5                | 2 / 1.5=1.333      | 1.4167         |
| 1.4167             | 2 / 1.4167=1.4118  | 1.4142         |
| 1.4142             | ...            | ...      |

image source: https://demonstrations.wolfram.com/FindingATangentLineToAParabola/
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1646007910843.png)

So, let us
1. define a test to check for termination
2. define a function improve to improve an estimate
3. define a function that computes one iteration step
   -  Note that `squareRootIterator` is recursive; its right-hand side calls itself.
4. define the squareRoot function

```scala
import scala.math.{abs, pow, sqrt}  
  
// define the squareRoot function:  
def squareRoot(squareNum: Double) = {  
  // define what is "Good enough"  
  // Avoid magic numbers 
  val accuracy = 0.001  
  
  // define a test to check for terminatation:  
  def isGoodEnough(guessedSquareRoot: Double) =  
    abs(guessedSquareRoot * guessedSquareRoot - squareNum) < accuracy  
  
  // define a function improve to improve an estimate  
  def improve(guessedSquareRoot: Double) =  
    (guessedSquareRoot + squareNum / guessedSquareRoot) / 2  
  
 // define a function which computes one iteration step  
 // Note that `squareRootIterator` is recursive, 
 // its right-hand side calls itself.  

def squareRootIterator(guessedSquareRoot: Double): Double =  
    if (isGoodEnough(guessedSquareRoot)) guessedSquareRoot  
    else squareRootIterator(improve(guessedSquareRoot))  
  
  squareRootIterator(1.0)  
}  
  
// Results are not bad  
squareRoot(4)  
// val res0: Double = 2.0000000929222947  
squareRoot(2)  
// val res1: Double = 1.4142156862745097
``` 


### Limitation

**Double** not accurate: are infinite possible real numbers and an only finite number of bits  to represent these numbers, so:

- The isGoodEnough test is **not very precise** for small numbers
-  The isGoodEnough test is  **non-termination** for very large numbers.

Bad Examples
- 0.001 - not very precise
- 10^(50) - non-termination

```scala
// Bad example
squareRoot(0.001)  
// val res2: Double = 0.04124542607499115  

// Correct answer  
sqrt(0.001) 
// val res3: Double = 0.03162277660168379  

// -------------------------

val largeNumber: Double = pow(10, 50)  

// Correct answer  
sqrt(largeNumber) 
// val res4: Double = 1.0E25  

// Bad example
squareRoot(largeNumber) 
// Never terminate 
```




## Tail Recursion

### Definition

If a function **calls itself as its last action**, like the reatest common divisor, the function’s stack frame can be **reused** with  tail recursion.

In summary, a tail recursive function
- are **iterative** processes
- can be optimized by reusing the stack frame in Scala
- calls itself as its last action

### Tail Recursion Example

Example of tail recursion functions, i.e. - A recursive function that calls itself as its last action

Impl of the function that computes the greatest common divisor of two numbers using Euclid’s algorithm:

Please note: ***it calls itself as its last action***

 ```scala
// Euclid’s algorithm  
// Greatest Common Divisor
def gcd(a: Int, b: Int): Int = {  
  if b == 0 then a else gcd(b, a % b)  
}  
  
gcd(14, 21)// val res0: Int = 7  
  
//→ if 21 == 0 then 14 else gcd(21, 14 % 21)  
//→ if false then 14 else gcd(21, 14 % 21)  
//  → gcd(21, 14 % 21)  
//  → gcd(21, 14)  
//→ if 14 == 0 then 21 else gcd(14, 21 % 14)  
//  →→ gcd(14, 7)  
//  →→ gcd(7, 0)  
//→ if 0 == 0 then 7 else gcd(0, 7 % 0)  
//  → 7
```

### Non Tail Recursion Example

Example of non tail recursion functions, i.e. - A recursive function that does **not** call itself as its last action


Consider factorial:
```scala
def factorial(n: Int): Int =  
  if n == 0 then 1 else n * factorial(n - 1)  
  
factorial(4) // val res1: Int = 24  
  
//→ if 4 == 0 then 1 else 4 * factorial(4 - 1) 3-> →→ 4 * factorial(3)  
//  →→ 4 * (3 * factorial(2))  
//  →→ 4 * (3 * (2 * factorial(1)))  
//  →→ 4 * (3 * (2 * (1 * factorial(0)))  
//  →→ 4 * (3 * (2 * (1 * 1)))  
//  →→ 24
```


### @tailrec

Tail recurssion can be annotated with @tailrec so that the compiler will succeed only if it can verify that the function is indeed tail recursive, i.e. performance  optimization

```scala
import scala.annotation.tailrec  
@tailrec def gcd(a: Int, b: Int): Int = {  
  if b == 0 then a else gcd(b, a % b)  
}
```

Note: If we try to add `tailrec` to non tail recursive functions like `factorial`, we will get error
```scala
@tailrec \\ ERROR: Cannot rewrite recursive call: it is not in tail position  
def factorial(n: Int): Int =  
  if n == 0 then 1 else n * factorial(n - 1)
```

###  non @tailrec  -> @tailrec

We can change  non @tailrec  recursive functions to  @tailrec

```scala
@tailrec def factorialTailRec(n: Int, lastFactorial: Int): Int =  
  if n == 0 then lastFactorial else factorialTailRec(n - 1, n * lastFactorial)  

factorialTailRec(4, 1) // val res1: Int = 24
``` 

## W1 Coursework

###  Pascal's Triangle

The following pattern of numbers is called _Pascal's triangle_.

```scala
1  
1 1  
1 2 1  
1 3 3 1  
1 4 6 4 1  
...
```

The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it. Write a function that computes the elements of Pascal's triangle by means of a recursive process.

Do this exercise by implementing the pascal function, which takes a column c and a row r, counting from 0 and returns the number at that spot in the triangle. For example, `pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3.`

```scala
def pascal(col: Int, row: Int): Int = {  
  if (col == 0 && row == 0) 1 else if (col < 0 | row < 0) 0  
  else pascal(col - 1, row - 1) + pascal(col, row - 1)  
}
```

Testing

```scala
def main(args: Array[String]): Unit =  
  println("Pascal's Triangle")  
  for row <- 0 to 10 do  
 for col <- 0 to row do  
  print(s"${pascal(col, row)} ")  
    println()
```

Result
```scala
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
1 6 15 20 15 6 1 
1 7 21 35 35 21 7 1 
```


### Parentheses Balancing

Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String. For example, the function should return true for the following strings:

-   (if (zero? x) max (/ 1 x))

-   I told him (that it's not (yet) done). (But he wasn't listening)


The function should return false for the following strings:

-   : - )

-   ())(


The last example shows that it's not enough to verify that a string contains the same number of opening and closing parentheses.

Do this exercise by implementing the balance function. Its signature is as follows:

```scala
def balance(chars: List[Char]): Boolean
```

There are three methods on List[Char] that are useful for this exercise:

-   chars.isEmpty: Boolean returns whether a list is empty

-   chars.head: Char returns the first element of the list

-   chars.tail: List[Char] returns the list without the first element


**Hint**: you can define an inner function if you need to pass extra parameters to your function.

**Testing**: You can use the toList method to convert from a String to a List[Char]: e.g. `"(just an) example".toList.`

```scala
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
```

###  Counting Change

Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.

Do this exercise by implementing the countChange function  . This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:

```scala
def countChange(money: Int, coins: List[Int]): Int
```

Once again, you can make use of functions isEmpty, head and tail on the list of integers coins.

**Hint**: Think of the degenerate cases. How many ways can you give change for 0 dollars? How many ways can you give change for >0 dollars, if you have no coins?

```scala
def countChange(money: Int, coins: List[Int]): Int = {  
  if (money < 0 || coins.isEmpty) 0  
  else if (money == 0) 1  
  else {  
    val withFirstCoin = countChange(money - coins.head, coins)  
    val withoutFirstCoin = countChange(money, coins.drop(1))  
    withFirstCoin + withoutFirstCoin  
  }  
}
```