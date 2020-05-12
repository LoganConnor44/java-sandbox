package loganconnor44.katas;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Same words are obviously the most similar ones. A word that needs one letter to be changed is more similar to another word that needs 2 (or more) letters to be changed. E.g. the mistyped term berr is more similar to beer (1 letter to be replaced) than to barrel (3 letters to be changed in total).
 *
 * Extend the dictionary in a way, that it is able to return you the most similar word from the list of known words.
 *
 * Code Examples:
 *
 * Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
 *
 * fruits.findMostSimilar("strawbery"); // must return "strawberry"
 * fruits.findMostSimilar("berry"); // must return "cherry"
 *
 * Dictionary things = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
 * things.findMostSimilar("coddwars"); // must return "codewars"
 *
 * Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
 * languages.findMostSimilar("heaven"); // must return "java"
 * languages.findMostSimilar("javascript"); // must return "javascript" (same words are obviously the most similar ones)
 *
 * I know, many of you would disagree that java is more similar to heaven than all the other ones, but in this kata it is ;)
 *
 * Additional notes:
 *
 * there is always exactly one possible correct solution
 */
public class Dictionary {

    private final String[] approvedWords;

    public Dictionary(String[] words) {
        this.approvedWords = words;
    }

    /**
     * Immediately sanitize the user's input and create a similarity hashmap.
     * Iterate through each of the known or approved system words.
     *      * If one word matches exactly, immediately return that word.
     *      * Identify the word that has the most characters: user input or system word
     *          * Create an offset for missing characters.
     *      * Initialize a similarity count.
     *      * Create a for-loop so each character within the word with the least amount of characters.
     *      * If the currently iterated character at position `i` matches the character in the companion string,
     *          increment the similarity counter by 1.
     * Locate the word with the highest similarity count from the previously created hashmap.
     * Return the string value within the map.
     *
     * @param userWord The word the user lazily entered.
     * @return String the most closely matches the user's input.
     */
    public String findMostSimilar(String userWord) {
        userWord = userWord.trim();
        HashMap<String, Integer> similarityMap = new HashMap<>();

        for (String approvedWord : this.approvedWords) {
            if (approvedWord.equals(userWord)) {
                return userWord;
            }

            String maxLengthString = userWord.length() >= approvedWord.length() ? userWord : approvedWord;
            String minLengthString = userWord.length() < approvedWord.length() ? userWord : approvedWord;

            int lengthDifference = maxLengthString.length() - minLengthString.length();
            int similarityCount = (-1) * lengthDifference;
            int startingPosition = 0;
            int range = 1;
            for (int i = 0; i < minLengthString.length(); i++) {
                String sub = maxLengthString.substring(startingPosition, startingPosition + range);

                if (!minLengthString.contains(sub)) {
                    startingPosition++;
                    range = 1;
                } else {
                    range++;
                    similarityCount++;
                    if (range != 1) {
                        similarityCount += range;
                    }
                }
            }
            similarityMap.put(approvedWord, similarityCount);
        }

        int maxSimilarities = Collections.max(similarityMap.values());
        List<String> maxSimilarityWords = similarityMap.entrySet().stream().filter(
            x -> x.getValue() == maxSimilarities
        ).map(Map.Entry::getKey).collect(Collectors.toList());

        return maxSimilarityWords.get(0);
    }
}