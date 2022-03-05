def squareOfFirstElementByValue(x: Int, y: Int) = x * x
def squareOfFirstElementByName(x: => Int, y: => Int) = x * x

squareOfFirstElementByValue(7, 8)
squareOfFirstElementByValue(3 + 4, 8)
squareOfFirstElementByValue(7, 2 * 4)
squareOfFirstElementByValue(3 + 4, 2 * 4)

squareOfFirstElementByName(7, 8)
squareOfFirstElementByName(3 + 4, 8)
squareOfFirstElementByName(7, 2 * 4)
squareOfFirstElementByName(3 + 4, 2 * 4)