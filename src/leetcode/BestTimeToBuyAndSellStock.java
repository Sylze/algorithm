package leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int k, int[] prices) {
        int[] hold = new int[k + 1],
              sold = new int[k + 1];
        Arrays.fill(hold, Integer.MIN_VALUE);
        for(int price : prices) {
            for(int j = k; j > 0; j--) {
                sold[j] = Math.max(sold[j], hold[j] + price);
                hold[j] = Math.max(hold[j], sold[j - 1] - price);
            }
        }
        return sold[k];
    }

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
		int[] prices = {1, 2};
		System.out.println(obj.maxProfit(1, prices));

	}

}
