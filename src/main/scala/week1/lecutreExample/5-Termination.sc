def firstByValue(x: Int, y: Int) = x
def firstByName(x: => Int, y: => Int) = x

def loop = loop

firstByName(1, loop)
firstByValue(1, loop)
