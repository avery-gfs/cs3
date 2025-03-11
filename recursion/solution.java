import java.util.*;

class Main {
  public static void main(String[] arg) {
    System.out.println(factorial(10)); // 3628800

    System.out.println(fibonacci(8));  // 21

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println(sum(0, numbers)); // 55
  }

  // https://en.wikipedia.org/wiki/Factorial
  static int factorial(int n) {
    if (n == 0) {
      return 1; // Base case
    }

    return n * factorial(n - 1); // Recursive step
  }

  // https://en.wikipedia.org/wiki/Fibonacci_sequence
  static int fibonacci(int n) {
    if (n < 2) {
      return n;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  static int sum(int index, List<Integer> nums) {
    if (index == nums.size()) {
      return 0;
    }

    return nums.get(index) + sum(index + 1, nums);
  }
}
