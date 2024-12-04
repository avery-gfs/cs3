import java.util.*;

class Main {
  public static void main(String[] args) {
    // Starting in the top left corner of a `2 x 2` grid, and only being able to move
    // to the right and down, there are exactly `6` routes to the bottom right corner.
    //
    // How many such routes are there through a `20 x 20` grid?
    //
    // What if we block off some of the nodes (connecting points) in the grid. How
    // would we calculate the number of paths from the top left corner to the bottom
    // right given some set of blocked nodes?

    long[][] grid = new long[21][21];

    grid[0][0] = 1;

    for (int r = 0; r <= 20; r++) {
      for (int c = 0; c <= 20; c++) {
        if (r > 0) {
          grid[r][c] += grid[r - 1][c];
        }

        if (c > 0) {
          grid[r][c] += grid[r][c - 1];
        }
      }
    }

    System.out.println(grid[20][20]);
  }
}
