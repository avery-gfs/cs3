import os
import time

height = 6

def showRow(radius, sym):
  padding = " " * (height - radius)
  width = radius * 2 + 1
  return padding + sym * width + padding

def showRows(tower):
  numBlanks = height - len(tower) + 1
  blanks = [showRow(0, "░")] * numBlanks
  rows = [showRow(row, "▇") for row in reversed(tower)]
  return blanks + rows

def showTowers():
  sep = " " * (height + 1)
  combined = list(sep)

  for tower in towers:
    rows = showRows(tower)

    for (index, row) in enumerate(rows):
      combined[index] += row + sep[index]

  os.system("clear")

  for row in combined:
    print(row)

  time.sleep(0.2)

def solve(src, dest, depth):
  pass # Your code goes here!

tower = list(reversed(range(1, height + 1)))
towers = [tower, [], []]
showTowers()
solve(0, 2, height)
