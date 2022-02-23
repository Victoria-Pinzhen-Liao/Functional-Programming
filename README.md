 

## About  

:octocat: GitHub: All of the example code are in this [repo (link)](https://github.com/Victoria-Pinzhen-Liao/Functional-Programming)

:page_facing_up:  blog link: https://purrgramming.life/cs/programming/fp/intro/   :star:

-------------------------------------------

These are my lecture notes and code for Coursera online course [Functional Programming Principles in Scala](https://www.coursera.org/learn/scala-functional-programming/home/week/1) from École Polytechnique Fédérale de Lausanne (EPFL)

-------------------------------------------

## Background 

**Paradigm** - In science, a paradigm describes distinct concepts or thought patterns in some scientific discipline. 
  
### Programming Paradigms 

 
![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655330430.png)


### Imperative programming 
- modifying mutable variables, 
- using assignments ( sets and/or re-sets the value stored in the storage location(s) denoted by a variable name)
- using control structures such as if-then-else, loops, break, continue, return. 

Example:  instruction sequences for a Von Neumann computer.

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655317849.png)

where 
- Mutable variables ≈ memory cells 
- Variable dereferences (used to access or manipulate data contained in memory location pointed to by a pointer) ≈ load instructions 
- Variable assignments ≈ store instructions 
- Control structures ≈ jumps

**Problem**: Hard to scale up ("Von Neumann" bottleneck) - " One tends to conceptualize data structures word-by-word. "

i.e.  Need to define high-level abstractions such as collections, polynomials, geometric shapes, strings, documents

### Theory 

A theory consists of
-  one or more data types
- operations on these types
-  laws that describe the relationships between values and operations
- 
Normally, a theory does **not** describe mutations

#### Terms

 

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655307025.png)

#### Theories without Mutation 

##### Example: Polynomials 

For instance the theory of polynomials defines the sum of two polynomials by laws such as: 

$$(a*x + b) + (c*x + d) = (a + c)*x + (b + d)$$


But it does not define an operator to change a coefficient while keeping the polynomial the same

Whereas in an imperative program one can write: 
```java
class Polynomial { double [] coefficient ; } 
Polynomial p = ...; 
p . coefficient [0] = 42;
```

##### Example: String Concatenation

The theory of strings defines a concatenation operator `++` which is associative: 

```scala
(a ++ b) ++ c = a ++ (b ++ c)
```
But it does not define an operator to change a sequence element while keeping the sequence the same

### Issue of Mutation

#### In Math
If we want to implement high-level concepts following their mathematical theories, there’s no place for mutation.
- The theories do not admit it. 
-  Mutation can destroy useful laws in the theories.

#### In CS
- Mutation is changing an object and is one common side effect in programming languages.
- Mutation may lead to unexpected and hard-to-debug issues, where data becomes incorrect somewhere, and you have no idea where it happens.
- Mutation makes code harder to understand: at any time, an array or object may have a different value, so we need to be very careful when reading the code.
- Mutation of function arguments makes the behavior of a function surprising.


### Functional Programming 
Functional programming (FP) means programming without mutable variables, assignments, loops, and other imperative control structures. 

i.e. FP means focusing on the functions and immutable data. 

#### Functional Contract
- A method that has a  **functional contract**  will always return the same value to the same arguments.
- Have no other side effects (like storing file, printing, reading). 
- Thus even if you mutate temporary values inside your function it's still pure from the outside. 

#### Benefits
Therefore, FP  allows

- concentrate on defining theories for operators expressed as functions
- avoid mutations
-  have powerful ways to abstract and compose functions
- functions can be values that are produced, consumed, and composed
-   no need to check two places to see all available variables

------------

WIP 

![file](https://purrgramming.life/wp-content/uploads/2022/02/image-1645655296547.png)

## Reference
- (2022). Retrieved 23 February 2022, from https://www.coursera.org/learn/scala-functional-programming/lecture/EQ7BX/lecture-1-1-programming-paradigms
-  Washing your code: avoid mutation. (2022). Retrieved 23 February 2022, from https://blog.sapegin.me/all/avoid-mutation/#:~:text=Mutation%20may%20lead%20to%20unexpected,careful%20when%20reading%20the%20code.

 
