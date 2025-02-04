import java.util.*;

class Main {
  public static void main(String[] arg) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    printEach(0, numbers);
    printRev(0, numbers);
    System.out.println(sum(0, numbers));
    System.out.println(factorial(10));
    System.out.println(fibonacci(8));
  }

  static void printEach(int index, List<Integer> nums) {
  }

  static void printRev(int index, List<Integer> nums) {
  }

  static int sum(int index, List<Integer> nums) {
    return 0;
  }

  // https://en.wikipedia.org/wiki/Factorial
  static int factorial(int n) {
    return 0;
  }

  // https://en.wikipedia.org/wiki/Fibonacci_sequence
  static int fibonacci(int n) {
    return 0;
  }
}
