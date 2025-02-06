import java.util.*;

// Given a "maze" string, where A is the start, B is the end, and █ is
// a wall, find a path from A to B and mark the path with ▒ characters.

class Maze {
  public static void main(String[] args) {
    var maze = """
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
    """;

    // Split the maze string into lines
    // (ignore blank lines at start and end)
    var lines = maze.trim().split("\n");

    // Make a 2D array of chars to represent maze
    var board = new char[lines.length][];
    var index = 0;

    for (var line : lines) {
      // Split each line into a char array and use to populate the board
      board[index++] = line.toCharArray();
    }

    // Assume we know that the start A character is always at row 1 column 1.
    // Run the search from this starting position.
    search(board, 1, 1);
  }

  // The search method takes three parameters:
  //
  // - The board object
  // - The row and column of the current search location
  //
  // The search method returns true if we find a path to B
  // that goes through the point (r, c) and false otherwise.
  //
  // If a path is found then search updates board with a ▒ symbol
  // at point (r, c) and subsequent path locations.
  // 
  // Additionally, it's ok for `search` to temporarily modify the
  // characters in `board`; just make sure it "cleans up" when it's
  // done. You should use these characters to determine how the
  // search should proceed.
  // 
  // Make sure that search doesn't do extra work and keep searching
  // after a valid path is found.

  public static boolean search(char[][] board, int r, int c) {
    // Add 20ms delay to visualize search process in action
    try { Thread.sleep(20); } catch (InterruptedException err) {}

    // Clear the console
    System.out.print("\033c");

    // Print out the current board
    for (var row : board) {
      System.out.println(new String(row));
    }

    // Your code goes here !!

    return false; // Placeholder
  }
}
