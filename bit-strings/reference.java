import java.util.*;

class Main {
  public static void main(String[] arg) {
    for (var subset : subsets(0, "abcd")) {
      System.out.println(subset);
    }
  }

  static List<String> subsets(int index, String chars) {
    if (index >= chars.length()) {
      return List.of("");
    }

    var result = new ArrayList<String>();

    for (var subset : subsets(index + 1, chars)) {
      result.add(subset);
      result.add(chars.charAt(index) + subset);
    }

    return result;
  }
}
