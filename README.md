

#  (1) Principles of Functional Programming

## About  

:octocat: GitHub: All of the example code: [repo (link)](https://github.com/Victoria-Pinzhen-Liao/Functional-Programming)

:page_facing_up:  blog link:  https://purrgramming.life/cs/programming/fp/  :star:

-------------------------------------------

These are my lecture notes and code for Coursera online course [Functional Programming Principles in Scala](https://www.coursera.org/learn/scala-functional-programming/home/week/1) by Prof. Martin Odersky from École Polytechnique Fédérale de Lausanne (EPFL) (btw that's who created Scala )

-------------------------------------------

This blog answers 

1. What is functional programming?
2. Why functional programming?
3. Advantage of functional programming

-------------------------------------------

## Programming Paradigms 

**Paradigm** - In science, a paradigm describes distinct concepts or thought patterns in some scientific discipline. 
  


 
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655330430.png)


## Imperative Programming (with Mutation )
- modifying mutable variables, 
- using assignments ( sets and/or re-sets the value stored in the storage location(s) denoted by a variable name)
- using control structures such as if-then-else, loops, break, continue, return. 

Example:  instruction sequences for a Von Neumann computer.

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655317849.png)

where 
```scala
- Mutable variables ≈ memory cells 
- Variable dereferences (used to access or manipulate data contained in the memory location pointed to by a pointer) ≈ load instructions 
- Variable assignments ≈ store instructions 
- Control structures ≈ jumps
```

**Problem**: Hard to scale up ("Von Neumann" bottleneck) - " One tends to conceptualize data structures word-by-word. "

i.e.  Need to define high-level abstractions such as collections, polynomials, geometric shapes, strings, documents

 
 
###  Example: Complex Number Theory

#### Definition of Theory 

A theory consists of
-  one or more data types
- operations on these types
-  laws that describe the relationships between values and operations
- 
Typically, a theory does **not** describe mutations.

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645741123766.png)

For instance, the theory of complex number defines the sum of two complex numbers by laws such as: 

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645741136587.png)

where complex numbers are addends

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


### Issue of Mutation

#### In Math
There's no place for the mutation if we implement high-level concepts following their mathematical theories.
- The theories do not admit it. 
-  Mutation can destroy useful laws in the theories.

#### In CS
The mutation changes an object and is one common side effect in programming languages.
- Mutation may lead to unexpected and hard-to-debug issues, where data becomes incorrect somewhere, and you have no idea where it happens.
- Mutation makes code harder to understand: at any time, an array or object may have a different value, so we need to be very careful when reading the code.
- Mutation of function arguments makes the behaviour of a function surprising.

 

## Functional Programming (with Immutation)

### Definition 

**Restricted** :  A functional programming language is one which does ***not*** have 
- mutable variables
-  assignments, 
- or imperative control structures. 

**Wider** : a functional programming language focus on functions and immutable data structures.

### FP Languages

- Lisp, Scheme, Racket, Clojure 
-  SML, Ocaml, F# 
-  Haskell 
-  Scala 

Concepts and constructs from functional languages are also found in many traditional languages like Java.

### Functions in FP

Functions in a FP language are first-class citizens. This means 
-  they can be defined anywhere, including inside other functions
-  like any other value, they can be passed as parameters to functions and returned as results 
- as for other values, there exists a set of operators to compose functions
- i.e. functions can be values that are produced, consumed, and composed



### Benefits
 
 Reduce errors 
-   no need to check two places to see all available variables

 Increased developer productivity
 -  Shorter code 

More philosophical
- More mathematical 
-  Improve modularity 
- Higher-level abstractions

Morden
-  It’s an effective tool to handle concurrency and parallelism, on every scale
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

We can see that when adding two immutable complex numbers, the function will return a new complex number, and the original complex numbers (addends) won't change.

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

Functional programming is a bit like using a calculator 

An interactive shell (or [REPL, for Read-Eval-Print-Loop](https://docs.scala-lang.org/overviews/scala-book/scala-repl.html)) lets one write expressions and responds with their value.  Alternatively, you can use scala worksheet



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
-  ways to abstract expressions, which introduce a name for an expression by which it can then be referred to.

### Primitive 
In Scala, Primitive types are as in Java, but are written capitalized: 

$$
\begin{array}{ll}
\text { Int } & \text { 32-bit integers } \\
\text { Long } & \text { 64-bit integers } \\
\text { Float } & \text { 32-bit floating point numbers } \\
\text { Double } & \text { 64-bit floating point numbers } \\
\text { Char } & \text { 16-bit unicode characters } \\
\text { Short } & \text { 16-bit integers } \\
\text { Byte } & \text { 8-bit integers } \\
\text { Boolean } & \text { boolean values true and false }
\end{array}
$$
 

### Evaluation 

A non-primitive expression is evaluated as follows. 
1. Take the leftmost operator 
2.  Evaluate its operands (left before right) 
3.  Apply the operator to the operands 

A name is evaluated by replacing it with the right hand side of its definition 
The evaluation process stops once it results in a value


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

Function parameters come with their type,   which is given after a colon  

```scala
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)  
```



Applications of parameterized functions are evaluated in a similar way as operators: 
1. Evaluate all function arguments, from left to right 
2.  Replace the function application by the function’s right-hand side, and, at the same time 
3.  Replace the formal parameters of the function by the actual arguments

```scala
sumOfSquares(3, 2+2)
```

it's actually converted to 

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
- It can be applied to all expressions, as long as they have no side effects (like storing files, printing, reading).
- The substitution model is formalized in the `λ-calculus`, which gives a foundation for functional programming.

### Functional Contract

- A method with a  **functional contract**  will always return the same value to the same arguments.
- Have no other side effects (like storing files, printing, reading). 
- Thus, even if you mutate temporary values inside your function, it's still pure from the outside. 



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
We  prepend  _**=>**_  (rocket symbol) to its type.
 
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
 
 ### Result Compare 
Both strategies reduce to the same final values as long as
- the reduced expression consists of pure functions, and
- both evaluations terminate.

### Performance 

Say we have a function that takes 2 inputs , and  returns the square of the first input 
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

We want to examine the evaluation strategy and determine which one is faster (less steps) in these conditions:

#### Senario 1 

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

#### Senario 2 

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

#### Senario 3

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
Here call by name is faster

#### Senario 4

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


### Advantage
Call-by-value 
-  it evaluates every function argument only once
- avoids the repeated re-computation of argument expressions

Call-by-name 
- a function argument is not evaluated if the corresponding parameter is unused in the evaluation of the function body. 


### Termination

Call-by-name and call-by-value evaluation strategies reduce an expression to the same value, as long as both evaluations terminate. 

```
Q: But what if termination is not guaranteed?
```

If CBV evaluation of an expression `#e` terminates, then CBN evaluation of `#e` terminates, too. 
The other direction is not true

| Terminates? | CallByName | CallByValue | Possible? |
|-------------|------------|-------------|-----------|
| 1           | T          | T           | T         |
| 2           | F          | T           | F         |
| 3           | F          | F           | T         |
| 4           | T          | F           | T         |

#### Example

Find an expression that terminates under CBN but not under CBV

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





