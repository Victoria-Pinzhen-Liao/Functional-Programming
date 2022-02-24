

# Introduction to Functional Programming [WIP]

## About  

:octocat: GitHub: All of the example code: [repo (link)](https://github.com/Victoria-Pinzhen-Liao/Functional-Programming)

:page_facing_up:  blog link: https://purrgramming.life/cs/os/parallel    :star:

-------------------------------------------

These are my lecture notes and code for Coursera online course [Functional Programming Principles in Scala](https://www.coursera.org/learn/scala-functional-programming/home/week/1) by Prof. Martin Odersky from École Polytechnique Fédérale de Lausanne (EPFL) (btw that's who created Scala )

-------------------------------------------

## Background 

**Paradigm** - In science, a paradigm describes distinct concepts or thought patterns in some scientific discipline. 
  
### Programming Paradigms 

 
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

 
 
###  Example: Complex number Theory

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

### Functional Contract

- A method with a  **functional contract**  will always return the same value to the same arguments.
- Have no other side effects (like storing files, printing, reading). 
- Thus, even if you mutate temporary values inside your function, it's still pure from the outside. 

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
------------

WIP 

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655296547.png)

## Reference
- (2022). Retrieved 23 February 2022, from https://www.coursera.org/learn/scala-functional-programming/lecture/EQ7BX/lecture-1-1-programming-paradigms
-  Washing your code: avoid mutation. (2022). Retrieved 23 February 2022, from https://blog.sapegin.me/all/avoid-mutation/#:~:text=Mutation%20may%20lead%20to%20unexpected,careful%20when%20reading%20the%20code.

 
