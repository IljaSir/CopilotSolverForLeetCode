class Solution {
    public int[] finalPrices(int[] prices) {
        
        int[] result = new int[prices.length];
        int minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            minIndex = i + 1;
            while (minIndex < prices.length && prices[minIndex] > prices[i]) {
                minIndex++;
            }
            if (minIndex == prices.length) {
                result[i] = prices[i];
            } else {
                result[i] = prices[i] - prices[minIndex];
            }
        }
        return result;
    }
}