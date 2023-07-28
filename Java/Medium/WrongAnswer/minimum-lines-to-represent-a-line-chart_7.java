class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (stockPrices[j][1] <= stockPrices[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}