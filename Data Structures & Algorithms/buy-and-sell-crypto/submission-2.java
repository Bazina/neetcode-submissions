class Solution {
    public int maxProfit(int[] prices) {
            int maxProfit = 0;

            int i = 0;
            int j = 1;

            while (i < j && j < prices.length) {
                if (prices[i] <= prices[j]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                } else {
                    i = j;
                }
                j++;
            }

            return maxProfit;
        }
}
