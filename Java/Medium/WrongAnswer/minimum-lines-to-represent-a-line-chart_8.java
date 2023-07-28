class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int cur = 1;
            for (int j = 0; j < i; ++j) {
                if (stockPrices[j][1] <= stockPrices[i][1]) {
                    cur = Math.max(cur, dp[j] + 1);
                }
            }
            dp[i] = cur;
            res = Math.max(res, cur);
        }
        return res;
    }
}