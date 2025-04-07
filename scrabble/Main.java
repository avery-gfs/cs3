import java.util.*;
import java.nio.file.*;

class Main {
    static Map<Character, Integer> letterPoints = Map.ofEntries(
        Map.entry('a', 1), Map.entry('b', 3), Map.entry('c', 3),
        Map.entry('d', 2), Map.entry('e', 1), Map.entry('f', 4),
        Map.entry('g', 2), Map.entry('h', 4), Map.entry('i', 1),
        Map.entry('j', 8), Map.entry('k', 5), Map.entry('l', 1),
        Map.entry('m', 3), Map.entry('n', 1), Map.entry('o', 1),
        Map.entry('p', 3), Map.entry('q', 10), Map.entry('r', 1),
        Map.entry('s', 1), Map.entry('t', 1), Map.entry('u', 1),
        Map.entry('v', 4), Map.entry('w', 4), Map.entry('x', 8),
        Map.entry('y', 4), Map.entry('z', 10)
    );

    public static void main(String[] args) throws Exception {
        var words = Files.readString(Path.of("alice.txt")).split(" ");
        var bestWord = getBest(words);
        
        System.out.println(bestWord);
        System.out.println(calcScore(bestWord));
    }

    // Calculate the scrabble score for a given word.
    // 
    // For example:
    //
    //   calcScore("problem")
    //
    // should return
    //
    //   13

    static Integer calcScore(String word) {
        return 0;
    }

    // Given an array of words, find the word with the highest scrabble score.
    // You may assume that the words array is non-empty.
    //
    // For example:
    //
    //   getBest(new String[] { "three", "body", "problem" })
    // 
    // should return
    //
    //   "problem"

    static String getBest(String[] words) {
        return null;
    }
}
