package leetcode;

import java.util.Arrays;

/**
 * Created by SZ on 2017/10/22.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

     You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

     Return the maximum profit you can make.
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if(prices == null) return 0;
        int len = prices.length;
        int[] hold = new int[len + 1], //买入
                sold = new int[len + 1];//卖出
        Arrays.fill(hold, Integer.MIN_VALUE);
        for(int i = 0; i < len; i++) {
            hold[i + 1] = Math.max(sold[i] - prices[i], hold[i]);
            sold[i + 1] = Math.max(hold[i + 1] + prices[i] - fee, sold[i]);
        }
        return sold[len];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
        int[] arr = {1, 3, 2, 8, 4, 9};
        System.out.println(obj.maxProfit(arr, 2));//output:8
    }

}
