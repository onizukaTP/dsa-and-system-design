package neetcode150;

public class MaxProfit {
    /**
     * Time: O(n^2)
     * Space: O(1)
     * 
     * @param prices
     * @return
     */
    public int MaxProfit1 (int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else
                maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
