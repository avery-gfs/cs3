import time
import os

maze = """
█████████████████████████████████
█A█     █B█         █         █ █
█ █ ███ █ █ ███ █████ █ █████ █ █
█ █ █ █ █     █       █ █   █   █
█ █ █ █ ███████████ ███ █ █ █████
█   █ █     █     █ █ █   █     █
█ ███ █████ █ ███ █ █ ███████ █ █
█ █     █ █ █ █ █ █       █ █ █ █
█ █ ███ █ █ █ █ █ █████████ ███ █
█ █   █   █ █   █   █       █   █
█ ███ ███ █ ███ ███ █ ███████ █ █
█ █   █ █ █     █ █   █   █   █ █
█ █ ███ █ ███████ █████ █ █ ███ █
█ █   █ █       █   █   █ █ █ █ █
█ ███ █ ███████ █ █ █ ███ █ █ █ █
█     █           █   █     █   █
█████████████████████████████████
"""

board = [list(line) for line in maze.strip().split("\n")]

def search(r, c):
    time.sleep(0.02)
    os.system("clear")
    print("\n".join("".join(row) for row in board))

    match board[r][c]:
        case "B":
            return True
        case "█" | "▒":
            return False

    board[r][c] = "▒"

    result = (
        search(r - 1, c) or
        search(r, c + 1) or
        search(r + 1, c) or
        search(r, c - 1)
    )

    board[r][c] = " "
    return result

search(1, 1)
