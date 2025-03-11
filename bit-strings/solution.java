import java.util.*;

class Main {
  public static void main(String[] args) {
    // bitStrings(4) should produce the following:
    //
    // 0000
    // 0001
    // 0010
    // 0011
    // 0100
    // 0101
    // 0110
    // 0111
    // 1000
    // 1001
    // 1010
    // 1011
    // 1100
    // 1101
    // 1110
    // 1111

    for (var bitStr : bitStrings(4)) {
      System.out.println(bitStr);
    }
  }

  // Implement the method bitStrings below, which returns a list
  // containing each possible binary string of length len.
  //
  // A binary string is a string that contains a sequence of bits
  // (binary digits), which are each either 0 or 1.
  //
  // There are 2^n possible binary strings of length n.
  //
  // You should use recursion to implement bitStrings.
  //
  // Things to consider:
  // 
  // - How can we generate a list of binary strings of length n given
  //   a list of binary strings of length n-1?
  //
  // - What value of len should trigger the base case for bitStrings?
  //
  // - What should bitStrings return in the base case?
  // 
  // If you get bitStrings working, you can challenge yourself by trying
  // to implement the bitStrings method *without* using recursion. Which
  // solution do you find simpler, recursive or non-recursive?

  static List<String> bitStrings(int len) {
    if (len == 0) {
      return List.of("");
    }

    var results = new ArrayList<String>();

    for (var subString : bitStrings(len - 1)) {
      results.add(subString + "0");
      results.add(subString + "1");
    }

    return results;
  }

  // Iterative (non-recursive) implementation
  
  static List<String> bitStringsIter(int len) {
    var results = List.of("");

    while (len-- > 0) {
      var lastResults = results;
      results = new ArrayList<String>();

      for (var subString : lastResults) {
        results.add(subString + "0");
        results.add(subString + "1");  
      }
    }

    return results;
  }
}
