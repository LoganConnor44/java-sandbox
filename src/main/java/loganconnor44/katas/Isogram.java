package loganconnor44.katas;

import java.util.HashMap;
import java.util.Map;

/**
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.
 *
 * isIsogram "Dermatoglyphics" == true
 * isIsogram "aba" == false
 * isIsogram "moOse" == false -- ignore letter case
 */
public class Isogram {

    /**
     * Create a function scoped boolean so the class doesn't need to be remade every time.
     * Create a character count map that will have the character as the key and the number of occurences as the value.
     * If the character is already a key, increment the value by one (a ++ does not work for some reason).
     * If any values contains 2 break out of the loop and return false.
     * If the character is not present as a key in the map add it and initialize the value with 1.
     *
     * @param stringInQuestion The given string.
     * @return boolean
     */
    public Boolean isIsogram(String stringInQuestion) {
        Boolean isIsogram = true;
        Map<String, Integer> characterCount = new HashMap<>();
        for (char eachChar : stringInQuestion.toUpperCase().toCharArray()) {
            characterCount.computeIfPresent(String.valueOf(eachChar), (k, v) -> v + 1);
            if (characterCount.containsValue(2)) {
                isIsogram = false;
                break;
            }
            characterCount.putIfAbsent(String.valueOf(eachChar), 1);
        }
        return isIsogram;
    }
    
}