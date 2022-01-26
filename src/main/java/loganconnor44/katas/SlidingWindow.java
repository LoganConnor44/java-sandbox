package loganconnor44.katas;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /**
     * Time Complexity: O(N * K)
     * ‘N’ is the number of elements in the input array.
     * @param items
     * @param k
     * @return
     */
    public double[] bruteForce(int[] items, int k) {
        double[] result = new double[items.length - k + 1];
        for (int i = 0; i <= items.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += items[j];
            }
            result[i] = sum / k;
        }
        return result;
    }

    /**
     * Time Complexity: O(N)
     * 
     * @param items
     * @param k
     * @return
     */
    public double[] create(int[] items, int k) {
        final int arrayOffset = 1;
        final int windowMaxSize = k - arrayOffset;
        final int numberOfWindowPositions = items.length - k + 1;

        double[] result = new double[numberOfWindowPositions];
        double windowSum = 0;
        int windowBack = 0;

        for (int windowFront = 0; windowFront < items.length; windowFront++) {
            windowSum += items[windowFront];

            if (windowFront >= windowMaxSize) {
                result[windowBack] = windowSum / k;
                windowSum -= items[windowBack];
                windowBack++;
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(N)
     * 
     * @param items
     * @param k
     * @return
     */
    public int maxSumOfContiguousSub(int[] items, int k) {
        final int arrayOffset = 1;
        final int windowMaxSize = k - arrayOffset;

        int maxSum = 0;
        int windowSum = 0;
        int windowBack = 0;

        for (int windowFront = 0; windowFront < items.length; windowFront++) {
            windowSum += items[windowFront];

            if (windowFront >= windowMaxSize) {
                if (windowSum > maxSum) {
                    maxSum = windowSum;
                }
                windowSum -= items[windowBack];
                windowBack++;
            }
        }
        return maxSum;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param items
     * @param k
     * @return
     */
    public int lengthOfSmallestArrayWithSumGreaterThanOrEqualToK(int[] items, int k) {
        int minLength = 0;
        int windowSum = 0;
        int windowBack = 0;

        for (int windowFront = 0; windowFront < items.length; windowFront++) {
            int windowLength = windowFront - windowBack;
            windowSum += items[windowFront];

            if (windowSum >= k) {
                minLength = windowLength;
                
                while (windowSum >= k) {
                    windowSum -= items[windowBack];
                    windowBack++;
                }
            }
        }        

        return minLength;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(X)
     * 
     * @param givenString
     * @param x
     * @return
     */
    public int lengthOfLongestSubStringWithNoMoreThanXDistinctCharacters(String givenString, int x) {
        final int arrayOffset = 1;
        int maxUniqueLength = 0;
        Map<Character, Integer> characterFrequency = new HashMap<>();
        int windowBack = 0;

        for (int windowFront = 0; windowFront < givenString.length(); windowFront++) {
            char frontChar = givenString.charAt(windowFront);
            int additionOrDefault = characterFrequency.getOrDefault(frontChar, 0) + 1;
            characterFrequency.put(frontChar, additionOrDefault);
            while (characterFrequency.size() > x) {
                char backChar = givenString.charAt(windowBack);
                int subtractFromCurrentValue = characterFrequency.get(backChar) - 1;
                characterFrequency.put(backChar, subtractFromCurrentValue);
                if (characterFrequency.get(backChar) == 0) {
                    characterFrequency.remove(backChar);
                }
                windowBack++;
            }
            int windowSize = windowFront - windowBack + arrayOffset;
            maxUniqueLength = Math.max(maxUniqueLength, windowSize);
        }
        return maxUniqueLength;
    }

    public int fruitIntoBaskets(char[] fruits) {
        int maxFruit = 0;
        int windowBack = 0;
        Map<Character, Integer> fruitBasket = new HashMap<>();

        for (int windowFront = 0; windowFront < fruits.length; windowFront++) {
            final char currentFruit = fruits[windowFront];
            final int defaultOrAddition = fruitBasket.getOrDefault(currentFruit, 0) + 1;
            fruitBasket.put(currentFruit, defaultOrAddition);

            while (fruitBasket.size() > 2) {
                final char fruitToRemove = fruits[windowBack];
                final int difference = fruitBasket.get(fruitToRemove) - 1;
                fruitBasket.put(fruitToRemove, difference);
                if (fruitBasket.get(fruitToRemove) == 0) {
                    fruitBasket.remove(fruitToRemove);
                }
                windowBack++;
            }

            final int arrayOffset = 1;
            final int windowLength = windowFront - windowBack + arrayOffset;

            maxFruit = Math.max(maxFruit, windowLength);
        }

        return maxFruit;
    }

    public int longestSubstringWithDistinctCharacters(String input) {
        int maxSubDistinct = 0;
        int windowBack = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        for (int windowFront = 0; windowFront < input.length(); windowFront++) {
            Character leader = input.charAt(windowFront);
            int defaultOrAddition = characterCount.getOrDefault(leader, 0) + 1;
            characterCount.put(leader, defaultOrAddition);
            while (characterCount.get(leader) > 1) {
                Character caboose = input.charAt(windowBack);
                int difference = characterCount.get(caboose) - 1;
                if (difference < 1) {
                    characterCount.remove(caboose);
                } else {
                    characterCount.put(caboose, difference);
                }
                windowBack++;
            }
            maxSubDistinct = Math.max(maxSubDistinct, characterCount.size());
        }
        return maxSubDistinct;
    }
}
