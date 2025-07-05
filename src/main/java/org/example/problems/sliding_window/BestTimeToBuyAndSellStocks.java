package org.example.problems.sliding_window;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        System.out.println(bestTimeToBuyAndSellStocks(new int[] {10,1,5,6,7,2,3,12}));
    }

    public static int bestTimeToBuyAndSellStocks(int[] prices) {
        int i = 0;
        int j = 1;
        int profit = 0;

        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                profit = Math.max(profit, prices[j] - prices[i]);
            } else {
                i = j;
            }
            j++;
        }

        return profit;
    }
}
