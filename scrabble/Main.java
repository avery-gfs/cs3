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
        var scores = calcScores(words);
        var bestWord = getBest(words, scores);
        
        System.out.println(bestWord);
        System.out.println(scores.get(bestWord));
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

    // Take an array of words and make a HashMap of scores for each word,
    // utilizing the calcScores method.
    // 
    // For example:
    //
    //   calcScores(new String[] { "three", "body", "problem" })
    //
    // should return
    //
    //   {problem=13, body=10, three=8}

    static HashMap<String, Integer> calcScores(String[] words) {
        return null;
    }

    // Given an array of words and a HashMap of scores, find the word
    // in words with the highest scrabble score. You may assume that
    // the words array is non-empty and that every word in the array has
    // a score entry in scores.
    //
    // For example:
    //
    //   getBest(
    //     new String[] { "three", "body", "problem" },
    //     new HashMap<>(Map.of("problem", 13, "body", 10, "three", 8))
    //   )
    // 
    // should return
    //
    //   "problem"

    static String getBest(String[] words, HashMap<String, Integer> scores) {
        return null;
    }
}
