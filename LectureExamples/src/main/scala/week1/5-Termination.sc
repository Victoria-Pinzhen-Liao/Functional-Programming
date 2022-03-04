def firstByValue(x: Int, y: Int) = x
def firstByName(x: => Int, y: => Int) = x

def loop: Int = {
  while (true) {
    Thread.sleep(1000)
  }
  1
}

firstByName(1, loop)
firstByValue(1, loop)
