class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }
}