package loganconnor44.katas;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enough is enough!
 * Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now they want to show Charlie their entire collection. However, Charlie doesn't like this sessions, since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times. He tells them that he will only sit during the session if they show the same motive at most N times. Luckily, Alice and Bob are able to encode the motive as a number. Can you help them to remove numbers such that their list contains each number only up to N times, without changing the order?
 *
 * Task
 * Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering. For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
 *
 * Example
 * EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
 * EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]
 */
public class Recurrence {
    private final int[] givenAmountToReduce;

    public Recurrence(int[] itemsToReduce) {
        this.givenAmountToReduce = itemsToReduce;
    }

    /**
     * Begin by first creating a map that we will use as a key-value pair. The key being the integer that we pass
     * in and the value being the number of times it occurs.
     * Iterate through the `givenAmountToReduce` variable to create the frequency map.
     * Convert the `givenAmountToReduce` variable to a list to we have the ability to remove items and reverse the order.
     * Reverse the order of `elementsList` so we can remove the last items first.
     * Iterate through `frequency` and identify any occurrences that is greater than our `maxOccurrences`.
     * If items are found, enter a for-loop and iterate the difference of the actual number of occurrences and the max
     * number of occurrences.
     * Example:
     *      Only allow 4  -> actual is 12  we would then need to delete the extra 8
     *                  12   -    4                                       =       8
     * Flip the list so it's now back to the original order.
     *
     * @param maxOccurrences The max number of times an item can occur.
     * @return List<Integer> The sanitized collection.
     */
    public List<Integer> deleteNth(int maxOccurrences) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Arrays.stream(this.givenAmountToReduce)
            .forEach( x -> {
                frequency.computeIfPresent(x, (origNumber, numberOfOccurrences) -> numberOfOccurrences + 1);
                frequency.putIfAbsent(x, 1);
            });
        List<Integer> elementsList = Arrays.stream(this.givenAmountToReduce).boxed().collect(Collectors.toList());

        Collections.reverse(elementsList);
        frequency.forEach((origNumber, numberOfOccurrences) -> {
            if (numberOfOccurrences > maxOccurrences) {
                for (int i = 1; i <= numberOfOccurrences - maxOccurrences; i++) {
                    elementsList.remove(origNumber);
                }
            }
        });
        Collections.reverse(elementsList);

        return elementsList;
    }
}
