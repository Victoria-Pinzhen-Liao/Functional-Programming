// Definitions can have parameters
def square(x: Double) = x * x

square(2)
square(5 + 4)
square(square(4))

// Function parameters come with their type,
// which is given after a colon
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

sumOfSquares(3, 4.6)
