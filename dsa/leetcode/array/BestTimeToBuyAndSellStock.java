/**
 * #121 Leetcode
 * 
 * Approach - one pass solution using minimum price tracking
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
*/

package dsa.leetcode.array;

class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            sellPrice = prices[i];
            if (sellPrice > buyPrice) {
                profit = Math.max(profit, (sellPrice - buyPrice));
            }
        }
        return profit;
    }
}