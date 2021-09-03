package loganconnor44.katas;

import java.util.Map;
import java.util.HashMap;

public class FruitBaskets {
    public int totalFruit(int[] fruits) {
        // set a starting index, a running index, the total number of fruit, and
        //// a baskets variable
        int startIndex = 0;
        int runner = 0;
        int totalFruit = 0;
        //Map<TypeOfFruit, IndexPosition>
        Map<Integer, Integer> baskets = new HashMap<>();

        while (runner < fruits.length) {
            if (baskets.size() < 3) {
                baskets.put(fruits[runner], runner++);
            } 
            if (baskets.size() >= 3) {
                // default initial value as end of array
                int basketOne = fruits.length - 1;
                for (int position : baskets.values()) {
                    // retrieves the lowest index position in the map
                    basketOne = Math.min(basketOne, position);
                }

                startIndex = basketOne + 1;
                baskets.remove(fruits[basketOne]);
            }

            int treeRange = runner - startIndex;
            totalFruit = Math.max(totalFruit, treeRange);
        }

        return totalFruit;
    }
}
