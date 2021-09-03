package loganconnor44.katas;

public class BuyAndSellStock {
    /**
     * Create a local variable for the maxGain and the minimum price. Zero is the default gain and Integer max value is the default min price so we can retrieve virtually any value
     * If prices has one value or zero return 0 maxGain
     * Iterate through prices and if the current minPrice is less that the existing one set the new minPrice
     * If the minPrice is greater than the current delta find the difference and check if it is greater than the maxGain
     * If yes, set new maxGain
     * 
     * Alternative Solution works but takes too long
     * 
     * iterate backwards starting at index 1
     * is the next integer higher
     * if yes store in a method vaiable
     * continue to next until end of array and only keep the highest value from the method variable
     * 
     * @param prices int[]
     * @return int
     */
    public int maxProfit(int[] prices) {
        /**
         * 
         */
        int maxGain = 0;
        int minPrice = Integer.MAX_VALUE;

        if (prices.length < 2) {
            return maxGain;
        }

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxGain) {
                maxGain = prices[i] - minPrice;
            }
        } 
        return maxGain;
    }
}
